package com.gramazski.xmlparsing.exception;

/**
 * Created by gs on 14.02.2017.
 */
public class XMLBuildingException extends Exception {
    public XMLBuildingException() {
    }

    public XMLBuildingException(String message, Throwable exception) {
        super(message, exception);
    }

    public XMLBuildingException(String message) {
        super(message);
    }

    public XMLBuildingException(Throwable exception) {
        super(exception);
    }
}
