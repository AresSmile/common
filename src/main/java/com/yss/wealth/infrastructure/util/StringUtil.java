package com.yss.wealth.infrastructure.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @see
 * @author zhanglq
 * @version 1.0,2012-2-22
 * @since 1.0,2012-2-22
 */
public class StringUtil {

	/**
	 * 连接SQL字符串
	 * 
	 * @param types 类型集合
	 * @return String
	 * @author zhanglq
	 */
	public static String joinString(Collection<String> types) {

		StringBuffer sb = new StringBuffer();
		if (types != null && !types.isEmpty()) {
			for (String str : types) {
				sb.append("'").append(str).append("',");
			}
			sb.setLength(sb.length() - 1);
		}
		return sb.toString();
	}

	/**
	 * 连接SQL字符串
	 * 
	 * @param types 类型集合
	 * @return String
	 * @author zhanglq
	 */
	public static String joinString(String[] types) {

		StringBuffer sb = new StringBuffer();
		if (types != null && types.length > 0) {
			for (String str : types) {
				sb.append("'").append(str).append("',");
			}
			sb.setLength(sb.length() - 1);
		}
		return sb.toString();
	}

	/**
	 * String[]转为，分割的字符串
	 * 
	 * @param types 类型集合
	 * @return String
	 * @author zhanglq
	 */
	public static String ArrayToString(String[] types) {

		StringBuffer sb = new StringBuffer();
		if (types != null && types.length > 0) {
			for (String str : types) {
				sb.append(str).append(",");
			}
			sb.setLength(sb.length() - 1);
		}
		return sb.toString();
	}
	
	/**
     * 组装成in的SQL字符串
     * 硬解析的方法已过期，不要再用了 wuyang
     * 
     * @param propertyName 字段名称
     * @param values 数据集合
     * @return
     */
	@Deprecated
    public static String getInExpression(String propertyName, Object[] values) {
        StringBuffer sb = new StringBuffer();
        if(values != null && values.length > 0){
        	// 加countEffectiveValue处理是为了兼容value值为空字符串时DB2下报错 wxy 2016-08-07
        	int countEffectiveValue = 0;
            sb.append(" and (").append(propertyName).append(" in(");
            int count = 0;
            for(Object value : values){
            	if(value != null && StringUtil.isNotEmpty(value.toString())){
                	++countEffectiveValue;
                    if(count > 900){
                        sb.append("'").append(value.toString()).append("') or ").append(
                                propertyName).append(" in(");
                        count = 0;
                    }
                    sb.append("'").append(value.toString()).append("',");
                    count++;
                }
            }
            sb.setLength(sb.length() - 1);
            sb.append("))");
            if(countEffectiveValue == 0){
            	return "";
            }
        }
        return sb.toString();
    }
	
	/**
     * 产品树用到了getInExpression方法这里影响太大，暂时先用此方法绕过校验，后续再改相关校验
     * @param propertyName 字段名称
     * @param values 数据集合
     * @return
     * @author lhw
     */
    public static String getInExpressionNew(String propertyName, Object[] values) {
        StringBuffer sb = new StringBuffer();
        if(values != null && values.length > 0){
        	// 加countEffectiveValue处理是为了兼容value值为空字符串时DB2下报错 wxy 2016-08-07
        	int countEffectiveValue = 0;
            sb.append(" and (").append(propertyName).append(" in(");
            int count = 0;
            for(Object value : values){
            	if(value != null && StringUtil.isNotEmpty(value.toString())){
                	++countEffectiveValue;
                    if(count > 900){
                        sb.append("'").append(value.toString()).append("') or ").append(
                                propertyName).append(" in(");
                        count = 0;
                    }
                    sb.append("'").append(value.toString()).append("',");
                    count++;
                }
            }
            sb.setLength(sb.length() - 1);
            sb.append("))");
            if(countEffectiveValue == 0){
            	return "";
            }
        }
        return sb.toString();
    }

    /**
     * 组装成in的SQL字符串
     * 
     * @param propertyName 字段名称
     * @param values 数据集合
     * @return
     */
    public static String getInExpression(String propertyName,Object[] values,boolean bool){
        String sql = getInExpression(propertyName,values);
        if(bool){
            if(sql.length() == 0){
                sql = " and 1<>1";
            }
        }
        return sql;
    }
    
