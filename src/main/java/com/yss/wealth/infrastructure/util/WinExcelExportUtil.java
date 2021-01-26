/****************************************************
 * 创建人：@author fengxin    
 * 创建时间: 2019/12/2/11:29
 * 项目名称: dfas-common-util
 * 文件名称: WinExcelExportUtil.java
 * 文件描述: @Description: 导出excel数据文件的工具类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2019-2030
 *
 ********************************************************/
package com.yss.wealth.infrastructure.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.handler.SheetWriteHandler;
import com.alibaba.excel.write.handler.WriteHandler;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.AbstractCellStyleStrategy;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.google.common.collect.Lists;
import com.yss.wealth.infrastructure.annotation.ExcelStyle;
import com.yss.wealth.infrastructure.annotation.ExplicitConstraint;
import com.yss.wealth.infrastructure.annotation.WinExcelTemplateDic;
import com.yss.wealth.infrastructure.common.WarningException;
import com.yss.wealth.infrastructure.enums.ExportFileTypeEnum;
import com.yss.wealth.infrastructure.handler.BaseSheetWriterHandler;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 包名称：com.ysstech.common
 * 类名称：WinExcelExportUtil
 * 类描述：数据导出到Excel文件
 * 创建人：@author fengxin
 * 创建时间：2019/12/2/9:22
 */
