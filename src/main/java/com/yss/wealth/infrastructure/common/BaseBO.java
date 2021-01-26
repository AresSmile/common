package com.yss.wealth.infrastructure.common;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author libihui
 * @version 1.0 2020/1/15
 * BO基类
 */
@Setter
@Getter
public class BaseBO implements Serializable {
	/**
	 * 创建人
	 */
	private String createBy;
	
	/**
	 * 创建时间
	 */
	private String createTime; 
	
	/**
	 * 主键 
	 */
	private String id;
	
	/**
	 * 修改人
	 */
	private String updateBy;
	
	/**
	 * 修改时间
	 */
	private String updateTime;
	
	/**
	 * 删除标记
	 */
	private String deleteFlag;
	
}