    /**
     * 组装成in的SQL字符串
     * 产品树用到了getInExpression方法这里影响太大，暂时先用此方法绕过校验，后续再改相关校验
     * 
     * @param propertyName 字段名称
     * @param values 数据集合
     * @return
     * @author lhw
     */
    public static String getInExpressionNew(String propertyName,Object[] values,boolean bool){
        String sql = getInExpressionNew(propertyName,values);
        if(bool){
            if(sql.length() == 0){
                sql = " and 1<>1";
            }
        }
        return sql;
    }

    /**
     * 组装成not in的SQL字符串
     * 硬解析的方法已过期，不要再用了 wuyang
     * 
     * @param propertyName 字段名称
     * @param values 数据集合
     * @return
     */
    @Deprecated
    public static String getNotInExpression(String propertyName,Object[] values){
        StringBuffer sb = new StringBuffer();
        if(values != null && values.length > 0){
        	// 加countEffectiveValue处理是为了兼容value值为空字符串时DB2下报错 wxy 2016-08-07
        	int countEffectiveValue = 0;
            sb.append(" and (").append(propertyName).append(" not in(");
            int count = 0;
            for(Object value : values){
            	if(value != null && StringUtil.isNotEmpty(value.toString())){
                	++countEffectiveValue;
                    if(count > 900){
                        sb.append("'").append(value.toString()).append("') and ").append(
                                propertyName).append(" not in(");
                        count = 0;
                    }
                    sb.append("'").append(value.toString()).append("',");
                    count++;
                }
            }
            sb.setLength(sb.length() - 1);
            sb.append("))");
            if(countEffectiveValue == 0){
            	return "";
            }
        }
        return sb.toString();
    }

    
    /**
     * 组装成in的SQL字符串
     * 
     * @param propertyName 字段名称
     * @param values 数据集合
     * @return
     */
    public static String getInExpressionPst(String propertyName, Object[] values) {
    	StringBuffer sb = new StringBuffer();
    	if (values != null && values.length > 0) {
    		sb.append(" and "+createINSql2(propertyName, values));
    	}
        return sb.toString();
    }

    
    /**

     * 组装成not in的SQL字符串
     * 
     * @param propertyName 字段名称
     * @param values 数据集合
     * @return
     */
    public static String getNotInExpressionPst(String propertyName,Object[] values){
    	StringBuffer sb = new StringBuffer();
    	if (values != null && values.length > 0) {
    		sb.append(" and "+createNotINSql2(propertyName, values));
    	}
    	return sb.toString();
        
    }

    /**
     * 组装成in的SQL字符串
     * 硬解析的方法已过期，不要再用了 wuyang
     * 
     * @param propertyName 字段名称
     * @param values 数据集合
     * @return
     */
    @Deprecated
    public static String createINSql(String propertyName,Object[] values){
        StringBuffer sb = new StringBuffer();
        if(values != null && values.length > 0){
        	// 加countEffectiveValue处理是为了兼容value值为空字符串时DB2下报错 wxy 2016-08-07
        	int countEffectiveValue = 0;
            sb.append("(").append(propertyName).append(" in(");
            int count = 0;
            for(Object value : values){
                if(value != null && StringUtil.isNotEmpty(value.toString())){
                	++countEffectiveValue;
                    if(count > 900){
                        sb.append("'").append(value.toString().trim()).append("') or ").append(
                                propertyName).append(" in(");
                        count = 0;
                    }
                    sb.append("'").append(value.toString().trim()).append("',");
                    count++;
                }
            }
            sb.setLength(sb.length() - 1);
            sb.append("))");
            if(countEffectiveValue == 0){
            	return "";
            }
        }
        return sb.toString();
    }

    /**
     * 组装成in的SQL字符串
     * 硬解析的方法已过期，不要再用了 wuyang
     * 
     * @param propertyName 字段名称
     * @param values 数据集合
     * @return
     */
    @Deprecated
    public static String createNotINSql(String propertyName,Object[] values){
        StringBuffer sb = new StringBuffer();
        if(values != null && values.length > 0){
        	// 加countEffectiveValue处理是为了兼容value值为空字符串时DB2下报错 wxy 2016-08-07
        	int countEffectiveValue = 0;
            sb.append("(").append(propertyName).append(" not in(");
            int count = 0;
            for(Object value : values){
            	if(value != null && StringUtil.isNotEmpty(value.toString())){
                	++countEffectiveValue;
                    if(count > 900){
                        sb.append("'").append(value.toString()).append("') and ").append(
                                propertyName).append(" not in(");
                        count = 0;
                    }
                    sb.append("'").append(value.toString()).append("',");
                    count++;
                }
            }
            sb.setLength(sb.length() - 1);
            sb.append("))");
            if(countEffectiveValue == 0){
            	return "";
            }
        }
        return sb.toString();
    }
	
