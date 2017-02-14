package com.gramazski.xmlparsing.exception;

/**
 * Created by gs on 14.02.2017.
 */
public class XMLMarshallerException extends Exception {
    public XMLMarshallerException() {
    }

    public XMLMarshallerException(String message, Throwable exception) {
        super(message, exception);
    }

    public XMLMarshallerException(String message) {
        super(message);
    }

    public XMLMarshallerException(Throwable exception) {
        super(exception);
    }
}
