package com.yss.wealth.infrastructure.common.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Zhoupeng
 * @Date: 2020/8/27 13:52
 * @Description:
 */
@Data
public class TaskDTO {

    /**执行ID**/
    private String executeId;

    /**流程分组**/
    private String processGroup;

    /**流程步骤代码**/
    private String processCode;

    /**批次编号**/
    private String batchId;

    /**任务代码**/
    private String taskCode;

    /**任务名称**/
    private String taskName;

    /**任务关键值**/
    private String taskKey;

    /**分批模式**/
    private String taskMode;

    /**任务状态**/
    private String taskStatus;

    /**服务对应的class**/
    private String serviceClass;

    /**服务对应的method**/
    private String serviceMethod;

    /**产品代码**/
    private List<String> listPrdCode = new ArrayList<>();

    /**机构代码**/
    private List<String> listOrgCode = new ArrayList<>();

}