	/**
	 * 组装成in的SQL字符串,绑定变量，避免硬解析
	 * 
	 * @param propertyName 字段名称
	 * @param values 数据集合
	 * @return String
	 */
	public static String createINSql2(String propertyName, Object[] values) {
		StringBuffer sb = new StringBuffer();
		if (values != null && values.length > 0) {
			sb.append("(").append(propertyName).append(" in(");
			int count = 0;
			for (Object value : values) {
				if (value != null) {
					if (count > 900) {
						if(sb.toString().endsWith(",")){
							sb.setLength(sb.length() - 1);
						}
						sb.append(") or ").append(propertyName).append(" in(");
						count = 0;
					}
					sb.append("?,");
					count++;
				}
			}
			sb.setLength(sb.length() - 1);
			sb.append("))");
		}
		return sb.toString();
	}
	
	/**
	 * 组装成not in的SQL字符串,绑定变量，避免硬解析
	 * (BUG #267519 重新该方法)
	 * 
	 * @param propertyName 字段名称
	 * @param values 数据集合
	 * @return String
	 */
	public static String createNotINSql2(String propertyName, Object[] values) {
		StringBuffer sb = new StringBuffer();
		// 期望每组个数
		final int numberOfEachGroup = 900;
		
		if (values != null && values.length > 0) {
			final int numberOfLastGroup = values.length % numberOfEachGroup;
			// 计算得分组数量
			int groupNumber = values.length / numberOfEachGroup;
			if(numberOfLastGroup !=0){
				groupNumber++;
			}
			
			sb.append(" (");
			for (int i = 1; i <= groupNumber; i++) {
				if (i!=1) {
					sb.append(" and ");
				}
				sb.append(propertyName).append(" not in(");
				// 最后一组判断是否是期望每组个数
				int number = (i == groupNumber && numberOfLastGroup != 0) ? numberOfLastGroup : numberOfEachGroup;
				for (int j = 0; j < number; j++) {
					if (j!=0) {
						sb.append(",");
					}
					sb.append("?");
				}
				sb.append(")");
			}
			sb.append(") ");
		}
		return sb.toString();
	}
	
    /**
     * 组装成like的SQL字符串
     * 
     * @param propertyName 字段名称
     * @param values 数据集合
     * @return
     */
	public static String createlikeSql(String propertyName, Object[] values) {
		StringBuffer sb = new StringBuffer();
		if (values != null && values.length > 0) {
			sb.append("(").append(propertyName).append(" like(");
			int count = 0;
			for (Object value : values) {
				if (value != null) {
					if (count > 900) {
						if(sb.toString().endsWith(",")){
							sb.setLength(sb.length() - 1);
						}
						sb.append(") or ").append(propertyName).append(" like(");
						count = 0;
					}
					sb.append("?,");
					count++;
				}
			}
			sb.setLength(sb.length() - 1);
			sb.append("))");
		}
		return sb.toString();
	}
	
	/**
	 * 检查字符串是否为空
	 * 
	 * @param str 字符串
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0||"null".equalsIgnoreCase(str) || " ".equals(str);
	}

	/**
	 * 检查字符串是否为空
	 * 
	 * @param str 字符串
	 * @return boolean
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	 /**
     * 检查字符串是否为空
     * 
     * @param str 对象
     * @return
     */
    public static boolean isNotEmpty(Object str){
        return !isEmpty(str);
    }
    
	/**
     * 检查字符串是否为空
     * 
     * @param str 对象
     * @return
     */
    public static boolean isEmpty(Object str){
    	//增加断言，避免开发使用错误的参数类型 wuyang
    	assert !(str instanceof List) : "参数类型不能为List";
    	assert !(str instanceof Map) : "参数类型不能为Map";
        if(str == null) {
        	return true;
        }
        return str instanceof String || str instanceof StringBuffer ? StringUtil.isEmpty(String.valueOf(str)) : false;
    }
    
