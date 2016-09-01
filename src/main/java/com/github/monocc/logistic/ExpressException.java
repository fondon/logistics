package com.github.monocc.logistic;

/**
 * 自定义物流异常
 */
public class ExpressException extends RuntimeException {
    public ExpressException() {
    }

    public ExpressException(String message) {
        super(message);
    }

    public ExpressException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExpressException(Throwable cause) {
        super(cause);
    }
}
