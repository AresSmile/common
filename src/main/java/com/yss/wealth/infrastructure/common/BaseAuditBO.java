package com.yss.wealth.infrastructure.common;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseAuditBO extends BaseBO{
	/**
	 * 审核状态
	 */
	private String auditState;
}
