package com.yss.wealth.infrastructure.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author: Zhoupeng
 * @Date: 2020/9/16 15:34
 * @Description:
 */
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProcessDTO {

    @ApiModelProperty("流程key")
    private String processKey;

    @ApiModelProperty("销售机构代码")
    private String orgCode;

    @ApiModelProperty("产品代码")
    private String prdCode;
}
