package com.mhb.services.exception;

public class TableNameErrorException extends Exception {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "表名字有异常";
	}
}
