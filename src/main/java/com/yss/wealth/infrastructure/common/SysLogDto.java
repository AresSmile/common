package com.yss.wealth.infrastructure.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
*
* @author:zhuhongmin
* @date:2020/4/10
* @description: 系统日志DTO
**/
@Data
@Accessors(chain = true)
@ApiModel("系统日志DTO")
public class SysLogDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("用户编码")
    private String userCode;
    @ApiModelProperty("MAC地址")
    private String mac;
    @ApiModelProperty("请求URL")
    private String url;
    @ApiModelProperty("类名")
    private String className;
    @ApiModelProperty("方法名")
    private String methodName;
    @ApiModelProperty("参数JSON")
    private String param;
    @ApiModelProperty("返回JSON")
    private String returnObj;
    @ApiModelProperty("开始时间")
    private Date startDateTime;
    @ApiModelProperty("结束时间")
    private Date endDateTime;
    @ApiModelProperty("耗时(毫秒)")
    private Long costMillis;
    @ApiModelProperty("结果(成功或失败)")
    private boolean status;
    @ApiModelProperty("错误信息")
    private String errorMsg;
}
