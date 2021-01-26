package com.yss.wealth.infrastructure.constant;

/**
 * @Author: Zhoupeng
 * @Date: 2020/9/16 15:50
 * @Description: 日清算流程常量
 */
public class DayClearConst {

    /********流程分组【begin】********/
    public static final String PROCESS_GROUP_DAYCLEAR = "DayClear";
    /********流程分组【end】********/

    /********任务代码【begin】********/
    //日初始化
    public static final String TASK_CODE_DAYINIT = "DayInit";
    //估值行情数据导入
    public static final String TASK_CODE_NAVIMP = "NavImp";
    //销售商数据导入
    public static final String TASK_CODE_ORGIMP = "OrgImp";
    //行情导出
    public static final String TASK_CODE_NAVEXP = "NavExp";
    //销售商确认数据导出
    public static final String TASK_CODE_ORGEXP = "OrgExp";
    //行情复核
    public static final String TASK_CODE_NAVCHECK = "NavCheck";
    //产品拆分
    public static final String TASK_CODE_PRDSPLIT = "PrdSplit";
    //存续期规模控制
    public static final String TASK_CODE_PRDSIZE = "PrdSize";
    //募集期规模控制
    public static final String TASK_CODE_PRDIPOSIZE = "PrdIpoSize";
    //产品成立
    public static final String TASK_CODE_PRDFOUND = "PrdFound";
    //产品分红
    public static final String TASK_CODE_PRDDIVIDEND = "PrdDividend";
    //业绩提成
    public static final String TASK_CODE_PRDACHIEVEMENT = "PrdAchievement";
    //产品清盘
    public static final String TASK_CODE_PRDLIQUIDATION = "PrdLiquidation";
    /********任务代码【end】********/
}
