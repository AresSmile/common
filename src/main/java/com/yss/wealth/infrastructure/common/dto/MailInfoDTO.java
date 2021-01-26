package com.yss.wealth.infrastructure.common.dto;

import com.yss.wealth.infrastructure.enums.MailSendTypeEnum;
import com.yss.wealth.infrastructure.enums.MailTemplateEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.Map;
@ApiModel("邮件信息DTO")
@Data
@Accessors(chain = true)
public class MailInfoDTO {
    @ApiModelProperty("邮件模板类型")
    private MailTemplateEnum mailModel;

    @ApiModelProperty("收件人")
    private String receiver;

    @ApiModelProperty("邮件发送方式")
    private MailSendTypeEnum sendType;

    @ApiModelProperty("抄送人")
    private String linkReceiver;

    @ApiModelProperty("数据，用于替换模板中的变量")
    private Map<String,String> data;
}
