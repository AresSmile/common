package com.yss.wealth.infrastructure.common;

import com.yss.wealth.infrastructure.common.dto.QueryDTO;
import com.yss.wealth.infrastructure.constant.SearchControlTypeConstants;
import com.yss.wealth.infrastructure.util.CollectionUtil;
import com.yss.wealth.infrastructure.util.DateUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author libihui
 * @version 1.0 2020/1/15
 * @description：Controller 查询条件父类
 */
@ApiModel("查询条件父类")
public class SearchCondition implements Serializable {
    @ApiModelProperty(value = "第几页", dataType = "int", required = true, example = "1")
    private Integer pageNum = 1; // 查询结果分页参数：第几页
    @ApiModelProperty(value = "每页数据行数", dataType = "int", required = true, example = "10")
    private Integer pageSize = 10; // 查询结果分页参数：每页数据条数

    @ApiModelProperty(value = "排序Map#key-排序字段名，value-排序方式##asc-正序，desc-降序", dataType = "Map", example = "10")
    private Map<String, String> orderMap;

    @ApiModelProperty(value = "自定义查询参数列表", dataType = "Map")
    private List<QueryDTO> fieldList;

    @ApiModelProperty(value = "Sql查询器拼好的sql语句")
    private String extraSpliceSql;

    @ApiModelProperty(hidden = true)
    private Map<String, String> orderMapToLine;
    /**
     * 自定义查询条件拼接sql
     */
    @ApiModelProperty(hidden = true)
    private String spliceSql;

    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    //简单的sql关键字匹配
    private static Pattern keywordPattern = Pattern.compile(".*(select|update|delete|order by|desc|;|from).*");


    public SearchCondition() {
    }

    public String getExtraSpliceSql() {
        return extraSpliceSql;
    }

    public void setExtraSpliceSql(String extraSpliceSql) {
        if (extraSpliceSql != null && keywordPattern.matcher(extraSpliceSql).matches()){
            throw new MessageException("sql中存在非法字符，请检查字符");
        }
        this.extraSpliceSql = extraSpliceSql;
    }

    public Map<String, String> getOrderMapToLine() {
        HashMap<String, String> map = new HashMap<>();
        if(MapUtils.isEmpty(this.getOrderMap())){
            return null;
        }
        this.getOrderMap().forEach(
                (key, value) -> {
                    String keyLine = humpToLine(key);
                    if(value != null && !"".equals(value)){
                        map.put(keyLine,value);
                    }
                }
        );
        return map;
    }

    public String getSpliceSql(){
        spliceSql = this.spliceSql(this.getFieldList());
        return spliceSql;
    }

    /**
     * 自定义查询条件拼接查询条件sql（注意：目前只支持单表）
     * @param fieldList
     * @return
     */
    private String spliceSql(List<QueryDTO> fieldList){
        if(CollectionUtil.isEmpty(fieldList)) return null;
        List<String> resultSqlList = new ArrayList<>();
        //遍历查询条件，根据查询控件拼接查询sql
        fieldList.forEach(field ->{
            switch (field.getControlType()){
                case SearchControlTypeConstants.SELECT://单选
                    if(StringUtils.isNotBlank(field.getSelectValue()))
                        resultSqlList.add(field.getName()+"='"+field.getSelectValue()+"'");
                    break;
                case SearchControlTypeConstants.INPUT://输入框
                    if(StringUtils.isNotBlank(field.getInputValue()))
                        resultSqlList.add(field.getName()+"='"+field.getInputValue()+"'");
                    break;
                case SearchControlTypeConstants.RANGE_PICKER://日期区间
                    //排除开始日期大于结束日期的查询条件
                    if(field.getRangePickerStartDate()!=null&&field.getRangePickerEndDate()!=null){
                        if (field.getRangePickerStartDate().getTime()-field.getRangePickerEndDate().getTime()>0)
                            throw new NoticeException("日期范围错误","未定义");
                    }

                    if(field.getRangePickerStartDate()!=null)
                        resultSqlList.add(field.getName()+">='"+ DateUtil.parseDateToStr(field.getRangePickerStartDate(),"yyyy-MM-dd") +"'");
                    if(field.getRangePickerEndDate()!=null)
                        resultSqlList.add(field.getName()+"<='"+ DateUtil.parseDateToStr(field.getRangePickerEndDate(),"yyyy-MM-dd") +"'");
                    break;
                case SearchControlTypeConstants.DATE_PICKER://单个日期
                    if(field.getDatePickerValue()!=null)
                        resultSqlList.add(field.getName()+"='"+ DateUtil.parseDateToStr(field.getDatePickerValue(),"yyyy-MM-dd") +"'");
                    break;
                case SearchControlTypeConstants.TREE_SELECT://多选
                    //为tree多选数据加上引号
                    List<String> treeValues = new ArrayList<>();
                    field.getTreeSelectValue().forEach(tree ->{
                        treeValues.add("'"+tree+"'");
                    });
                    //拼接成in的形式
                    String treeSelectValue = StringUtils.join(treeValues,",");
                    resultSqlList.add(field.getName()+" in ("+ treeSelectValue +")");
                    break;
                case SearchControlTypeConstants.INPUT_NUMBER://数值区间
                    //排除开始数值大于结束数值的可能
                    if(field.getInputNumberStartValue()!=null && field.getInputNumberEndValue()!=null){
                        if(field.getInputNumberStartValue().compareTo(field.getInputNumberEndValue())>0 )
                            throw new NoticeException("数值区间范围错误","未定义");
                    }
                    if(field.getInputNumberStartValue()!=null)
                        resultSqlList.add(field.getName()+">="+field.getInputNumberStartValue());
                    if(field.getInputNumberEndValue()!=null)
                        resultSqlList.add(field.getName()+"<="+field.getInputNumberEndValue());
                    break;
                case SearchControlTypeConstants.RATE_INPUT_NUMBER://费率数值区间
                    if(field.getInputNumberStartValue()!=null && field.getInputNumberEndValue()!=null){
                        if(field.getInputNumberStartValue().compareTo(field.getInputNumberEndValue())>0 )
                            throw new NoticeException("数值区间范围错误","未定义");
                    }
                    //费率数值，后台需要除100
                    if(field.getInputNumberStartValue()!=null)
                        resultSqlList.add(field.getName()+">="+field.getInputNumberStartValue().divide(BigDecimal.TEN.multiply(BigDecimal.TEN),8, RoundingMode.HALF_UP));
                    if(field.getInputNumberEndValue()!=null)
                        resultSqlList.add(field.getName()+"<="+field.getInputNumberEndValue().divide(BigDecimal.TEN.multiply(BigDecimal.TEN),8, RoundingMode.HALF_UP));
                    break;
                default:
                    break;
            }
        });
        String resultSql = resultSqlList.size()>0?StringUtils.join(resultSqlList," and "):"";
        return resultSql;
    }

    /**
     * 驼峰字段名转下划线小写字段名
     * 注意：仅用于前端字段排序时使用,若数据库字段与前端传参字段不符合驼峰命名规范，另行处理
     * @param str
     * @return
     */
    private static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public List<QueryDTO> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<QueryDTO> fieldList) {
        this.fieldList = fieldList;
    }

    public Map<String, String> getOrderMap() {
        return orderMap;
    }

    public void setOrderMap(Map<String, String> orderMap) {
        this.orderMap = orderMap;
    }

    public SearchCondition(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        if (pageNum == null || pageNum.equals(0)) {
            return 1;
        }
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize.equals(0)) {
            return 1;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
