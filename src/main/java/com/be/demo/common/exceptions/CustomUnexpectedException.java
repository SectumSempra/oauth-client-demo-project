package com.be.demo.common.exceptions;

public class CustomUnexpectedException extends CustomException {
    private String uuid;

    public CustomUnexpectedException(String uuid, String description) {
	super(description);
	this.uuid = uuid;
	this.status = ERROR_STATUS.UNEXPECTED;

    }

    public String getUuid() {
	return uuid;
    }

    public void setUuid(String uuid) {
	this.uuid = uuid;
    }

}
