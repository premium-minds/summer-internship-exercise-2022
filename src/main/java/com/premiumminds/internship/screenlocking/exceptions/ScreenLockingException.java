package com.premiumminds.internship.screenlocking.exceptions;

public class ScreenLockingException extends RuntimeException{
    private final ErrorMessage errorMessage;

    public ScreenLockingException(ErrorMessage errorMessage){
        super(errorMessage.label);
        this.errorMessage = errorMessage;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}