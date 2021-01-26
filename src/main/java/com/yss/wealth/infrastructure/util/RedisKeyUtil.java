package com.yss.wealth.infrastructure.util;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import com.google.common.collect.Lists;
import com.yss.wealth.infrastructure.constant.CommonServerConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Author: cr
 * @Date: 2020/10/30 14:47
 * @Description: redis key 的统一生成入口
 */
@Slf4j
public class RedisKeyUtil {

    /**
     * 获取系统参数查询key
     *
     * @param param
     * @return
     */
    public static String getParamKey(String param) {
        return CommonServerConst.PROCESS_KEY_PREFIX
                .concat(CommonServerConst.SYS_PARAM_PREFIX)
                .concat(param);
    }

    /**
     * 拼接redis的key，存入redis时使用
     * 业务保证方法调用时传参顺序与redis存key时一致
     *
     * @param bizPrefix 业务前缀
     * @param params
     * @return
     */
    public static String getBizKey(String bizPrefix, String... params) {
        StringBuilder key = new StringBuilder(CommonServerConst.PROCESS_KEY_PREFIX.concat(bizPrefix));
        for (int i = 0; i < params.length; i++) {
            if (i == params.length - 1) {
                key.append(StringUtil.isEmpty(params[i]) ? CommonServerConst.EMPTY_TAG : params[i]);
            } else {
                key.append(StringUtil.isEmpty(params[i]) ? CommonServerConst.EMPTY_TAG : params[i]).append(CommonServerConst.SPLIT);
            }
        }
        return key.toString().replace(CommonServerConst.REDIS_WILDCARD, CommonServerConst.ALL);
    }

    /**
     * 拼接redis的key前缀，配合RedisKeyUtil.scan(...)方法批量取redis的值时使用
     * 用于获取全量数据
     *
     * @param params
     * @return
     */
    public static String getKeyPrefix(String... params) {
        StringBuilder key = new StringBuilder();
        for (String param : params) {
            key.append(param);
        }
        return key.append(CommonServerConst.REDIS_WILDCARD).toString();
    }

    /**
     * 拼接redis的key前缀，配合RedisKeyUtil.scan(...)方法批量取redis的值时使用
     * 用于获取过滤后的部分数据
     *
     * @param params
     * @return
     */
    public static String getPartKeyPrefix(String bizPrefix, String... params) {
        StringBuilder key = new StringBuilder(CommonServerConst.PROCESS_KEY_PREFIX.concat(bizPrefix));
        for (int i = 0; i < params.length; i++) {
            if (i == params.length - 1) {
                key.append(params[i]).append(CommonServerConst.REDIS_WILDCARD);
            } else {
                key.append(params[i]).append(CommonServerConst.SPLIT);
            }
        }
        return key.toString();
    }

    /**
     * 获取redis产品key
     *
     * @param prdCode 产品代码
     * @return
     */
    public static String getPrdInfoKey(String prdCode) {
        return CommonServerConst.PROCESS_KEY_PREFIX
                .concat(CommonServerConst.PRD_INFO_PREFIX)
                .concat(prdCode)
                .replace(CommonServerConst.REDIS_WILDCARD, CommonServerConst.ALL);
    }


    /**
     * 获取redis产品-产品状态对应业务限制key
     *
     * @param prdCode 产品代码
     * @return
     */
    public static String getPrdStatusBizKey(String prdCode, String prdStatus) {
        return CommonServerConst.PROCESS_KEY_PREFIX
                .concat(CommonServerConst.PRD_STATUS_BIZ_LIMIT_PREFIX)
                .concat(prdCode).concat(CommonServerConst.SPLIT)
                .concat(prdStatus)
                .replace(CommonServerConst.REDIS_WILDCARD, CommonServerConst.ALL);
    }

