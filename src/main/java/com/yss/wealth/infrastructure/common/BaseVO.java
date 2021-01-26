package com.yss.wealth.infrastructure.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author libihui
 * @version 1.0 2020/1/16
 * @description：VO基类，在mapper返回数据时，继承该类可动态封装结果值
 */
@Data
public class BaseVO implements IBaseVO {

    /**
     * 创建人
     */
    private String createUserId;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 主键
     */
    private String id;

    /**
     * 修改人
     */
    private String updateUserId;

    /**
     * 审核状态
     */
    private String auditState;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    /**
     * 删除标记
     */
    private String deleteFlag;

    /**
     * 审核人
     */
    private String auditUserId;

    /**
     * 审核时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date auditTime;

    /**
     * 审核原因
     */
    private String auditReason;
}
