package com.yss.wealth.infrastructure.constant;

public interface MqConst {
    /**
     * 系统日志mq路由
     */
    String SYS_LOG_KEY = "rabbitmq_ta.syslog";
    /**
     * sse站内消息mq路由
     */
    String SSE_MESSAGE_KEY = "rabbitmq_ta.sseMessage";
    /**
     * 业务日志mq路由
     */
    String BUSINESS_LOG_KEY = "ta-business-log";

    /**
     * 邮件mq路由
     */
    String MAIL_KEY = "rabbitmq_ta.mail";

    /**
     * 流程消息mq路由
     */
    String PROCESS_MESSAGE_KEY = "rabbitmq_ta.process_message";

    /**
     * 流程mq路由
     */
    String PROCESS_KEY = "rabbitmq_ta.process";

    /**
     * 流程mq路由——账户域
     */
    String PROCESS_ACCOUNT_KEY = "rabbitmq_ta.account";

    /**
     * 流程mq路由——交易域
     */
    String PROCESS_DEAL_KEY = "rabbitmq_ta.deal";

    /**
     * 流程mq路由——工具域
     */
    String PROCESS_TOOL_KEY = "rabbitmq_ta.tool";

    /**
     * 流程数据清算-账户申请
     */
    String PROCESS_DATA_CLEAR_01 = "rabbitmq_ta.dataClear01";

    /**
     * 流程数据清算-其他申请
     */
    String PROCESS_DATA_CLEAR_23 = "rabbitmq_ta.dataClear23";

    /**
     * 流程数据清算-交易申请
     */
    String PROCESS_DATA_CLEAR_03 = "rabbitmq_ta.dataClear03";

    /**
     * 大数据导入清算
     */
    String BIG_DATA_CLEAR = "rabbitmq_ta.bigDataClear";

}
