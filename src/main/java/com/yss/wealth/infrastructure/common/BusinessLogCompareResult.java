package com.yss.wealth.infrastructure.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
*
* @author:zhuhongmin
* @date:2020/5/6
* @description:
**/
@Data
@Accessors(chain = true)
@ApiModel("业务日志对比结果对象")
public class BusinessLogCompareResult {
    @ApiModelProperty("上一次记录对象")
    private Object oldObj;

    @ApiModelProperty("现在的业务对象")
    private Object nowObj;

    @ApiModelProperty("发生改变的变量列表")
    private List<String> changeFieldList;
}
