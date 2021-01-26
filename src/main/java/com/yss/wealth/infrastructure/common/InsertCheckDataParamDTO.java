package com.yss.wealth.infrastructure.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 包名称： com.yss.wealth.infrastructure.common
 * 类名称：InsertCheckDataParamDTO
 * 类描述：构建CheckDataInfoDTO参数
 * 创建人：@author LiangJianAn
 * 创建时间：2020/5/14 20:14
 */
@Builder
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class InsertCheckDataParamDTO {
    private Long relaId;
    private String feignName;
    private int checkActionType;
    private String checkKey;
    private String methodName;
    private List<CheckDataDetailInfoDTO> checkDataDetailInfos;
}
