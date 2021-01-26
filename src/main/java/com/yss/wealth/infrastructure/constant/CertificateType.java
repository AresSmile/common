package com.yss.wealth.infrastructure.constant;

import cn.hutool.core.util.ObjectUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: chengrui
 * @Date: 2020/7/6 14:51
 * @Version 1.0
 */
public class CertificateType {
    private static final Map<String, Map<String, String>> CERTIFICATE_TYPE_MAP = new HashMap<>();

    static {
        // 个人证件类型
        Map<String, String> personMap = new HashMap<>();
        personMap.put("0", "身份证");
        personMap.put("1", "护照");
        personMap.put("2", "军官证");
        personMap.put("3", "士兵证");
        personMap.put("4", "港澳来往内地通行证");
        personMap.put("5", "户口本");
        personMap.put("6", "外国护照");
        personMap.put("7", "其它");
        personMap.put("8", "文职证");
        personMap.put("9", "警官证");
        personMap.put("A", "台胞证");
        personMap.put("B", "外国人永久居留身份证");
        personMap.put("C", "港澳台居民居住证");
        // 机构证件类型
        Map<String, String> orgMap = new HashMap<>();
        orgMap.put("0", "组织机构代码证");
        orgMap.put("1", "营业执照");
        orgMap.put("2", "行政机关");
        orgMap.put("3", "社会团体");
        orgMap.put("4", "军队");
        orgMap.put("5", "武警");
        orgMap.put("6", "下属机构（具有主管单位批文号）");
        orgMap.put("7", "基金会");
        orgMap.put("8", "其它");
        orgMap.put("9", "登记证书");
        orgMap.put("A", "批文");
        // 产品证件类型
        Map<String, String> prdMap = new HashMap<>();
        prdMap.put("1", "营业执照");
        prdMap.put("8", "其他");
        prdMap.put("9", "登记证书");
        prdMap.put("10", "批文");

        // 按客户类型分类
        CERTIFICATE_TYPE_MAP.put("1", personMap);
        CERTIFICATE_TYPE_MAP.put("0", orgMap);
        CERTIFICATE_TYPE_MAP.put("2", prdMap);
    }

    /**
     *
     * @return
     */
    public static String getCertificateTypeName(String custType , String certificateType){
        return ObjectUtil.isEmpty(CERTIFICATE_TYPE_MAP.get(custType))?"":CERTIFICATE_TYPE_MAP.get(custType).get(certificateType);
    }

    public static Map<String,Map<String,String>> getMap(){
        return CERTIFICATE_TYPE_MAP;
    }


}
