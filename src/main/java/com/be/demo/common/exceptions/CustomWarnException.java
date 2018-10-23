package com.be.demo.common.exceptions;

public class CustomWarnException extends CustomException {

    public CustomWarnException(String description) {
	super(description);
	this.status = ERROR_STATUS.WARN;

    }
}