    /**
     * 获取redis净值信息key
     *
     * @param prdCode 产品代码
     * @return
     */
    public static String getNavInfoKey(String prdCode) {
        return CommonServerConst.PROCESS_KEY_PREFIX
                .concat(CommonServerConst.NAV_INFO_PREFIX)
                .concat(prdCode)
                .replace(CommonServerConst.REDIS_WILDCARD, CommonServerConst.ALL);
    }


    /**
     * 获取机构产品代销关系的rediskey
     *
     * @param orgCode 机构代码
     * @param prdCode 产品代码
     * @return
     */
    public static String getPrdAgencyRelaKey(String prdCode, String orgCode) {
        return CommonServerConst.PROCESS_KEY_PREFIX
                .concat(CommonServerConst.PRD_AGENCY_PREFIX)
                .concat(prdCode).concat(CommonServerConst.SPLIT)
                .concat(orgCode)
                .replace(CommonServerConst.REDIS_WILDCARD, CommonServerConst.ALL);

    }

    /**
     * 获取基金总确认份额redis key
     * @param prdCode
     * @param orgCode
     * @param fundAccount
     * @param custType
     * @return
     */
    public static String getSumShareKey(String prdCode,String orgCode,String fundAccount, String custType) {

        return CommonServerConst.PROCESS_KEY_PREFIX
                .concat("sumCfmShare")
                .concat(prdCode)
                .concat(CommonServerConst.SPLIT)
                .concat(orgCode)
                .concat(CommonServerConst.SPLIT)
                .concat(fundAccount)
                .concat(CommonServerConst.SPLIT)
                .concat(custType);
    }


    /**
     * 获取定期定额业务redis key
     *
     * @param prdCode   产品代码
     * @param orgCode   机构代码
     * @param shareType 份额类别
     * @return
     */
    public static String getPrdPeriodicKey(String prdCode, String orgCode, String shareType) {
        return CommonServerConst.PROCESS_KEY_PREFIX
                .concat(CommonServerConst.RATION_BIZ_LIMIT_PREFIX)
                .concat(prdCode).concat(CommonServerConst.SPLIT)
                .concat(orgCode).concat(CommonServerConst.SPLIT)
                .concat(shareType)
                .replace(CommonServerConst.REDIS_WILDCARD, CommonServerConst.ALL);
    }

    /**
     * 获取通过key前缀查找redis中的结果集
     *
     * @param redisTemplate
     * @param pattern       key的前缀
     * @param limit         每次连接游标移动的行数，暂取10000L
     * @return
     */
    public static List<String> scan(RedisTemplate redisTemplate, String pattern, Long limit) {
        Object result = redisTemplate.execute((RedisCallback<Set<String>>) connection -> {
            Set<String> valueSet = new HashSet<>();
            try (Cursor<byte[]> cursor = connection.scan(new ScanOptions.ScanOptionsBuilder()
                    .match(pattern).count(limit).build())) {
                while (cursor.hasNext()) {
                    byte[] bytes = connection.get(cursor.next());
                    String value = String.valueOf(redisTemplate.getValueSerializer().deserialize(bytes));
                    valueSet.add(value);
                }
            } catch (IOException e) {
                log.error(String.format("get cursor close {%s}", e));
            }
            return valueSet;
        });
        if (ObjectUtil.isEmpty(result)) {
            return Lists.newArrayList();
        }
        return ((Set<String>) result).stream().map(String::valueOf).collect(Collectors.toList());
    }


    /**
     * 机构信息redis key
     *
     * @param orgCode
     * @return
     */
    public static String getOrgKey(String orgCode) {
        return CommonServerConst.PROCESS_KEY_PREFIX
                .concat(CommonServerConst.ORG_INFO_PREFIX)
                .concat(orgCode)
                .replace(CommonServerConst.REDIS_WILDCARD, CommonServerConst.ALL);
    }

    /**
     * 网点信息redis key
     *
     * @param orgCode
     * @param netCode
     * @return
     */
    public static String getNetCode(String orgCode, String netCode) {
        return CommonServerConst.PROCESS_KEY_PREFIX
                .concat(CommonServerConst.NET_INFO_PREFIX)
                .concat(orgCode).concat(CommonServerConst.SPLIT)
                .concat(netCode)
                .replace(CommonServerConst.REDIS_WILDCARD, CommonServerConst.ALL);
    }

