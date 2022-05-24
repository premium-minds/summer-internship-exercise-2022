package com.premiumminds.internship.screenlocking.exceptions;

public class ScreenLockinException extends RuntimeException{
    private final ErrorMessage errorMessage;

    public ScreenLockinException(ErrorMessage errorMessage){
        super(errorMessage.label);
        this.errorMessage = errorMessage;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}