package com.yss.wealth.infrastructure.common;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author libihui
 * @version 1.0 2020/1/15
 * @description：分页数据
 */
@ApiModel("分页信息")
public class NewPageInfo<T> extends PageInfo<T> {
    public NewPageInfo() {
        super();
    }

    public NewPageInfo(List<T> list) {
        super(list);
    }

    @ApiModelProperty(value = "当前第几页")
    public int getPageNum() {
        return super.getPageNum();
    }

    @ApiModelProperty(value = "每页数据条数")
    public int getPageSize() {
        return super.getPageSize();
    }

    @ApiModelProperty(value = "当前页数据条数")
    public int getSize() {
        return super.getSize();
    }

    @ApiModelProperty(value = "当前页起始行")
    public int getStartRow() {
        return super.getStartRow();
    }

    @ApiModelProperty(value = "当前页结束行")
    public int getEndRow() {
        return super.getEndRow();
    }

    @ApiModelProperty(value = "数据总条行数")
    public long getTotal() {
        return super.getTotal();
    }

    @ApiModelProperty(value = "数据总页数")
    public int getPages() {
        return super.getPages();
    }

    @ApiModelProperty(value = "返回数据json")
    public List<T> getList() {
        return super.getList();
    }

    @ApiModelProperty(value = "上一页")
    public int getPrePage() {
        return super.getPrePage();
    }

    @ApiModelProperty(value = "下一页")
    public int getNextPage() {
        return super.getNextPage();
    }

    @ApiModelProperty(value = "是否第一页")
    public boolean isIsFirstPage() {
        return super.isIsFirstPage();
    }

    @ApiModelProperty(value = "是否最后一页")
    public boolean isIsLastPage() {
        return super.isIsLastPage();
    }

    @ApiModelProperty(value = "是否有上一页")
    public boolean isHasPreviousPage() {
        return super.isHasPreviousPage();
    }

    @ApiModelProperty(value = "是否有下一页")
    public boolean isHasNextPage() {
        return super.isHasNextPage();
    }

    @JsonIgnore
    public int getNavigatePages() {
        return super.getNavigatePages();
    }

    @JsonIgnore
    public int[] getNavigatepageNums() {
        return super.getNavigatepageNums();
    }

    @JsonIgnore
    public int getNavigateFirstPage() {
        return super.getNavigateFirstPage();
    }

    @JsonIgnore
    public int getNavigateLastPage() {
        return super.getNavigateLastPage();
    }

    /**
     * 返回值类型转换。如从mapper层返回的对象和service层需返回的对象类型相同则无需调用此方法
     *
     * @param clz
     * @param <R>
     * @return
     */
    public <R> NewPageInfo<R> convert(Class clz) {
        NewPageInfo<R> result = new NewPageInfo<>();
        BeanUtils.copyProperties(this, result);

        List<R> resultList = JSON.parseArray(JSON.toJSONString(this.getList()), clz);
        result.setList(resultList);

        return result;
    }

    /**
     * 对于非从数据库加载的分页数据，手动设置分页信息
     *
     * @param cond
     */
    public void setNewPageInfo(SearchCondition cond) {
        int startRow = (cond.getPageNum() - 1) * cond.getPageSize() + 1;
        this.setStartRow(startRow);
        this.setEndRow(startRow + cond.getPageSize() - 1);
        long pages = this.getTotal() / cond.getPageSize();
        pages = this.getTotal() % cond.getPageSize() == 0 ? pages : pages + 1;
        this.setPages((int) pages);
        this.setPrePage(cond.getPageNum() - 1);
        this.setNextPage(this.getPages() > cond.getPageNum() ? cond.getPageNum() + 1 : 0);
        this.setIsFirstPage(cond.getPageNum() == 1);
        this.setIsLastPage(this.getPages() == cond.getPageNum());
        this.setHasNextPage(!this.isIsLastPage());
        this.setHasPreviousPage(!this.isIsFirstPage());
    }
}
