package com.github.monocc.logistic;

/**
 * 自定义物流异常
 */
public class LogisticException extends RuntimeException {
    public LogisticException() {
    }

    public LogisticException(String message) {
        super(message);
    }

    public LogisticException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogisticException(Throwable cause) {
        super(cause);
    }
}
