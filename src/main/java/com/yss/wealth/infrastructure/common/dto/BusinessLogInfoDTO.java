package com.yss.wealth.infrastructure.common.dto;

import com.yss.wealth.infrastructure.common.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel("")
public class BusinessLogInfoDTO extends BasePO {
    @ApiModelProperty("日志id")
    private Long logId;

    @ApiModelProperty("日志信息")
    private String logInfo;

    @ApiModelProperty("日志对象className")
    private String logClassName;

}