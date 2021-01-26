package com.yss.wealth.infrastructure.common.dto;

import com.yss.wealth.infrastructure.annotation.ParamApi;
import com.yss.wealth.infrastructure.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class SseMessageDTO extends BaseDTO {
    @ApiModelProperty("发送类型，TO_USER--发送给指定用户，TO_ROLE-发送给指定角色")
    private String sendType;

    @ApiModelProperty("发送模块 0：权限 1：交易 2：产品 3：账户")
//    @ParamApi(required = true,message = "发送模块不能为空")
    private String senderModule;

    @ApiModelProperty("消息类型 SYSTEM_ANNOUNCE:系统公告 BUSINESS_REMIND：业务提醒")
    @ParamApi(required = true,message = "消息类型不能为空")
    private String messageType;

    @ApiModelProperty("优先级 HIGH：高 MID：中 LOW：低")
    @ParamApi(required = true,message = "优先级不能为空")
    private String messagePriority;

    @ApiModelProperty("接收人")
    @ParamApi(required = true,message = "接收人不能为空")
    private String receiver;

    @ApiModelProperty("消息内容")
    @ParamApi(required = true,message = "消息内容不能为空")
    private String messageContent;
}
