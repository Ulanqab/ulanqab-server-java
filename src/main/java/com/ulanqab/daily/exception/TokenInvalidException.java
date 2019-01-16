package com.ulanqab.daily.exception;

import javax.servlet.ServletException;

public class TokenInvalidException extends ServletException {
    public TokenInvalidException() {
        super();
    }

    public TokenInvalidException(String message) {
        super(message);
    }

    public TokenInvalidException(String message, Throwable rootCause) {
        super(message, rootCause);
    }

    public TokenInvalidException(Throwable rootCause) {
        super(rootCause);
    }
}
