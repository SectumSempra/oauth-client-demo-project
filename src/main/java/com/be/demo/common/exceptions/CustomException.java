package com.be.demo.common.exceptions;

public class CustomException extends RuntimeException {

    enum ERROR_STATUS {
	INFO, ERROR, WARN, UNEXPECTED	
    }

    protected ERROR_STATUS status;
    protected String description;

    public CustomException() {
	super();
	this.status = ERROR_STATUS.INFO;
    }

    public CustomException(String description) {
	super(description);
	this.description = description;
    }

    public CustomException(ERROR_STATUS status, String description) {
	super(description);
	this.status = status;
	this.description = description;
    }

    public ERROR_STATUS getStatus() {
	return status;
    }

    public void setStatus(ERROR_STATUS status) {
	this.status = status;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

}