public final class WinExcelExportUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(WinExcelExportUtil.class);

    private static final int MAX_ROW_NUM_XLSX = 1048576;

    /**
     * Excel文件导出
     *
     * @param fileName  文件路径+文件名
     * @param sheetName sheet名
     * @param dataList  数据对象列表
     * @param clazz     <p>数据对象对应的Class
     *                  表头和内容字体大小背景色边框等可通过在该【类型】上添加@ExcelStyle设置
     *                  表头内容可通过在该类型的【字段】上添加@ExcelProperty注解设置，
     *                  列宽可通过在该类型的【字段】上添加@ColumnWidth注解设置</p>
     * @throws
     * @Title: exportExcel
     * @return: void
     * @author: fengxin
     * @Date: 2019年12月12日/上午10:07:14
     */
    public static <T> void exportExcel(String fileName, String sheetName, List<T> dataList, Class<T> clazz) {

        // 非空判断
        if (StringUtil.isEmpty(fileName)) {
            throw new RuntimeException("文件名不能为空");
        }

        OutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(fileName);

            // 导出文件
            exportExcel(outputStream, sheetName, dataList, clazz);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * Excel多个sheet导出
     *
     * @param fileName 导出数据时的文件名（不需要后缀）
     * @throws
     * @Title: downloadExcel
     * @return: void
     * @author: fengxin
     * @Date: 2019年12月12日/上午10:07:14
     */
    public static <T> void exportExcel(String fileName, ExcelExportParam... excelExportParams) {

        // 非空判断
        if (StringUtil.isEmpty(fileName)) {
            throw new RuntimeException("文件名不能为空");
        }

        OutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(fileName);

            // 导出文件
            exportExcel(outputStream, excelExportParams);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * Excel文件导出下载
     *
     * @param fileName  导出数据时的文件名（不需要后缀）
     * @param sheetName sheet名
     * @param dataList  数据对象列表
     * @param clazz     <p>数据对象对应的Class
     *                  表头和内容字体大小背景色边框等可通过在该【类型】上添加@ExcelStyle设置
     *                  表头内容可通过在该类型的【字段】上添加@ExcelProperty注解设置，
     *                  列宽可通过在该类型的【字段】上添加@ColumnWidth注解设置</p>
     * @throws
     * @Title: downloadExcel
     * @return: void
     * @author: fengxin
     * @Date: 2019年12月12日/上午10:07:14
     */
    public static <T> void downloadExcel(String fileName, String sheetName, List<T> dataList, Class<T> clazz) {

        // 非空判断
        if (StringUtil.isEmpty(fileName)) {
            throw new RuntimeException("文件名不能为空");
        }
        HttpServletResponse response = getResponse();
        if (null == getResponse()) {
            throw new RuntimeException("response为空");
        }
        HttpServletRequest request = getRequest();
        if (null == getRequest()) {
            throw new RuntimeException("request为空");
        }

        String userAgent = request.getHeader("User-Agent");
        if (StrUtil.isEmpty(userAgent)) {
            userAgent = "MSIE";
        }

        try {
            if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
                //IE浏览器处理
                fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
            } else {
                // 非IE浏览器的处理：
                fileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("不支持的编码类型");
        }

        // 设置response
        response.setContentType("application/octet-stream;multipart/form-data");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

        try {
            exportExcel(response.getOutputStream(), sheetName, dataList, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Excel文件导入模板下载-lja
     *
     * @param fileName  导出数据时的文件名（不需要后缀）
     * @param sheetName sheet名
     * @param clazz     <p>数据对象对应的Class
     *                  表头和内容字体大小背景色边框等可通过在该【类型】上添加@ExcelStyle设置
     *                  表头内容可通过在该类型的【字段】上添加@ExcelProperty注解设置，
     *                  列宽可通过在该类型的【字段】上添加@ColumnWidth注解设置</p>
     * @throws
     * @Title: downloadExcel
     * @return: void
     * @author: zhaokai
     * @Date: 2020/9/25 15:26
     */
    public static <T> void generateAndDownloadExcelTemplate(String fileName, String sheetName, List<T> dataList, Class<?> clazz) {
        // 非空判断

        Assert.notNull(clazz, "模板类不能为空");

        Field[] declaredFields = clazz.getDeclaredFields();

        Assert.notNull(declaredFields, "模板类属性不能为空");

        Assert.notEmpty(fileName, "文件名不能为空");

        if (StringUtil.isEmpty(sheetName)) {
            sheetName = "Sheet1";
        }

        //导出模板，集合是空
//        Assert.notEmpty(dataList, "集合不能为空");

        //装载数据字典下拉选项
        Map<Integer, String[]> params = new HashMap<>();

        //查询数据字典
        Map<String, Map<String, String>> dicMap = BeanUtilExtend.getDicKeyValueMapExp(clazz);

        //获取所有有 WinExcelTemplateDic注解的字段（包括其父类）
        List<Field> fields = BeanUtilExtend.getFieldByAnno(clazz, WinExcelTemplateDic.class);
        if (MapUtil.isNotEmpty(dicMap)
                && CollectionUtil.isNotEmpty(fields)) {
            for (Field field : fields) {
                WinExcelTemplateDic winExcelTemplateDic = field.getDeclaredAnnotation(WinExcelTemplateDic.class);
                List<String> paramsList = new ArrayList<>();
                List<String> dicCodeList = Arrays.asList(winExcelTemplateDic.dicCode());
                if (CollectionUtil.isNotEmpty(dicCodeList)) {
                    for (String dicCode : dicCodeList) {
                        if (MapUtil.isNotEmpty(dicMap.get(dicCode))) {
                            for (Map.Entry<String, String> entry : dicMap.get(dicCode).entrySet()) {
                                paramsList.add(entry.getKey().concat("-").concat(entry.getValue()));
                            }
                        }
                    }
                    if (CollectionUtil.isNotEmpty(paramsList)) {
                        params.put(winExcelTemplateDic.index(), paramsList.toArray(new String[paramsList.size()]));
                    }
                }

            }
        }

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        Assert.notNull(requestAttributes, "requestAttributes为空");
        HttpServletResponse response = ((ServletRequestAttributes) requestAttributes).getResponse();
        Assert.notNull(response, "response为空");

        HttpServletRequest request = RequestUtil.getRequest();
        Assert.notNull(request, "request为空");

        String userAgent = request.getHeader("User-Agent");

        if (StrUtil.isEmpty(userAgent)) {
            userAgent = "MSIE";
        }

        try {
            if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
                //IE浏览器处理
                fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
            } else {
                // 非IE浏览器的处理：
                fileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
            }
        } catch (UnsupportedEncodingException e) {
            throw WarningException.builder().message("不支持的编码类型").build();
        }

        // 设置response
        response.setContentType("application/octet-stream;multipart/form-data");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + "." + ExportFileTypeEnum.XLSX);

        try {
            // 写入文件
            ExcelWriterSheetBuilder excelWriterBuilder = EasyExcel.write(response.getOutputStream(), clazz).excelType(ExcelTypeEnum.XLSX).sheet(sheetName);
            excelWriterBuilder.registerWriteHandler(WinExcelExportUtil.getHorizontalCellStyleStrategy(clazz));
            excelWriterBuilder.registerWriteHandler(new ColumnWidthStyleStrategy());
            if (CollUtil.isNotEmpty(params)) {
                //有下拉字典
                excelWriterBuilder.registerWriteHandler(new BaseSheetWriterHandler(params));
            }
            excelWriterBuilder.doWrite(dataList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * Excel文件多个sheet导出下载
     *
     * @param fileName 导出数据时的文件名（不需要后缀）
     * @throws
     * @Title: downloadExcel
     * @return: void
     * @author: fengxin
     * @Date: 2019年12月12日/上午10:07:14
     */
    public static <T> void downloadExcel(String fileName, ExcelExportParam... excelExportParams) {

        // 非空判断
        if (StringUtil.isEmpty(fileName)) {
            throw new RuntimeException("文件名不能为空");
        }
        HttpServletResponse response = getResponse();
        if (null == getResponse()) {
            throw new RuntimeException("response为空");
        }
        HttpServletRequest request = getRequest();
        if (null == getRequest()) {
            throw new RuntimeException("request为空");
        }
        String userAgent = request.getHeader("User-Agent");

        if (StrUtil.isEmpty(userAgent)) {
            userAgent = "MSIE";
        }

        try {
            if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
                //IE浏览器处理
                fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
            } else {
                // 非IE浏览器的处理：
                fileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("不支持的编码类型");
        }

        // 设置response
        response.setContentType("application/octet-stream;multipart/form-data");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

        try {
            exportExcel(response.getOutputStream(), excelExportParams);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HttpServletResponse getResponse() {

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

        if (ObjectUtil.isEmpty(requestAttributes)) {
            return null;
        }

        return ((ServletRequestAttributes) requestAttributes).getResponse();
    }

    public static HttpServletRequest getRequest() {

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

        if (ObjectUtil.isEmpty(requestAttributes)) {
            return null;
        }

        return ((ServletRequestAttributes) requestAttributes).getRequest();
    }

    /**
     * 将数据写入到@code{OutputStream}中
     * 从clazz类的注解上获取写入时表头和表格内容的字体高度
     *
     * @param outputStream @code{OutputStream}
     * @param sheetName    sheet名
     * @param dataList     数据对象列表
     * @param clazz        <p>数据对象对应的Class
     *                     表头和内容字体大小背景色边框等可通过在该【类型】上添加@ExcelStyle设置
     *                     表头内容可通过在该类型的【字段】上添加@ExcelProperty注解设置，
     *                     列宽可通过在该类型的【字段】上添加@ColumnWidth注解设置</p>
     * @throws
     * @Title: exportExcel
     * @return: void
     * @author: fengxin
     * @Date: 2019年12月12日/上午10:01:32
     */
    public static <T> void exportExcel(OutputStream outputStream, String sheetName, List<T> dataList, Class<T> clazz) {
        // 写入输入流
        exportExcel(outputStream, sheetName, dataList, clazz, getHorizontalCellStyleStrategy(clazz), getExplicitListWriteHandler(clazz));
    }


    /**
     * 将数据写入到@code{OutputStream}中
     *
     * @param outputStream @code{OutputStream}
     * @param sheetName    sheet名
     * @param dataList     数据对象列表
     * @param clazz        <p>数据对象对应的Class
     *                     表头和内容字体大小背景色边框等可通过在该【类型】上添加@ExcelStyle设置
     *                     表头内容可通过在该类型的【字段】上添加@ExcelProperty注解设置，
     *                     列宽可通过在该类型的【字段】上添加@ColumnWidth注解设置</p>
     * @param writeHandlers 设置写入文件时的个性化处理，比如单元格样式字体
     * @throws
     * @Title: exportExcel
     * @return: void
     * @author: fengxin
     * @Date: 2019年12月12日/上午10:01:32
     */
    public static <T> void exportExcel(OutputStream outputStream, String sheetName, List<T> dataList, Class<T> clazz, WriteHandler... writeHandlers) {

        LOGGER.debug("exportExcel, sheetName = {}, dataList.size = {}, clazz = {}", sheetName, dataList != null ? dataList.size() : 0, clazz);

        // 非空判断
        if (null == outputStream) {
            throw new RuntimeException("输出流不能为空");
        }
        if (StringUtil.isEmpty(sheetName)) {
            throw new RuntimeException("sheetName不能为空");
        }
        if (null == dataList) {
            throw new RuntimeException("导出数据不能为空");
        }
        if (null == clazz) {
            throw new RuntimeException("导出对象类别不能为空");
        }

        if (CollectionUtil.isEmpty(Arrays.asList(writeHandlers))) {
            throw new RuntimeException("writeHandlers不能为空");
        }

        if (CollectionUtil.isEmpty(dataList)) {
            return;
        }

        // 写入文件
        ExcelWriterSheetBuilder excelWriteBuilder = EasyExcel.write(outputStream, clazz).excelType(ExcelTypeEnum.XLSX)
                .sheet(sheetName);
        for (WriteHandler writeHandler : writeHandlers) {
            excelWriteBuilder.registerWriteHandler(writeHandler);
        }
        excelWriteBuilder.doWrite(dataList);
    }


    /**
     * 将数据写入到@code{OutputStream}中
     *
     * @param outputStream      @code{OutputStream}
     * @param excelExportParams 导出多个sheet数据时需要的参数
     * @throws
     * @Title: exportExcel
     * @return: void
     * @author: fengxin
     * @Date: 2019年12月12日/上午10:01:32
     */
    public static <T> void exportExcel(OutputStream outputStream, ExcelExportParam... excelExportParams) {

        LOGGER.debug("excelExportMetaDatas:{}", Arrays.asList(excelExportParams));
        // 非空判断
        if (null == outputStream) {
            throw new RuntimeException("输出流不能为空");
        }
        if (null == excelExportParams) {
            throw new RuntimeException("excelExportMetaDatas不能为空");
        }

        // 写入文件
        ExcelWriter excelWriter = EasyExcel.write(outputStream).excelType(ExcelTypeEnum.XLSX).build();
        Set<String> sheetNameSet = new HashSet<>();
        Map<String, Integer> sheetNameMap = new HashMap<>();
        for (int i = 0; i < excelExportParams.length; i++) {
            ExcelExportParam excelExportParam = excelExportParams[i];
            String originalSheetName = excelExportParam.getSheetName();
            Integer sheetNameNum = sheetNameMap.containsKey(originalSheetName) ? sheetNameMap.get(originalSheetName) + 1 : 1;
            if (sheetNameMap.containsKey(originalSheetName)) {
                // 如果sheetName重复了就加上重复次数作为后缀进行区分
                String newSheetName = originalSheetName + sheetNameNum;
                excelExportParam.setSheetName(newSheetName);
            }
            sheetNameMap.put(originalSheetName, sheetNameNum);

            if (ObjectUtil.isNull(excelExportParam.getCellStyleStrategy())) {
                excelExportParam.setCellStyleStrategy(getHorizontalCellStyleStrategy(excelExportParam.getDataClass()));
            }
            WriteSheet writeSheet = EasyExcel
                    .writerSheet(i, excelExportParam.getSheetName())
                    .registerWriteHandler(excelExportParam.getCellStyleStrategy())
                    .registerWriteHandler(getExplicitListWriteHandler(excelExportParam.getDataClass()))
                    .head(excelExportParam.dataClass).build();
            excelWriter.write(excelExportParam.dataList, writeSheet);
        }
        excelWriter.finish();
    }


    @Data
    @NoArgsConstructor
    public static class ExcelExportParam {
        String sheetName;
        Class<?> dataClass;
        List<?> dataList;
        AbstractCellStyleStrategy cellStyleStrategy;

        public ExcelExportParam(String sheetName, Class dataClass, List dataList) {
            this.sheetName = sheetName;
            this.dataClass = dataClass;
            this.dataList = dataList;
        }
    }

    private static WriteCellStyle getWriteCellStyle(int fontHeight, int backColor, int borderColor, BorderStyle borderStyle) {

        WriteCellStyle writeCellStyle = new WriteCellStyle();

        // 设置字体
        WriteFont writeFont = new WriteFont();
        writeFont.setFontHeightInPoints((short) fontHeight);
        writeCellStyle.setWriteFont(writeFont);


        // 设置填充背景
        writeCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
        writeCellStyle.setFillForegroundColor((short) backColor);

        // 设置边框
        writeCellStyle.setBorderTop(borderStyle);
        writeCellStyle.setTopBorderColor((short) borderColor);
        writeCellStyle.setBorderBottom(borderStyle);
        writeCellStyle.setBottomBorderColor((short) borderColor);
        writeCellStyle.setBorderLeft(borderStyle);
        writeCellStyle.setLeftBorderColor((short) borderColor);
        writeCellStyle.setBorderRight(borderStyle);
        writeCellStyle.setRightBorderColor((short) borderColor);

        // 设置内容水平居中
        writeCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);

        return writeCellStyle;
    }

    private static <T> HorizontalCellStyleStrategy getHorizontalCellStyleStrategy(Class<T> clazz) {
        // 获取导出样式
        ExcelStyle excelStyle = clazz.getAnnotation(ExcelStyle.class);

        // 默认样式数据
        int headFontHeight = 11;
        int headBackColor = IndexedColors.SKY_BLUE.getIndex();
        int headBorderColor = IndexedColors.BLACK.getIndex();
        int headBorderStyle = BorderStyle.THIN.getCode();
        int contentFontHeight = 11;
        int contentBackColor = IndexedColors.WHITE.getIndex();
        int contentBorderColor = IndexedColors.BLACK.getIndex();
        int contentBorderStyle = BorderStyle.THIN.getCode();

        // 如果加了注解 使用注解中的样式数据
        if (ObjectUtil.isNotNull(excelStyle)) {
            headFontHeight = excelStyle.headFontHeight();
            headBackColor = excelStyle.headBackColor();
            headBorderColor = excelStyle.borderColor();
            headBorderStyle = excelStyle.borderStyle();
            contentFontHeight = excelStyle.contentFontHeight();
            contentBackColor = excelStyle.contentBackColor();
            contentBorderColor = excelStyle.borderColor();
            contentBorderStyle = excelStyle.borderStyle();
        }

        // 头的策略
        WriteCellStyle headWriteCellStyle = getWriteCellStyle(headFontHeight, headBackColor, headBorderColor, BorderStyle.valueOf((short) headBorderStyle));

        // 内容的策略
        WriteCellStyle contentWriteCellStyle = getWriteCellStyle(contentFontHeight, contentBackColor, contentBorderColor, BorderStyle.valueOf((short) contentBorderStyle));

        // 这个策略是 头是头的样式 内容是内容的样式 其他的策略可以自己实现

        return new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
    }

    private static <T> SheetWriteHandler getExplicitListWriteHandler(Class<T> clazz) {
        // 处理下拉列表
        // 下拉列表集合
        Map<Integer, String[]> explicitListConstraintMap = new HashMap<>();

        int headerRowNum = 1;

        // 循环获取对应列得下拉列表信息
        Field[] declaredFields = clazz.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            //解析注解信息
            ExplicitConstraint explicitConstraint = field.getAnnotation(ExplicitConstraint.class);
            ExcelProperty excelProperty = field.getAnnotation(ExcelProperty.class);

            if (ObjectUtil.isNotNull(excelProperty)) {
                if (excelProperty.value().length > headerRowNum) {
                    headerRowNum = excelProperty.value().length;
                }
            }

            if (ObjectUtil.isNotNull(explicitConstraint)) {
                // 下拉信息
                String[] explicitArray = explicitConstraint.source();
                if (explicitArray.length > 0) {
                    explicitListConstraintMap.put(i, explicitArray);
                }
            }

        }

        final int finalHeaderRowNum = headerRowNum;

        SheetWriteHandler sheetWriteHandler = new SheetWriteHandler() {
            @Override
            public void beforeSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {
            }

            @Override
            public void afterSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {
                //通过sheet处理下拉信息
                Sheet sheet = writeSheetHolder.getSheet();

                DataValidationHelper helper = sheet.getDataValidationHelper();
                explicitListConstraintMap.forEach((k, v) -> {
                    CellRangeAddressList rangeList = new CellRangeAddressList();
                    CellRangeAddress addr = new CellRangeAddress(finalHeaderRowNum, MAX_ROW_NUM_XLSX - 1, k, k);
                    rangeList.addCellRangeAddress(addr);
                    DataValidationConstraint constraint = helper.createExplicitListConstraint(v);
                    DataValidation validation = helper.createValidation(constraint, rangeList);
                    sheet.addValidationData(validation);
                });
            }
        };

        return sheetWriteHandler;


    }

}