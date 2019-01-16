package com.ulanqab.daily.exception;

public class CommonException extends Exception{
    public CommonException() {
        super();
    }
    public CommonException(String message) {
        super(message);
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonException(Throwable cause) {
        super(cause);
    }
}
