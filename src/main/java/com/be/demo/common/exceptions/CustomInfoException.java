package com.be.demo.common.exceptions;

public class CustomInfoException extends CustomException {

    public CustomInfoException(String description) {
	super(description);
	this.status = ERROR_STATUS.INFO;

    }

}
