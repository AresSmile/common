package com.yss.wealth.infrastructure.common.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author raojiangxiong
 * @version 1.0
 * @created 19-6月-2020 9:15:10
 */
@Data
public class QueryDTO {

	/**
	 * 控件类型      这里主要区分不同的控制类型的value格式不一样
	 * 单选Select                           String
	 * 输入框Input                        String
	 * 日期区间RangePicker        Date区间
	 * 单个日期DatePicker           Date
	 * 多选TreeSelect                    List<String>
	 * 数值InputNumber              数值区间
	 */
	@ApiModelProperty(value = "控件类型")
	private String controlType;
	/**
	 * datePicker控件value
	 */
	@ApiModelProperty(value = "datePicker控件value")
	private Date datePickerValue;
	/**
	 * InputNumber控件Value
	 */
	@ApiModelProperty(value = "InputNumber控件Value")
	private BigDecimal InputNumberEndValue;
	/**
	 * InputNumber控件Value
	 */
	@ApiModelProperty(value = "InputNumber控件Value")
	private BigDecimal inputNumberStartValue;
	/**
	 * input控件value
	 */
	@ApiModelProperty(value = "input控件value")
	private String inputValue;
	/**
	 * 字段名字  对应数据库字段名，用来拼接查询条件sql
	 */
	@ApiModelProperty(value = "字段名字 对应数据库字段名，用来拼接查询条件sql")
	private String name;
	/**
	 * rangePicker控件value     结束日期
	 */
	@ApiModelProperty(value = "rangePicker控件value     结束日期")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date rangePickerEndDate;
	/**
	 * rangePicker控件value     开始日期
	 */
	@ApiModelProperty(value = "rangePicker控件value     开始日期")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date rangePickerStartDate;
	/**
	 * select控件value
	 */
	@ApiModelProperty(value = "select控件value")
	private String selectValue;
	/**
	 * TreeSelect  控件value
	 */
	@ApiModelProperty(value = "TreeSelect  控件value")
	private List<String> treeSelectValue;



}