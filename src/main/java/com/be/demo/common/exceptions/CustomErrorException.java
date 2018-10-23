package com.be.demo.common.exceptions;

public class CustomErrorException extends CustomException {

    public CustomErrorException(String description) {
	super(description);
	this.status = ERROR_STATUS.ERROR;

    }
}