    /**
     * 机构产品参数key
     *
     * @param prdCode
     * @param orgCode
     * @return
     */
    public static String getPrdOrgParamKey(String prdCode, String orgCode) {
        return CommonServerConst.PROCESS_KEY_PREFIX
                .concat(CommonServerConst.PRD_ORG_PARAM_PREFIX)
                .concat(prdCode).concat(CommonServerConst.SPLIT)
                .concat(orgCode)
                .replace(CommonServerConst.REDIS_WILDCARD, CommonServerConst.ALL);
    }

    /**
     * 获取TA优惠折扣key
     *
     * @param prdCode
     * @param orgCode
     * @param netCode
     * @param bizCode
     * @param feeType
     * @return
     */
    public static String getTaDiscountKey(String prdCode, String orgCode, String netCode, String bizCode, String feeType) {
        return CommonServerConst.PROCESS_KEY_PREFIX
                .concat(CommonServerConst.TA_DISCOUNT_PREFIX)
                .concat(prdCode).concat(CommonServerConst.SPLIT)
                .concat(orgCode).concat(CommonServerConst.SPLIT)
                .concat(netCode).concat(CommonServerConst.SPLIT)
                .concat(bizCode).concat(CommonServerConst.SPLIT)
                .concat(feeType)
                .replace(CommonServerConst.REDIS_WILDCARD, CommonServerConst.ALL);
    }

    /**
     * 获取定期定额优惠折扣key
     *
     * @param prdCode
     * @param orgCode
     * @param netCode
     * @param bizCode
     * @param feeType
     * @return
     */
    public static String getRationDiscountKey(String prdCode, String orgCode, String netCode, String bizCode, String feeType) {
        return CommonServerConst.PROCESS_KEY_PREFIX
                .concat(CommonServerConst.RATION_DISCOUNT_PREFIX)
                .concat(prdCode).concat(CommonServerConst.SPLIT)
                .concat(orgCode).concat(CommonServerConst.SPLIT)
                .concat(netCode).concat(CommonServerConst.SPLIT)
                .concat(bizCode).concat(CommonServerConst.SPLIT)
                .concat(feeType)
                .replace(CommonServerConst.REDIS_WILDCARD, CommonServerConst.ALL);
    }

    /**
     * 获取赎回转换优惠折扣key
     *
     * @param prdCode
     * @param orgCode
     * @param netCode
     * @param bizCode
     * @param feeType
     * @return
     */
    public static String getRedDiscountKey(String prdCode, String orgCode, String netCode, String bizCode, String feeType, String originShareSource, String shareSource, String transType, String amountType) {
        return CommonServerConst.PROCESS_KEY_PREFIX
                .concat(CommonServerConst.RED_DISCOUNT_PREFIX)
                .concat(prdCode).concat(CommonServerConst.SPLIT)
                .concat(orgCode).concat(CommonServerConst.SPLIT)
                .concat(netCode).concat(CommonServerConst.SPLIT)
                .concat(bizCode).concat(CommonServerConst.SPLIT)
                .concat(feeType).concat(CommonServerConst.SPLIT)
                .concat(originShareSource).concat(CommonServerConst.SPLIT)
                .concat(shareSource).concat(CommonServerConst.SPLIT)
                .concat(transType).concat(CommonServerConst.SPLIT)
                .concat(amountType)
                .replace(CommonServerConst.REDIS_WILDCARD, CommonServerConst.ALL);
    }


