package com.yss.wealth.infrastructure.util;

import com.yss.wealth.infrastructure.common.WarningException;

/**
 * 包名称： com.yss.wealth.infrastructure.util
 * 类名称：IdcardCheckUtil
 * 类描述：身份证强校验工具类
 * 创建人：@author LiangJianAn
 * 创建时间：2020/8/26 17:41
 */
public class IdcardCheckUtil {

    /**
     * 身份证强校验--true:符合；false:格式错误
     * @param idCard
     * @return
     */
    public static boolean checkIdcard(String idCard) {
        if(StringUtil.isEmpty(idCard)) {
            throw WarningException.builder().message("身份证证件号码不能为空").build();
        }

        //校验身份证长度
        if (idCard.length() != 18) {
            return false;
        }

        //校验身份证格式
        for (int i = 0; i < idCard.length() - 1; i++) {
            if (i < 17 && (idCard.charAt(i) - '0' > 9 || idCard.charAt(i) - '0' < 0)) {
                return false;
            } else if (i == 17 && (idCard.charAt(i) - '0' > 9 || idCard.charAt(i) - '0' < 0 || idCard.charAt(i) != 'X')) {
                return false;
            }
        }


        //校验身份证生日
        //出生日期校验
        Integer year = Integer.valueOf(idCard.substring(6, 10));
        Integer month = Integer.valueOf(idCard.substring(10, 12));
        Integer day = Integer.valueOf(idCard.substring(12, 14));
        boolean leapYear = (0 == year % 400) || (0 != year % 100 && 0 == year % 4);

        if (month > 12 || month < 1) {
            return false;
        }
        if (day > 31 || day < 1) {
            return false;
        }
        if (4 == month || 6 == month || 9 == month || 11 == month) {
            if (day > 30) {
                return false;
            }
        } else if (2 == month) {
            if (day > (28 + (leapYear ? 1 : 0))) {
                return false;
            }
        }

        //校验身份证校验位
        int pos = 0;
        int[] r = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        char[] code = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        for (int i = 0; i < 17; i++) {
            pos += (idCard.charAt(i) - '0') * r[i];
        }
        pos = pos % 11;
        return code[pos] == idCard.charAt(17);
    }
}
