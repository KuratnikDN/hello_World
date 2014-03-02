package com.bsu.project2.exceptions;

/**
 * Created by vildhet on 23.02.14.
 */
public class Project2TechException extends Exception {
    public Project2TechException() {
        super();
    }

    public Project2TechException(String message) {
        super(message);
    }

    public Project2TechException(String message, Throwable cause) {
        super(message, cause);
    }

    public Project2TechException(Throwable cause) {
        super(cause);
    }

    protected Project2TechException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