    /**
     * 机构产品参数key
     *
     * @param prdCode
     * @param orgCode
     * @param shareType
     * @param bizCode
     * @return
     */
    public static String getPrdOrgBizKey(String prdCode, String orgCode, String shareType, String bizCode) {
        return CommonServerConst.PROCESS_KEY_PREFIX
                .concat(CommonServerConst.PRD_ORG_BIZ_LIMIT_PREFIX)
                .concat(prdCode).concat(CommonServerConst.SPLIT)
                .concat(orgCode).concat(CommonServerConst.SPLIT)
                .concat(shareType).concat(CommonServerConst.SPLIT)
                .concat(bizCode)
                .replace(CommonServerConst.REDIS_WILDCARD, CommonServerConst.ALL);
    }

    public static String getFeeDivideKey(String prdCode, String orgCode, String bizCode, String feeType,
                                         String inPrdCode, String inShareType, String outShareType) {
        return CommonServerConst.PROCESS_KEY_PREFIX.concat(CommonServerConst.FEE_DIVIDE_PREFIX)
                .concat(prdCode).concat(CommonServerConst.SPLIT)
                .concat(orgCode).concat(CommonServerConst.SPLIT)
                .concat(bizCode).concat(CommonServerConst.SPLIT)
                .concat(feeType).concat(CommonServerConst.SPLIT)
                .concat(StringUtil.isEmpty(inPrdCode) ? CommonServerConst.EMPTY_TAG : inPrdCode)
                .concat(CommonServerConst.SPLIT)
                .concat(StringUtil.isEmpty(inShareType) ? CommonServerConst.EMPTY_TAG : inShareType)
                .concat(CommonServerConst.SPLIT)
                .concat(StringUtil.isEmpty(outShareType) ? CommonServerConst.EMPTY_TAG : outShareType)
                .replace(CommonServerConst.REDIS_WILDCARD, CommonServerConst.ALL);

    }

    /**
     * 产品代码 , 机构代码 , 业务类型 , 客户类型 , 费用类型 , 转出产品份额类别 , 转入产品代码 , 转入份额类别
     *
     * @param prdCode
     * @param orgCode
     * @param bizType
     * @param custType
     * @param feeType
     * @param outPrdShareType
     * @param inPrdCode
     * @param inPrdShareType
     * @return
     */
    public static String getFeeRateKey(String prdCode, String orgCode, String bizType, String custType, String feeType, String outPrdShareType, String inPrdCode, String inPrdShareType) {
        return CommonServerConst.PROCESS_KEY_PREFIX.concat(CommonServerConst.FEE_RATE_PREFIX)
                .concat(prdCode).concat(CommonServerConst.SPLIT)
                .concat(orgCode).concat(CommonServerConst.SPLIT)
                .concat(bizType).concat(CommonServerConst.SPLIT)
                .concat(feeType).concat(CommonServerConst.SPLIT)
                .concat(custType).concat(CommonServerConst.SPLIT)
                .concat(StringUtil.isEmpty(outPrdShareType) ? CommonServerConst.EMPTY_TAG : outPrdShareType)
                .concat(CommonServerConst.SPLIT)
                .concat(StringUtil.isEmpty(inPrdCode) ? CommonServerConst.EMPTY_TAG : inPrdCode)
                .concat(CommonServerConst.SPLIT)
                .concat(StringUtil.isEmpty(inPrdShareType) ? CommonServerConst.EMPTY_TAG : inPrdShareType)
                .replace(CommonServerConst.REDIS_WILDCARD, CommonServerConst.ALL);

    }

    /**
     * 可用份额 hash key
     */
    public static String getShareRemainHashKey(String secondLevelRedisKey, String threeLevelRedisKey) {
        return CommonServerConst.PROCESS_KEY_PREFIX
                .concat(secondLevelRedisKey)
                .concat(threeLevelRedisKey);
    }

    /**
     * 份额明细 的 可用剩余份额 hash field
     *
     * @param orgCode          销售商代码
     * @param cfmNo            ta确认流水号
     * @param originalSubsDate 原申购日期
     * @return java.lang.String
     * @author shihao
     */
    public static String getShareDetailRemainHashFiled(String orgCode, String cfmNo, String originalSubsDate) {
        return orgCode.concat(CommonServerConst.SPLIT)
                .concat(cfmNo)
                .concat(CommonServerConst.SPLIT)
                .concat(originalSubsDate)
                .replace(CommonServerConst.REDIS_WILDCARD, CommonServerConst.ALL);
    }

