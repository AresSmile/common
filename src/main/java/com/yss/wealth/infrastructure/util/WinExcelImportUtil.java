/****************************************************
 * 创建人：@author fengxin    
 * 创建时间: 2019/11/26/17:08
 * 项目名称: dfas-common-util
 * 文件名称: WinExcelImportUtil.java
 * 文件描述: @Description: excel数据导入工具类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2019-2030
 *
 ********************************************************/
package com.yss.wealth.infrastructure.util;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.yss.wealth.infrastructure.annotation.WinExcelTemplateDic;
import com.yss.wealth.infrastructure.common.MessageException;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 包名称：com.win.dfas.common.util
 * 类名称：WinExcelDataImportUtil
 * 类描述：excel数据导入工具类
 * 创建人：@author fengxin
 * 创建时间：2019/11/26/17:08
 */
public final class WinExcelImportUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(WinExcelImportUtil.class);
	
	/**
	 * 
	 * 从excel文件流中导入指定名称sheet的数据
	 * @Title: importExcel
	 * @param fileName
	 * @param sheetName
	 * @param clazz
	 * @return   
	 * @return: List<T>   
	 * @throws
	 * @author: fengxin 
	 * @Date:  2019年12月11日/下午5:17:56
	 */
	public static <T> List<T> importExcel(String fileName, String sheetName, Class<T> clazz) {
		
		LOGGER.debug("importExcel, fileName = {}, sheetName = {}, clazz = {}", fileName, sheetName, clazz);
		
		// 非空判断
		if(StringUtil.isEmpty(fileName)){
			throw new RuntimeException("输入流不能为空");
		}
		if(StringUtil.isEmpty(sheetName)){
			throw new RuntimeException("sheetName不能为空");
		}
		
		InputStream inputStream = null;
		
		List<T> returnList = null;
		
		try {
			inputStream = new FileInputStream(fileName);
			
			// 读取文件
			returnList = importExcel(inputStream, sheetName, clazz);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return returnList;
	}
	
	/**
	 * 
	 * 从excel文件流中导入指定名称sheet的数据
	 * @Title: importExcel
	 * @param inputStream
	 * @param sheetName
	 * @param clazz
	 * @return   
	 * @return: List<T>   
	 * @throws
	 * @author: fengxin 
	 * @Date:  2019年12月11日/下午5:17:56
	 */
	public static <T> List<T> importExcel(InputStream inputStream, String sheetName, Class<T> clazz) {
		
		LOGGER.debug("importExcel, sheetName = {}, clazz = {}", sheetName, clazz);
		
		// 非空判断
		if(null == inputStream){
			throw new RuntimeException("输入流不能为空");
		}
		if(StringUtil.isEmpty(sheetName)){
			throw new RuntimeException("sheetName不能为空");
		}
		
		DataListener<T> listener = new DataListener<T>();
		
		EasyExcel.read(inputStream,clazz, listener).sheet(sheetName).doRead();

		List<T> dataList = listener.getDataList();

		//对数据字典类型进行切割转换，
		List<Field> fieldByAnno = BeanUtilExtend.getFieldByAnno(clazz, WinExcelTemplateDic.class);
		if (CollectionUtil.isNotEmpty(fieldByAnno)) {
			dataList.forEach(dto -> {
				for (Field field : fieldByAnno) {
					Object fieldValue = ReflectUtil.getFieldValue(dto, field.getName());
					if (ObjectUtil.isNull(fieldValue) || StringUtil.isEmpty(fieldValue.toString())) {
						continue;
					}

					ReflectUtil.setFieldValue(dto, field, fieldValue.toString().split("-")[0]);
				}
			});
		}
		return dataList;
		
	}
	
	/**
	 * 
	 * 从excel文件流中导入指定名称sheet的数据
	 * @Title: importExcel
	 * @param sheetName sheet名称
	 * @param clazz 对象类
	 * @param listener 导入监听器(自定义逻辑在监听器实现)
	 * @return   
	 * @return: List<T>   
	 * @throws
	 * @author: fengxin 
	 * @Date:  2019年12月11日/下午5:17:56
	 */
	public static <T> void importExcel(String fileName, String sheetName, Class<T> clazz, AnalysisEventListener<T> listener) {
		
		LOGGER.debug("importExcel, fileName = {}, sheetName = {}, clazz = {}, listener = {}", fileName, sheetName, clazz, listener);
		
		// 非空判断
		if(StringUtil.isEmpty(fileName)){
			throw new RuntimeException("文件路径不能为空");
		}
		if(StringUtil.isEmpty(sheetName)){
			throw new RuntimeException("sheetName不能为空");
		}
		if(null == listener){
			throw new RuntimeException("listener不能为空");
		}
		
		InputStream inputStream = null;
		
		try {
			inputStream = new FileInputStream(fileName);
			
			importExcel(inputStream, sheetName, clazz, listener);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	/**
	 * 
	 * 从excel文件流中导入指定名称sheet的数据
	 * @Title: importExcel
	 * @param inputStream 输入流
	 * @param sheetName sheet名称
	 * @param clazz 对象类
	 * @param listener 导入监听器(自定义逻辑在监听器实现)
	 * @return   
	 * @return: List<T>   
	 * @throws
	 * @author: fengxin 
	 * @Date:  2019年12月11日/下午5:17:56
	 */
	public static <T> void importExcel(InputStream inputStream, String sheetName, Class<T> clazz, AnalysisEventListener<T> listener) {
		
		LOGGER.debug("importExcel, sheetName = {}, clazz = {}, listener = {}", sheetName, clazz, listener);
		
		// 非空判断
		if(null == inputStream){
			throw new RuntimeException("输入流不能为空");
		}
		if(StringUtil.isEmpty(sheetName)){
			throw new RuntimeException("sheetName不能为空");
		}
		if(null == listener){
			throw new RuntimeException("listener不能为空");
		}
		
		EasyExcel.read(inputStream,clazz, listener).sheet(sheetName).doRead();
	}
	
	/**
	 * @Title: importExcel
	 * @Description: 
	 * @param inputStream
	 * @param clazz   
	 * @return: void   
	 * @throws
	 * @author: dengyong 
	 * @Date:  2020年3月22日/下午4:58:22 
	 */
	public static <T> List<T> importExcel(InputStream inputStream, Class<T> clazz) {
		LOGGER.debug("importExcel, clazz = {}", clazz);
		// 非空判断
		if(null == inputStream){
			throw new RuntimeException("输入流不能为空");
		}
				
		DataListener<T> listener = new DataListener<>();
		EasyExcel.read(inputStream, clazz, listener).sheet(0).doRead();
		return listener.getDataList();
	}
	
	/**
	 * 调用EasyExcel时需传入的回调类
	 * 
	 * 包名称： com.win.dfas.common.util 
	 * 类名称：DataListener 
	 * 类描述：fengxin 
	 * 创建人：@author hechengcheng 
	 * 创建时间：2019年12月11日/下午5:14:33
	 *
	 */
	@Data
	static class DataListener<T> extends AnalysisEventListener<T> {

		private List<T> dataList = new ArrayList<T>();
		//单次导入系统阀值为50000
		private static  final int MAX_ROWS = 50000;
		
		@Override
		public void invoke(T data, AnalysisContext context) {
			dataList.add(data);
			if (dataList.size() >MAX_ROWS){
				throw new MessageException("导入数据超过阀值，阀值为："+MAX_ROWS);
			}
		}

		@Override
		public void doAfterAllAnalysed(AnalysisContext context) {
			
		}
		
	}

}


