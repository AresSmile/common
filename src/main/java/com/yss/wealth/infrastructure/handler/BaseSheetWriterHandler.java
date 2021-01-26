package com.yss.wealth.infrastructure.handler;

import com.alibaba.excel.write.handler.SheetWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddressList;

import java.util.Map;

/**
 * 包名称：com.win.dfas.common.handler
 * 类名称：BaseSheetWriterHandler
 * 类描述：Excel创建Sheet处理
 * 创建人：@author zhaokai
 * 创建时间：2020/9/25 15:26
 *
 */
@Slf4j
public class BaseSheetWriterHandler implements SheetWriteHandler {

    /**
     * 下拉框值Map,key为下拉框所在列，默认为0，值为下拉框的值集合（数据字典值集合）
     */
    private Map<Integer, String[]> paramMap;

    public BaseSheetWriterHandler(Map<Integer, String[]> paramMap) {
        this.paramMap = paramMap;
    }

    @Override
    public void beforeSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {

    }

    @Override
    public void afterSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {

        Sheet sheet = writeSheetHolder.getSheet();

        //设置下拉框
        DataValidationHelper helper = sheet.getDataValidationHelper();

        paramMap.forEach((k, v) -> {
            // 下拉列表约束数据
            DataValidationConstraint constraint = helper.createExplicitListConstraint(v);
            // 设置下拉单元格的首行 末行 首列 末列
            CellRangeAddressList rangeList = new CellRangeAddressList(1, 65536, k, k);
            // 设置约束
            DataValidation validation = helper.createValidation(constraint, rangeList);
            // 阻止输入非下拉选项的值
            validation.setErrorStyle(DataValidation.ErrorStyle.STOP);
            validation.setShowErrorBox(true);
            validation.setSuppressDropDownArrow(true);
            validation.createErrorBox("提示","此值与单元格定义内容不一致");
            // validation.createPromptBox("填写说明：","填写内容只能为下拉数据集中的单位，其他单位将会导致无法入仓");
            sheet.addValidationData(validation);

        });
    }
}