    /**
     * 静态份额 的 可用份额 hash field
     *
     * @param orgCode      销售商代码
     * @param fundAccount  基金账号
     * @param transAccount 交易账号
     * @param prdCode      产品代码
     * @param netCode      网点代码
     * @param shareType    份额类别
     * @return java.lang.String
     * @author shihao
     */
    public static String getStaticShareDetailRemainHashFiled(String fundAccount, String transAccount,
                                                             String prdCode, String orgCode, String netCode,
                                                             String shareType) {
        return prdCode.concat(CommonServerConst.SPLIT)
                .concat(orgCode)
                .concat(CommonServerConst.SPLIT)
                .concat(netCode)
                .concat(CommonServerConst.SPLIT)
                .concat(fundAccount)
                .concat(CommonServerConst.SPLIT)
                .concat(transAccount)
                .concat(CommonServerConst.SPLIT)
                .concat(shareType)
                .replace(CommonServerConst.REDIS_WILDCARD, CommonServerConst.ALL);
    }

    /**
     * 产品交易限制
     *
     * @param orgCode  销售商代码
     * @param prdCode  产品代码
     * @param custType 客户类型
     * @return java.lang.String
     * @author shihao
     */
    public static String getPrdTradeLimitKey(String prdCode, String orgCode, String custType) {
        return CommonServerConst.PROCESS_KEY_PREFIX.concat(CommonServerConst.PRD_TRADE_LIMIT)
                .concat(prdCode).concat(CommonServerConst.SPLIT)
                .concat(orgCode).concat(CommonServerConst.SPLIT)
                .concat(custType)
                .replace(CommonServerConst.REDIS_WILDCARD, CommonServerConst.ALL);
    }

    /**
     * 替换第startNo个CommonServerConst.SPLIT("_")到startNo+1个CommonServerConst.SPLIT("_")之间的字符串为CommonServerConst.BIZ_ALL("all")
     *
     * @param bizKey  redis流程key
     * @param startNo 第多少个CommonServerConst.SPLIT("_")。
     *                注意：这里已经排除了流程前缀PROCESS_KEY和业务前缀TA_DISCOUNT的下划线,从最后一个冒号开始算
     *                eg：String bizKey = PROCESS_KEY:TA_DISCOUNT:670001_701_701000002_0_0;
     *                // 此时需要替换机构代码701为all,从前往后数，701是第二个字段，则传入1作为startNo
     *                bizKey = this.replaceField(bizKey,1);  ##  PROCESS_KEY:TA_DISCOUNT:670001_all_701000002_0_0;
     *                eg: String bizKey = PROCESS_KEY:TA_DISCOUNT:670001_701_701000002_0_0;
     *                // 此时需要替换最后一个0，也就是第5个字段，则传入4作为startNo，由于找不到第5个下划线，默认替换至字符串最后一位
     *                bizKey = this.replaceField(bizKey,4);  ##  PROCESS_KEY:TA_DISCOUNT:670001_701_701000002_0_all;
     * @return 替换后的字符串
     */
    public static String replaceField(String bizKey, int startNo) {
        // 最后一个冒号的位置
        int lastColonIndex = bizKey.lastIndexOf(":");
        Matcher matcher = Pattern.compile(CommonServerConst.SPLIT).matcher(bizKey.substring(lastColonIndex));
        if (startNo == 0) {
            int end;
            if (!matcher.find()) {
                end = bizKey.length();
            } else {
                end = matcher.end();
            }

            return new StringBuilder(bizKey).replace(lastColonIndex + 1, lastColonIndex + end - 1, CommonServerConst.ALL).toString();
        }
        int index = 0;
        while (matcher.find()) {
            index++;
            if (index == startNo) {
                break;
            }
        }
        int startIndex = lastColonIndex + matcher.start() + 1;
        int endIndex = lastColonIndex + bizKey.length();
        if (matcher.find()) {
            endIndex = lastColonIndex + matcher.start();
        }
        return new StringBuilder(bizKey).replace(startIndex, endIndex, CommonServerConst.ALL).toString();
    }

