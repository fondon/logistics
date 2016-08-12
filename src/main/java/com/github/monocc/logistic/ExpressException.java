package com.github.monocc.logistic;

/**
 * Created by chongdi.yang on 2016/8/8.
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
