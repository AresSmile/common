package com.yss.wealth.infrastructure.component;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.yss.wealth.infrastructure.common.dto.SseMessageDTO;
import com.yss.wealth.infrastructure.constant.MqConst;
import com.yss.wealth.infrastructure.enums.SseMessagePriorityEnum;
import com.yss.wealth.infrastructure.enums.SseMessageSendTypeEnum;
import com.yss.wealth.infrastructure.enums.SseMessageTypeEnum;
import com.yss.wealth.infrastructure.util.Assert;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * sse站内消息服务
 *
 * @author:zhuhongmin
 * @date:2020/6/5
 * @description:
 **/
public class SseMessageService {
    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 默认发送方式为用户
     */
    private SseMessageSendTypeEnum defaultSendType = SseMessageSendTypeEnum.TO_USER;

    /**
     * 默认消息类型为业务提醒
     */
    private SseMessageTypeEnum defaultMessageType = SseMessageTypeEnum.BUSINESS_REMIND;

    /**
     * 默认消息优先级为低优先级
     */
    private SseMessagePriorityEnum defaultMessagePriority = SseMessagePriorityEnum.LOW;


    /**
     * 发送消息，默认给指定用户发送低优先级，普通的业务提醒消息
     *
     * @param receiver
     * @param message
     */
    public void sendMessage(String receiver, String message) {
        Assert.notEmpty(receiver, "消息接受人不能为空");
        Assert.notEmpty(message, "消息内容不能为空");
        this.sendMessage(defaultSendType,defaultMessageType,defaultMessagePriority,receiver,message);
    }

    /**
     * 可以指定发送方式，发送低优先级的业务提醒消息
     *
     * @param sendType 发送类型
     * @param receiver 接受方
     * @param message  消息
     */
    public void sendMessage(SseMessageSendTypeEnum sendType, String receiver, String message) {
        Assert.notNull(sendType, "发送方式不能为空");
        Assert.notEmpty(receiver, "消息接受人不能为空");
        Assert.notEmpty(message, "消息内容不能为空");
        this.sendMessage(sendType,defaultMessageType,defaultMessagePriority,receiver,message);
}

    /**
     * 自定义消息
     *
     * @param sendType        发送方式
     * @param messageType     消息类型
     * @param messagePriority 消息优先级
     * @param receiver        接收方
     * @param message         消息内容
     */
    public void sendMessage(SseMessageSendTypeEnum sendType, SseMessageTypeEnum messageType, SseMessagePriorityEnum messagePriority, String receiver, String message) {
        Assert.notNull(sendType, "发送方式不能为空");
        Assert.notEmpty(receiver, "消息接受人不能为空");
        Assert.notNull(messageType, "消息类型不能为空");
        Assert.notEmpty(message, "消息内容不能为空");
        Assert.notNull(messagePriority, "消息优先级不能为空");
        SseMessageDTO sseMessage = new SseMessageDTO();
        sseMessage.setSendType(sendType.getType())
                .setSenderModule(applicationName)
                .setMessageType(ObjectUtil.isNull(messageType)?defaultMessageType.getType():messageType.getType())
                .setMessagePriority(ObjectUtil.isNotNull(messagePriority)?messagePriority.getType():defaultMessagePriority.getType())
                .setReceiver(receiver)
                .setMessageContent(message);
        rabbitTemplate.convertAndSend(MqConst.SSE_MESSAGE_KEY, JSONObject.toJSONString(sseMessage));
    }
}