    /**
     * 按需替换字段为all从Map中获取相应的对象
     *
     * @param bizKey        业务主键（含redis前缀）
     * @param replaceFields 需要替换为all的字段所在的位置，按下划线开始数（去掉流程前缀和业务前缀剩下的字符串），第三个字段对应的下划线位置就是2，
     *                      传入的可变参数可以是多个字段，但必须是按照业务优先级顺序传入
     *                      eg: bizKey = "PROCESS_KEY:TA_DISCOUNT:670001_703_703000001_0_0"
     *                      机构代码为703，销售商代码为703000001
     *                      按业务优先级，优先取销售商为all的；再取销售商代码匹配，机构代码为all的；最后再取两者都为all的
     *                      此时传参为RedisKeyUtil.matchKey(bizKey,map,2,1),若map内含有对应k-v，则正确返回v
     * @return
     */
    public static <v> v matchKey(String bizKey, Map<String, v> map, int... replaceFields) {
        Assert.notNull(bizKey, "业务主键bizKey不能为空");
        Assert.isTrue(replaceFields.length == 0, "需要替换为all的字段不能为空");
        if(MapUtil.isEmpty(map)){
            return null;
        }
        String[][] array = new String[replaceFields.length][2];
        Arrays.fill(array, new String[]{"0", "1"});
        String[][] array1 = rangeSort(array);
        String[] array2 = rangeSort(array1)[0];
        for (String s : array2) {
            String newKey = bizKey;
            for (int i = 0; i < s.length(); i++) {
                if ('1' == s.charAt(i)) {
                    newKey = replaceField(newKey, replaceFields[i]);
                }
            }
            if (ObjectUtil.isNotEmpty(map.get(newKey))) {
                return map.get(newKey);
            }
        }
        return null;
    }

//    public static void main(String[] args) {
//        String bizKey = "PROCESS_KEY:TA_DISCOUNT:670001_701_701000002_0_0";
//        System.out.println(bizKey);
//        String s = RedisKeyUtil.replaceField(bizKey, 1);
//        System.out.println(s);
//        String k = RedisKeyUtil.replaceField(bizKey, 2);
//        System.out.println(k);

//        HashMap<String, String> map = new HashMap<>();
//        map.put("PROCESS_KEY:TA_DISCOUNT:670001_701_701000002_0_0", "1");
//        map.put("PROCESS_KEY:TA_DISCOUNT:670001_702_701000002_0_0", "2");
//        map.put("PROCESS_KEY:TA_DISCOUNT:670001_703_all_0_0", "3");
//        map.put("PROCESS_KEY:TA_DISCOUNT:670001_all_701000002_all_0", "4");
//        map.put("PROCESS_KEY:TA_DISCOUNT:670001_all_701000002_0_0", "5");
//        map.put("PROCESS_KEY:TA_DISCOUNT:670001_all_701000003_0_0", "6");
//        map.put("PROCESS_KEY:TA_DISCOUNT:670001_all_all_all_0", "7");

//        String s1 = matchKey("PROCESS_KEY:TA_DISCOUNT:670001_704_701000002_0_0", map, 0, 1, 4);
//        // 满足条件的有"PROCESS_KEY:TA_DISCOUNT:670001_all_701000002_0_0" 和 "PROCESS_KEY:TA_DISCOUNT:670001_all_701000002_all_0" 和 "PROCESS_KEY:TA_DISCOUNT:670001_all_all_all_0"
//        // 按传入替换字段的优先顺序 3,2,1  不能全匹配的情况下优先取第三个下划线字段后面的值为all，第二个次之，第一个优先级最低
//        // 结果取到"PROCESS_KEY:TA_DISCOUNT:670001_all_701000002_0_0"，取值为 s1="5"
//        System.out.println(s1);
//
//        String s2 = matchKey("PROCESS_KEY:TA_DISCOUNT:670001_704_701000002_1_0", map, 3, 2, 1);
//        // 满足条件的有"PROCESS_KEY:TA_DISCOUNT:670001_all_701000002_all_0" 和 "PROCESS_KEY:TA_DISCOUNT:670001_all_all_all_0"
//        // 按传入替换字段的优先顺序 3,2,1  不能全匹配的情况下优先取第三个下划线字段后面的值为all，第二个次之，第一个优先级最低
//        // 结果取到"PROCESS_KEY:TA_DISCOUNT:670001_all_701000002_all_0"，取值为 s1="4"
//        System.out.println(s2);
//    }

