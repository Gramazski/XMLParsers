package com.gramazski.xmlparsing.exception;

/**
 * Created by gs on 14.02.2017.
 */
public class BuilderInitializationException extends Exception {
    public BuilderInitializationException() {
    }

    public BuilderInitializationException(String message, Throwable exception) {
        super(message, exception);
    }

    public BuilderInitializationException(String message) {
        super(message);
    }

    public BuilderInitializationException(Throwable exception) {
        super(exception);
    }
}
