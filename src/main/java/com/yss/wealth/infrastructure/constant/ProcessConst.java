package com.yss.wealth.infrastructure.constant;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.google.common.collect.Lists;
import com.yss.wealth.infrastructure.util.SpringContextUtil;
import com.yss.wealth.infrastructure.util.StringUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @Author: Zhoupeng
 * @Date: 2020/8/19 14:03
 * @Description: 流程处理常量
 */
public class ProcessConst {

    /********流程实例执行状态【begin】********/
    //执行中
    public static final String PROCESS_INSTANCE_EXECUTR_STATE_0 = "0";
    //终止
    public static final String PROCESS_INSTANCE_EXECUTR_STATE_1 = "1";
    //已完成
    public static final String PROCESS_INSTANCE_EXECUTR_STATE_2 = "2";
    /********流程实例执行状态【end】********/

    /********批次状态【begin】********/
    //未开始-系统参数控制【是否自动执行】
    //public static final String BATCH_STATUS_0 = "4";
    //运行中
    public static final String BATCH_STATUS_0 = "0";
    //已暂停
    public static final String BATCH_STATUS_1 = "1";
    //已停止
    public static final String BATCH_STATUS_2 = "2";
    //运行完成
    public static final String BATCH_STATUS_3 = "3";
    /********批次状态【end】********/

    /********任务状态【begin】********/
    //未开始
    public static final String PROCESS_TASK_STATUS_0 = "0";
    //正在处理中
    public static final String PROCESS_TASK_STATUS_1 = "1";
    //已完成
    public static final String PROCESS_TASK_STATUS_2 = "2";
    //出现异常
    public static final String PROCESS_TASK_STATUS_3 = "3";
    /********任务状态【end】********/


    /********前端展示流程步骤状态【begin】********/
    //未开始
    public static final String PRECESS_STEP_STATUS_0 = "0";
    //部分完成
    public static final String PRECESS_STEP_STATUS_1 = "1";
    //已完成
    public static final String PRECESS_STEP_STATUS_2 = "2";
    //已停止
    public static final String PRECESS_STEP_STATUS_3 = "3";
    //出现异常
    public static final String PRECESS_STEP_STATUS_4 = "4";
    /********流程步骤状态【end】********/


    /********流程是否可执行【begin】********/
    //否
    public static final String PRECESS_LOCK_0 = "0";
    //是
    public static final String PRECESS_LOCK_1 = "1";
    /********流程是否可执行【end】********/

    /********是否支持自动清算【begin】********/
    //否
    public static final String AUTOMATIC_FLAG_0 = "0";
    //是
    public static final String AUTOMATIC_FLAG_1 = "1";
    /********是否支持自动清算【end】********/


    /********分批模式【begin】********/
    //不分批
    public static final String TASK_MODE_00 = "00";
    //分产品
    public static final String TASK_MODE_01 = "01";
    //分销售商
    public static final String TASK_MODE_10 = "10";
    //分销售商分产品
    public static final String TASK_MODE_11 = "11";
    /********分批模式【end】********/


    /********批次类型【begin】********/
    //按销售商分批
    public static final String BATCH_TYPE_0 = "0";
    //按产品分批
    public static final String BATCH_TYPE_1 = "1";
    //按管理人分批
    public static final String BATCH_TYPE_2 = "2";
    //不分批
    public static final String BATCH_TYPE_9 = "9";
    /********批次类型【end】********/


    /********执行模式【begin】********/
    //人工执行
    public static final String EXEC_MODE_0 = "0";
    //自动执行
    public static final String EXEC_MODE_1 = "1";
    /********执行模式【end】********/


    /********查询标志【begin】********/
    //账户
    public static final String QUERY_FLAG_1 = "1";
    //交易
    public static final String QUERY_FLAG_2 = "2";
    /********查询标志【end】********/


    /********数据清算状态【begin】********/
    //可修改（未清算
    public static final String CLEDAR_STATUS_0 = "0";
    //不可修改（已清算）
    public static final String CLEDAR_STATUS_1 = "1";
    /********数据清算状态【end】********/


    /********日清算流程【begin】********/
    //账户申请失败确认处理
    public static final String TASK_CODE_FAILCONFIRM = "FailConfirm";
    //交易申请失败确认处理
    public static final String TASK_CODE_DEALFAILCONFIRM = "DealFailConfirm";
    /********日清算流程【begin】********/

    /********数据操作类型【begin】********/
    //插入
    public static final String OPERATION_TYPE_I = "I";
    //更新
    public static final String OPERATION_TYPE_U = "U";
    //删除
    public static final String OPERATION_TYPE_D = "D";
    /********数据操作类型【end】********/

    // 默认批处理数量2000
    public static final int DEFAULT_BATCH_NUM = 2000;

    public static Integer getBatchNum() {
        try {
            Class<?> basicFeignClass = Class.forName("com.yss.ta.basic.feign.BasicFeignClient");
            Object basicFeignClient = SpringContextUtil.getBean(basicFeignClass);
            Method getParamMap = ReflectUtil.getMethod(basicFeignClass, "getParamMap", List.class);
            Map paramMap = (Map) getParamMap.invoke(basicFeignClient, Lists.newArrayList(SysParamConst.BATCH_NUM));
            String batchNum = (String) paramMap.get(SysParamConst.BATCH_NUM);
            return StringUtil.isEmpty(batchNum) ? DEFAULT_BATCH_NUM : Integer.parseInt(batchNum);
        } catch (Exception e) {
            return DEFAULT_BATCH_NUM;
        }

    }

    /**
     * 获取异步清算开关
     * @return
     */
    public static boolean getAsyncClear() {
        try {
            Class<?> basicFeignClass = Class.forName("com.yss.ta.basic.feign.BasicFeignClient");
            Object basicFeignClient = SpringContextUtil.getBean(basicFeignClass);
            Method getParamMap = ReflectUtil.getMethod(basicFeignClass, "getParamMap", List.class);
            Map paramMap = (Map) getParamMap.invoke(basicFeignClient, Lists.newArrayList(SysParamConst.ASYNC_CLEAR));
            String asyncClear = (String) paramMap.get(SysParamConst.ASYNC_CLEAR);
            return CommonConst.YES.equals(asyncClear);
        } catch (Exception e) {
            return false;
        }

    }
}
