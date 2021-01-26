package com.yss.wealth.infrastructure.common;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yss.wealth.infrastructure.enums.AuditStateEnum;
import com.yss.wealth.infrastructure.util.PrimaryKeyUtil;
import com.yss.wealth.infrastructure.util.RequestUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author libihui
 * @version 1.0 2020/2/20
 * @description：PO基类
 */
@Setter
@Getter
@Accessors(chain = true)
public class BasePO implements Serializable {

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String createUserId;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private Long id;

    /**
     * 修改人
     */
    @ApiModelProperty("修改人")
    private String updateUserId;

    /**
     * 审核状态
     */

    /**
     * 审核状态
     */
    @ApiModelProperty("审核状态")
    private String auditState;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 删除标记
     */
    @ApiModelProperty("删除标记")
    private String deleteFlag;

    /**
     * 审核人
     */
    @ApiModelProperty("审核人")
    private String auditUserId;

    /**
     * 审核时间
     */
    @ApiModelProperty("审核时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date auditTime;


    @ApiModelProperty("审核原因")
    private String auditReason;

    /**
     * 插入前填充id、创建人字段
     */
    public void preSave() {
        this.setId(PrimaryKeyUtil.generateId());
        this.setCreateUserId(RequestUtil.getUserCode());
        this.setCreateTime(DateUtil.date());
    }

    /**
     * 更新前填充更新人和更新日期
     */
    public void preUpdate() {
        this.setUpdateUserId(RequestUtil.getUserCode());
        this.setUpdateTime(DateUtil.date());
    }

    /**
     * 需要审核的PO对象，增删改操作之前填充审核状态(待审核)
     */
    public void preAudit() {
        this.setAuditState(AuditStateEnum.UN_CHECK.getCode());
    }

    /**
     * 审核通过
     */
    public void audit() {
        this.setAuditTime(DateUtil.date());
        this.setAuditUserId(RequestUtil.getUserCode());
        this.setAuditState(AuditStateEnum.CHECKED.getCode());
    }

    /**
     * 若无需复核，则默认已审核，且不填充审核人
     */
    public void defaultAudit() {
        this.setAuditState(AuditStateEnum.CHECKED.getCode());
    }

    /**
     * 插入前填充id、创建人字段
     */
    public void preSaveAudit() {
        if (ObjectUtil.isNull(this.getId())) {
            this.setId(PrimaryKeyUtil.generateId());
        }
        this.setCreateUserId(RequestUtil.getUserCode());
        this.setCreateTime(DateUtil.date());

        //设置审核状态为通过
        this.audit();
    }
}
