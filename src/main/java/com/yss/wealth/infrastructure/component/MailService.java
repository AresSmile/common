package com.yss.wealth.infrastructure.component;

import com.alibaba.fastjson.JSONObject;
import com.yss.wealth.infrastructure.common.dto.MailInfoDTO;
import com.yss.wealth.infrastructure.constant.MqConst;
import com.yss.wealth.infrastructure.enums.MailSendTypeEnum;
import com.yss.wealth.infrastructure.enums.MailTemplateEnum;
import com.yss.wealth.infrastructure.util.Assert;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author:zhuhongmin
 * @date:2020/6/16
 * @description:
 **/
@Component
public class MailService {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    /**
     * 邮件发送接口
     *
     * @param sendTypeEnum 发送方式
     * @param receiver     接收人
     * @param template     邮件模板
     * @param data         邮件模板中的数据
     */
    public void sendMail(MailSendTypeEnum sendTypeEnum, String receiver, MailTemplateEnum template, Map<String, String> data) {
        MailInfoDTO mailInfoDTO = new MailInfoDTO();
        mailInfoDTO.setMailModel(template)
                .setReceiver(receiver)
                .setSendType(sendTypeEnum)
                .setData(data);
        this.sendMail(mailInfoDTO);
    }

    public void sendMail(MailInfoDTO mailInfoDTO) {
        Assert.notNull(rabbitTemplate, "容器中未找到mq的bean，请检查mq配置是否完整");
        Assert.notNull(mailInfoDTO, "邮件DTO实体为空，无法发送邮件");
        Assert.notNull(mailInfoDTO.getSendType(), "邮件发送方式不能为空");
        Assert.notEmpty(mailInfoDTO.getReceiver(), "接收人不能为空");
        Assert.notNull(mailInfoDTO.getMailModel(), "邮件发送模板不能为空");
        Assert.notNull(mailInfoDTO.getData(), "邮件发送数据不能为空");

        rabbitTemplate.convertAndSend(MqConst.MAIL_KEY, JSONObject.toJSONString(mailInfoDTO));
    }
}
