package com.yss.wealth.infrastructure.common;

import com.alibaba.fastjson.JSONObject;
import com.yss.wealth.infrastructure.util.RequestUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 审核记录信息
 *
 * @author Zhou
 * @version 1.0
 * @created 27-4月-2020 16:11:55
 */
@Builder
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class CheckDataInfoDTO implements Serializable {

    public static CheckDataInfoDTO getCheckDataInfoDTO(InsertCheckDataParamDTO insertCheckDataParam) {
        return CheckDataInfoDTO.builder()
                .relaId(insertCheckDataParam.getRelaId()).menuCode(RequestUtil.getReqMenuId()==null? "33":RequestUtil.getReqMenuId()).createUserId(RequestUtil.getUserCode()==null? "lja":RequestUtil.getUserCode())
                .submitterDepartment("002").submitterRole(RequestUtil.getRole()==null?"R001":RequestUtil.getRole()).feignName(insertCheckDataParam.getFeignName())
                .checkActionType(insertCheckDataParam.getCheckActionType()).checkKey(insertCheckDataParam.getCheckKey()).methodName(insertCheckDataParam.getMethodName())
                .checkStatus(CheckStatus.UNCHECK.getKey()).checkDataDetailInfoDTOList(insertCheckDataParam.getCheckDataDetailInfos())
                .build();
    }

    /**
     * 变更前后数值
     */
    @ApiModelProperty(value = "变更前后数值")
    private List<CheckDataDetailInfoDTO> checkDataDetailInfoDTOList;

//    /**
//     * 变更后数据
//     */
//    @ApiModelProperty(value = "变更后数据")
//    private String afterChangeData;
//    /**
//     * 变更前数据
//     */
//    @ApiModelProperty(value = "变更前数据")
//    private String beforeChangeData;
    /**
     * 待审核数据的操作类型：
     * 0 - 新增
     * 1 - 删除
     * 2 - 修改
     * 3 - 查询
     */
    @ApiModelProperty(value = "待审核数据的操作类型", required = true)
    private int checkActionType;
    /**
     * 记录待审核信息关键值，当某条数据有待审核项时，不能发起新的审核
     * <p>
     * 产品信息：产品代码
     * 机构信息：机构代码
     * 网点信息：机构代码+‘_’+网点代码
     */
    @ApiModelProperty(value = "待审核信息关键值", required = true)
    private String checkKey;
    /**
     * 0-待审核
     * 1-审核通过
     * 2-驳回
     */
    @ApiModelProperty(value = "审核状态")
    private int checkStatus;
    /**
     * 审核时间
     */
    @ApiModelProperty(value = "审核时间")
    private String checkTime;
    /**
     * 审核用户ID
     */
    @ApiModelProperty(value = "审核用户ID")
    private String checkUserId;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private String createTime;
    /**
     * 创建用户ID
     */
    @ApiModelProperty(value = "创建用户ID")
    private String createUserId;
    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private long id;
    /**
     * 菜单编码
     */
    @ApiModelProperty(value = "菜单编码", required = true)
    private String menuCode;
    /**
     * 原提交记录的ID
     */
    @ApiModelProperty(value = "原提交记录的ID", required = true)
    private long relaId;
    /**
     * 备注，复核意见也记录在此字段
     */
    @ApiModelProperty(value = "备注")
    private String remark;
    /**
     * 提交人部门
     */
    @ApiModelProperty(value = "提交人部门")
    private String submitterDepartment;
    /**
     * 提交人角色
     */
    @ApiModelProperty(value = "提交人角色")
    private String submitterRole;

    /**
     * feign全路径名
     */
    private String feignName;

    /**
     * feign全路径名
     */
    private String methodName;

    /**
     * 跳转菜单地址
     */
    private String menuAddress;
}