    private static String[][] rangeSort(String[][] doubleArrays) {
        int len = doubleArrays.length;
        if (len >= 2) {
            int len1 = doubleArrays[0].length;
            int len2 = doubleArrays[1].length;
            int newlen = len1 * len2;
            String[] temp = new String[newlen];
            int index = 0;
            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2; j++) {
                    temp[index] = doubleArrays[0][i] + doubleArrays[1][j];
                    index++;
                }
            }
            String[][] newArray = new String[len - 1][];
            for (int i = 2; i < len; i++) {
                newArray[i - 1] = doubleArrays[i];
            }
            newArray[0] = temp;
            return rangeSort(newArray);
        } else {
            return doubleArrays;
        }
    }

    public static String getSixKeyElement(String fundAcc, String orgCode, String netCode, String transAcc, String prdCode, String shareType) {
        return (StringUtil.isEmpty(fundAcc) ? "#" : fundAcc).concat(CommonServerConst.SPLIT)
                .concat(StringUtil.isEmpty(orgCode) ? "#" : orgCode).concat(CommonServerConst.SPLIT)
                .concat(StringUtil.isEmpty(netCode) ? "#" : netCode).concat(CommonServerConst.SPLIT)
                .concat(StringUtil.isEmpty(transAcc) ? "#" : transAcc).concat(CommonServerConst.SPLIT)
                .concat(StringUtil.isEmpty(prdCode) ? "#" : prdCode).concat(CommonServerConst.SPLIT)
                .concat(StringUtil.isEmpty(shareType) ? "#" : shareType);
    }

    public static List<String> getSysParamKeyList(String... sysParams) {
        List<String> keys = new ArrayList<>();
        for (String sysParam : sysParams) {
            keys.add(getParamKey(sysParam));
        }
        return keys;
    }

    public static String getPrdSplitKey(String prdCode) {
        return CommonServerConst.PROCESS_KEY_PREFIX
                .concat(CommonServerConst.PRD_SPLIT)
                .concat(prdCode)
                .replace(CommonServerConst.REDIS_WILDCARD, CommonServerConst.ALL);
    }

    public static String getFeeRateForFundKey(String prdCode) {
        return CommonServerConst.PROCESS_KEY_PREFIX
                .concat(CommonServerConst.BELONG_PRD_RATE_PREFIX)
                .concat(prdCode)
                .replace(CommonServerConst.REDIS_WILDCARD, CommonServerConst.ALL);
    }

    public static String getPrdAssetRateKey(String prdCode, String orgCode, String bizCode, String shareType, String targetPrdCode, String targetShareType) {
        return CommonServerConst.PROCESS_KEY_PREFIX.concat(CommonServerConst.BELONG_PRD_RATE_PREFIX)
                .concat(prdCode).concat(CommonServerConst.SPLIT)
                .concat(orgCode).concat(CommonServerConst.SPLIT)
                .concat(bizCode).concat(CommonServerConst.SPLIT)
                .concat(StringUtil.isEmpty(shareType) ? CommonServerConst.EMPTY_TAG : shareType).concat(CommonServerConst.SPLIT)
                .concat(StringUtil.isEmpty(targetPrdCode) ? CommonServerConst.EMPTY_TAG : targetPrdCode).concat(CommonServerConst.SPLIT)
                .concat(StringUtil.isEmpty(targetShareType) ? CommonServerConst.EMPTY_TAG : targetShareType)
                .replace(CommonServerConst.REDIS_WILDCARD, CommonServerConst.ALL);
    }

    public static String getPrdInterestRateKey(String prdCode, String orgCode) {
        return CommonServerConst.PROCESS_KEY_PREFIX.concat(CommonServerConst.PRD_RATE)
                .concat(prdCode)
                .concat(CommonServerConst.SPLIT)
                .concat(orgCode)
                .replace(CommonServerConst.REDIS_WILDCARD, CommonServerConst.ALL);
    }

    public static String getPrdChangeKey(String prdCode, String shareType, String orgCode, String targetPrdCode, String targetShareType) {
        return CommonServerConst.PROCESS_KEY_PREFIX.concat(CommonServerConst.CHANGE_BIZ_LIMIT_PREFIX)
                .concat(prdCode).concat(CommonServerConst.SPLIT)
                .concat(orgCode).concat(CommonServerConst.SPLIT)
                .concat(StringUtil.isEmpty(shareType) ? CommonServerConst.EMPTY_TAG : shareType).concat(CommonServerConst.SPLIT)
                .concat(StringUtil.isEmpty(targetPrdCode) ? CommonServerConst.EMPTY_TAG : targetPrdCode).concat(CommonServerConst.SPLIT)
                .concat(StringUtil.isEmpty(targetShareType) ? CommonServerConst.EMPTY_TAG : targetShareType)
                .replace(CommonServerConst.REDIS_WILDCARD, CommonServerConst.ALL);
    }

    public static String getCompensationFeeRuleKey(String prdCode, String orgCode, String outShareType, String inShareType, String inPrdCode) {
        return CommonServerConst.PROCESS_KEY_PREFIX.concat(CommonServerConst.FEE_RULE_PREFIX)
                .concat(prdCode).concat(CommonServerConst.SPLIT)
                .concat(orgCode).concat(CommonServerConst.SPLIT)
                .concat(StringUtil.isEmpty(outShareType) ? CommonServerConst.EMPTY_TAG : outShareType).concat(CommonServerConst.SPLIT)
                .concat(StringUtil.isEmpty(inShareType) ? CommonServerConst.EMPTY_TAG : inShareType).concat(CommonServerConst.SPLIT)
                .concat(StringUtil.isEmpty(inPrdCode) ? CommonServerConst.EMPTY_TAG : inPrdCode)
                .replace(CommonServerConst.REDIS_WILDCARD, CommonServerConst.ALL);
    }

    public static String getOrgDiscountLimitKey(String prdCode, String orgCode, String bizCode, String custType, String feeType, String outShareType, String inPrdCode, String inShareType) {
        return CommonServerConst.PROCESS_KEY_PREFIX.concat(CommonServerConst.ORG_DISCOUNT_LIMIT)
                .concat(prdCode).concat(CommonServerConst.SPLIT)
                .concat(orgCode).concat(CommonServerConst.SPLIT)
                .concat(bizCode).concat(CommonServerConst.SPLIT)
                .concat(custType).concat(CommonServerConst.SPLIT)
                .concat(feeType).concat(CommonServerConst.SPLIT)
                .concat(StringUtil.isEmpty(outShareType) ? CommonServerConst.EMPTY_TAG : outShareType).concat(CommonServerConst.SPLIT)
                .concat(StringUtil.isEmpty(inShareType) ? CommonServerConst.EMPTY_TAG : inShareType).concat(CommonServerConst.SPLIT)
                .concat(StringUtil.isEmpty(inPrdCode) ? CommonServerConst.EMPTY_TAG : inPrdCode)
                .replace(CommonServerConst.REDIS_WILDCARD, CommonServerConst.ALL);
    }

}