	/**
	 * 去除字符串首尾的空格
	 * 
	 * @param sSrc String：源串
	 * @return String：去除空格后的结果串
	 */
	public static final String trim(String sSrc) {
		int i;
		int j;
		// 去除尾部空格
		for (i = sSrc.length() - 1; i >= 0; i--) {
			if (sSrc.charAt(i) != ' ') {
				break;
			}
		}
		if (i < 0) {
			return "";
		}
		// 去除开头空格
		for (j = 0; j < i; j++) {
			if (sSrc.charAt(j) != ' ') {
				break;
			}
		}
		return sSrc.substring(j, i + 1);// 返回从j到i的字符
	}

	/**
	 * 功能说明：从给定字符串的左侧截取子字符串，超长也不会报错
	 * @param srt 给定字符串
	 * @param len 截取长度
	 * @return 子字符串
	 * @author wuyang
	 */
	public static final String left(String srt, int len) {
		if (len >= srt.length() || len < 0) {
			return srt;
		}
		return srt.substring(0, len);
	}

	/**
	 * 功能说明：从给定字符串的右侧截取子字符串
	 * @param str 给定字符串
	 * @param len 截取长度
	 * @return 子字符串
	 * @author wuyang
	 */
	public static final String right(String str, int len) {
		if (len >= str.length() || len < 0) {
			return str;
		}
		return str.substring(str.length() - len);
	}
	/**
	 * 格式化等长字符串，加后缀
	 * 
	 * @param s 字符串
	 * @param flag 后缀
	 * @param len 长度
	 * @return String
	 * @author SYC
	 * @throws Exception 异常
	 */
	public static String stringFormatGBK(String s, String flag, int len) throws Exception {
		String tmpString = s;
		if (tmpString == null) {
			tmpString = " ";
		}

		int add = 0;
		try {
			// 这里要转成gbk进行计算，否则对不齐cwt2013-11-25
			add = len - tmpString.getBytes("GBK").length;
		} catch (UnsupportedEncodingException e) {
			throw new Exception(e);
		}
		StringBuffer result = new StringBuffer(tmpString);
		if (add > 0) {
			for (int i = 0; i < add; i++) {
				result.append(flag);
			}
		}
		return result.toString();
	}

	/**
	 * 将字符串值转换成指定类型的对象
	 * 
	 * @param value 字符串值
	 * @param type 指定类型
	 * @return 类型的对象
	 * @throws ParseException 时间转换异常
	 */
	public static Object toObject(String value, String type) throws ParseException {
		Object reValue = value;
		if (isNotEmpty(value)) {
			if ("Double".equalsIgnoreCase(type)) {
				reValue = Double.valueOf(value);
			} else if ("Float".equalsIgnoreCase(type)) {
				reValue = Float.valueOf(value);
			} else if ("Long".equalsIgnoreCase(type)) {
				reValue = Long.valueOf(value);
			} else if ("Integer".equalsIgnoreCase(type)) {
				reValue = Integer.valueOf(value);
			} else if ("Boolean".equalsIgnoreCase(type)) {
				reValue = Boolean.valueOf(value);
			} else if ("BigDecimal".equalsIgnoreCase(type)) {
				reValue = new BigDecimal(value);
			} else if ("Date".equalsIgnoreCase(type)) {
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				reValue = sf.parse(value);
			}
		}
		return reValue;
	}

	/**
	 * 将小于长度的字符串格式化为（len）位（左补位），大于给定长度的原样返回
	 * 
	 * @param str 原字符串
	 * @param len 长度
	 * @param c 左补字符
	 * @return 格式化后的字符串
	 * @author wxy
	 * @date 2014-11-24
	 */
	public static String format(String str, int len, char c) {
		String tmpString = str;
		if (tmpString == null || tmpString.length() == 0) {
			tmpString = "";
		}
		if (tmpString.length() >= len) {
			return tmpString;
		}
		char arr[] = new char[len - tmpString.length()];
		Arrays.fill(arr, 0, (len - tmpString.length()), c);
		return String.valueOf(arr) + tmpString;
	}

