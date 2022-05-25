package com.premiumminds.internship.screenlocking.exceptions;

public enum ErrorMessage{
    SCREEN_POINT_OUT_OF_RANGE("Screen point is out of range (1,9)"),
    INVALID_PATTERN_LENGTH("Invalid Pattern Length (1,9)"),

    UNKNOWN("Unknown Error Message");

    public final String label;
    
    ErrorMessage(String label) {
        this.label = label;
    }
}