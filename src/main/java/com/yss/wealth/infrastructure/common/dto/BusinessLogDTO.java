package com.yss.wealth.infrastructure.common.dto;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiModel("业务日志流转对象")
@Data
@Accessors(chain = true)
public class BusinessLogDTO implements Serializable {

    @ApiModelProperty("业务id")
    private String businessId;

    @ApiModelProperty("操作人")
    private String operationUser;

    @ApiModelProperty("日志类型，取字典")
    private Integer logType;

    @ApiModelProperty("操作人角色")
    private String operationRole;

    @ApiModelProperty("操作类型")
    private Integer operationType;

    @ApiModelProperty("操作时间")
    private Date operationTime;

    @ApiModelProperty("菜单id")
    private String menuId;

    @ApiModelProperty("mac地址")
    private String macPath;

    @ApiModelProperty("业务信息")
    private List<BusinessLogInfoDTO> logInfoDTOS;

    public void setLogInfos(List<Object> infos) {
        List<BusinessLogInfoDTO> logInfos = new ArrayList<>();
        infos.forEach(info -> {
            BusinessLogInfoDTO businessLogInfoDTO = new BusinessLogInfoDTO();
            businessLogInfoDTO.setLogClassName(info.getClass().getName())
                    .setLogInfo(JSONObject.toJSONString(info));
            logInfos.add(businessLogInfoDTO);
        });

        this.logInfoDTOS = logInfos;
    }
}