	/**
	 * String数组去重
	 * 
	 * @param value 原数组
	 * @return 去重后的数组
	 * @author fkz
	 * @date 2015-4-18
	 */
	public static String[] removeRepeat(String[] value) {
		TreeSet<String> set = new TreeSet<String>();
		for(int i =0;i<value.length;i++){
			set.add(value[i]);
		}
		String[] result = new String[set.size()];
		return set.toArray(result);
	}

	/**
	 * String去重
	 * 
	 * @param value 原值
	 * @return 去重后的值
	 * @author fkz
	 * @date 2015-4-18
	 */
	public static String removeRepeat(String value) {

		return StringUtil.ArrayToString(StringUtil.removeRepeat(value.split(",")));
	}

	/**
	 * 判断是否为数字
	 * 
	 * @param str
	 * @return true:是数字；false:不是数字
	 * @author dongyeyun
	 * @date 2015-6-10
	 */
	public static boolean isNumeric(String str) {
		if (isEmpty(str)) {
			return false;
		} else {
			for (int i = 0; i < str.length(); i++) {
				if (!Character.isDigit(str.charAt(i))) {
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * 功能说明：检查字符串是否以比对字符集开头，如果以其中一个开头就返回true，否则返回false
	 * 
	 * @param str String 被检查字符串
	 * @param arys String[] 比对字符集
	 * @return boolean 是否以比对字符集开头
	 */
	public static boolean oneStart(String str, String arys) {
		if (isEmpty(arys)) {
			return false;
		}
		String[] ary = arys.split(",");
		for (int i = 0; i < ary.length; i++) {
			if (str.startsWith(ary[i])) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 
	 * 功能说明：检查字符串是否包含比对字符集，如果包含其中一个就返回true，否则返回false
	 * 
	 * @param str String 被检查字符串
	 * @param ary String[] 比对字符集
	 * @return boolean
	 */
	public static boolean oneOf(String str, String[] ary, boolean flag) {
		for (int i = 0; i < ary.length; i++) {
			if (flag) {
				if (str.equalsIgnoreCase(ary[i])){
					return true;
				}
			} else {
				if (str.indexOf(ary[i]) > -1){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 
	 * 重载方法
	 * @param str
	 * @param ary
	 * @return
	 * @author  chenwentao
	 * @date    2018-5-15
	 */
	public static boolean oneOf(String str, String[] ary) {
		return oneOf(str, ary, false);
	}

	/**
	 * 
	 * 功能说明：检查字符串是否包含比对字符集，如果包含其中一个就返回true，否则返回false
	 * 
	 * @param str String 被检查字符串
	 * @param arys String 比对字符集(多个字符串用英文逗号间隔)
	 * @return boolean
	 */
	public static boolean oneOf(String str, String arys, boolean flag) {
		if ((arys == null || arys.trim().equalsIgnoreCase("")) && str != null
				&& !str.trim().equalsIgnoreCase("")){
			return false;// 比对字符集为空直接返回false
		}
			
		return oneOf(str, arys.split(","), flag);
	}

	/**
	 * 
	 * 功能说明：检查字符串是否包含比对字符集，如果包含其中一个就返回true，否则返回false
	 * 
	 * @param str String 被检查字符串
	 * @param arys String 比对字符集(多个字符串用英文逗号间隔)
	 * @return boolean
	 */
	public static boolean oneOf(String str, String arys) {
		if ((arys == null || arys.trim().equalsIgnoreCase("")) && str != null
				&& !str.trim().equalsIgnoreCase("")){
			return false;// 比对字符集为空直接返回false
		}
		return oneOf(str, arys.split(","), false);
	}

	/**
	 * 
	 * 将堆栈信息转换为字符串
	 * 
	 * @param e
	 * @return
	 * @author chenwentao
	 * @date 2015-8-5
	 */
	public static String getStackMsg(Exception e) {
		StringBuffer sb = new StringBuffer();
		sb.append(e.getMessage());
		StackTraceElement[] stackArray = e.getStackTrace();
		for (int i = 0; i < stackArray.length; i++) {
			StackTraceElement element = stackArray[i];
			if(element.getClassName().startsWith("com.yss.acs")){
				sb.append(e.getMessage()+ " at "+
						element.getClassName()+"."+
						element.getMethodName()+"("+element.getLineNumber()+"行)\n");
						  
				break;
			}
		}
		return sb.toString();
	}

	/**
	 * 
	 * 将堆栈信息转换为字符串
	 * 
	 * @param e
	 * @return
	 * @author chenwentao
	 * @date 2015-8-5
	 */
	public static String getStackMsg(Throwable e) {

		StringBuffer sb = new StringBuffer();
		StackTraceElement[] stackArray = e.getStackTrace();
		for (int i = 0; i < stackArray.length; i++) {
			StackTraceElement element = stackArray[i];
			sb.append(element.toString() + "\n");
		}
		return sb.toString();
	}
	/**
	 * 根据两个日期时间返回时间段内的时间集合
	 * 
	 * @param oneDate
	 * @param twoDate
	 * @author liuchunqi
	 * @return List
	 */
	public static List<Date> getDatesBetweenTwoDate(Date oneDate, Date twoDate) {
		Date beginDate; //开始日期
		Date endDate;   //结束日期
		List<Date> lDate = new ArrayList<Date>();
		//如果一个日期为null那直接返回另一个日期
		if(oneDate==null){
			lDate.add(twoDate);
		}else if(twoDate==null){
			lDate.add(oneDate);
		}else{
			//判断两个日期的大小
			if(oneDate.compareTo(twoDate)==-1){
				beginDate = oneDate;
				endDate = twoDate;
			}else{
				beginDate = twoDate;
				endDate = oneDate;
			}
			lDate.add(beginDate);// 把开始时间加入集合
			Calendar cal = Calendar.getInstance();
			// 使用给定的 Date 设置此 Calendar 的时间
			cal.setTime(beginDate);
			boolean bContinue = true;
			while (bContinue) {
				// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
				cal.add(Calendar.DAY_OF_MONTH, 1);
				// 测试此日期是否在指定日期之后
				if (endDate.after(cal.getTime())) {
					lDate.add(cal.getTime());
				} else {
					break;
				}
			}
			lDate.add(endDate);// 把结束时间加入集合
		}
		return lDate;
	}
    /**
     * 右补位
     * @param str
     * @param len
     * @param c
     * @return
     */
    public static String addOnRight(String str,int len,char c){
        String tmpString = str;
        if(tmpString == null || tmpString.length() == 0){
            tmpString = "";
        }
        if(tmpString.length() >= len){
            return tmpString;
        }
        char arr[] = new char[len - tmpString.length()];
        Arrays.fill(arr,0,(len - tmpString.length()),c);
        return tmpString + String.valueOf(arr);
    }

	/**
	 * 通过正则表达式的方式获取字符串中指定字符的个数
	 * 
	 * @param str 指定的字符串
     * @param patternStr 正则表达式字符串
	 * @return 指定字符的个数
	 */
	public static int pattern(String str, String patternStr) {
		// 根据指定的字符构建正则
		Pattern pattern = Pattern.compile(patternStr);
		// 构建字符串和正则的匹配
		Matcher matcher = pattern.matcher(str);
		int count = 0;
		// 循环依次往下匹配
		while (matcher.find()) { // 如果匹配,则数量+1
			count++;
		}
		return count;
	}

	/**
	 * 按分割符出现次数的位置截取字符串，截取舍掉第n次出现位置及之后的字符
	 * 如果 n<=0 或 不存在分隔符，则返回字符串本身
	 * 如果 n>分隔符个数，则截取舍掉最后一个分隔符位置及之后的字符
	 * 
	 * @param str 指定的字符串
	 * @param split 分隔符
	 * @param n 从第n个分隔符截取
	 * @return
	 */
	public static String substringBySplit(String str, String split, int n) {
		int len = 0;
		for (int i = 0; i < n; i++) {
			int indexOf = str.indexOf(split, len);
			if (indexOf > -1) {
				len = indexOf + 1;
			}
		}
		return len > 0 ? str.substring(0, len - 1) : str;
	}

    /**
     * 字符串转换为Ascii
     * @param value
     * @return
     */
    public static String stringToAscii(String value)  
    {  
        StringBuffer sbu = new StringBuffer();  
        char[] chars = value.toCharArray();   
		for (int i = 0; i < chars.length; i++) {
			if (i == chars.length - 1) {
				sbu.append((int) chars[i]);
			} else {
				sbu.append((int) chars[i]).append(",");
			}
		}  
        return sbu.toString();  
    }
    
    /**
     * Ascii转换为字符串
     * @param value
     * @return
     */
    public static String asciiToString(String value)
    {
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }
	 /**
	 * 组装成in的SQL字符串,绑定变量，避免硬解析
	 * 
	 * @param propertyName 字段名称
	 * @param values 数据集合
	 * @return Map<String, Object[]>  key:命名参数  value:对应的参数值
	 * @author libo 2017-09-12
	 */
	public static Map<String, Object[]> createINSqlQuery(String propertyName, Object[] values) {
		Map<String, Object[]> map =new HashMap<String,Object[]>();
		if (null != values && values.length > 0) {
			for(int i=0;i<values.length;){
				Object[] value = Arrays.copyOfRange(values, i, Math.min(values.length, i+900));
				map.put(propertyName+i, value);
				i=i+900;
			}
		}
		return map;
	}

	
	
    /**
     * 右补位(计算长度的时候以gbk为编码)
     * @param str
     * @param len
     * @param c
     * @return
     * @throws UnsupportedEncodingException 
     */
    public static String addOnRightGBK(String str,int len,char c) throws UnsupportedEncodingException{
        String tmpString = str;
        if(tmpString == null || tmpString.length() == 0){
            tmpString = "";
        }
        int gbkLength = tmpString.getBytes("GBK").length;
        if(gbkLength >= len){
            return tmpString;
        }
        char arr[] = new char[len - gbkLength ];
        Arrays.fill(arr,0,(len - gbkLength ),c);
        return tmpString + String.valueOf(arr);
    }
    
    /**
	 * 
	 * 格式化等长字符串，加前缀
	 * @param s 字符串
	 * @param flag 前缀
	 * @param len 长度
	 * @return
	 * @author PJ
	 * @throws UnsupportedEncodingException 
	 */
	public static String stringGBKFormatLeft( String s , String flag, int len ) throws UnsupportedEncodingException {
		if(s == null){
			s = " ";
		}
		int add  = len -  s.getBytes("GBK").length;
		if( add>0 ){
			for(int i = 0; i< add ; i++){
				s = flag + s;
			}
		}
		return s;
	}
	
	 /**
  * 判断是否为数字（支持带小数和负号）
  * 
  * @param str
  * @return true:是数字；false:不是数字
  */
 public static boolean isNumeric_New(String str) {
  	if (isEmpty(str)) {
   	return false;
  	} else {
  	 String regex = "^(-?\\d+)(\\.\\d+)?$";
   	Pattern p = Pattern.compile(regex);
   	Matcher matcher = p.matcher(str);
   	return matcher.matches();
  	}
 }
 
 /**
  * 判断返回，M字符在 St字符中出现的次数
  * 
  * @param st 原字符
  * @param M  目标字符
  * 
  * @return 出现的次数
  */
  public static int way1(String st,String M) {
      int count = 0;
      while(st.indexOf(M)>=0) {
	  st=st.substring(st.indexOf(M)+M.length());
	  count++;
      }
      return count;
  }
 
  /**
   * 从临时表中获取产品拼接in方法
   * 
   * @param column
   * @return
   */
 public static String createExists(String column){
	  StringBuffer sql = new StringBuffer();
	  sql.append(" exists ( select fid from r_pa_product rpaproduct where ")
	     .append(column).append(" =rpaproduct.fid) ");
	  return sql.toString();
 }
	
//	public static void main(String[] agrs){
//		System.out.println(StringUtil.removeRepeat("1,2,3,1,3".split(",")));
//	}
 
/**
 * 去除字符串前后空白字符（BUG #265620 各渠道对接到300006托管系统的电子指令接收时需要进行首尾去空操作）
 *  
 * @author dgz
 * @param str
 * @return
 * @date 2019-08-28
 */
public static String replaceBlank(String str) {
	if (str != null && !"".equals(str)) {
		str.replaceAll("\n", "");
		Pattern p = Pattern.compile("(^\\s*)|(\\s*$)");
		Matcher m = p.matcher(str);
		String strNoBlank = m.replaceAll("");
		return strNoBlank;
	} else {
		return "";
	}
}
	/**
	 * 将数据结果集中的字段值转为String
	 * @param obj
	 * @return
	 */
	public static String getString(Object obj) {
		return String.valueOf(null == obj ? "" : obj);
	}
}
