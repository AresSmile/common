package com.yss.wealth.infrastructure.constant;

/**
 * 包名称： com.yss.wealth.infrastructure.constant
 * 类名称：WorkbenchRedisConst
 * 类描述：工作台统计修改数据  对应redis前缀
 * 创建人：@author LiangJianAn
 * 创建时间：2020/12/23 16:56
 */
public interface WorkbenchRedisConst {

    //工作台统计标识
    String WORKBENCH_STATISTICS = "workbench_statistics_";

    //储存数据修改：产品
    String PRD = "prd_";

    //储存数据修改：机构
    String ORG = "org_";

    //储存数据修改：系统参数
    String SYS = "sys_";

}
