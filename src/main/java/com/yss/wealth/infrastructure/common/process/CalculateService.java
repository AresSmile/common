package com.yss.wealth.infrastructure.common.process;

import java.math.BigDecimal;

/**
 * @author libihui
 * @version 1.0 2020/9/22
 * @description： 费用计算业务
 */
public interface CalculateService<T> {
    /**
     * 费用计算
     *
     * @param t
     * @return
     */
    BigDecimal calculateFee(T t);
}
