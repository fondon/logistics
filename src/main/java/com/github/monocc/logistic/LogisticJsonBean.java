package com.github.monocc.logistic;

import org.apache.commons.lang3.Validate;

import java.util.List;

/**
 * 将Logistic 转换为LogisticJsonBean json序列化
 */
public class LogisticJsonBean {

    private Logistic logistic;

    public LogisticJsonBean(Logistic logistic) {
        Validate.notNull(logistic);
        this.logistic = logistic;
    }

    public int getStatus() {
        return logistic.getStatus().getCode();
    }

    public String getState() {
        return logistic.getState().getName();
    }

    public ShipperCompany shipperCompany() {
        return logistic.shipperCompany();
    }

    public List<Trace> getTraces() {
        return logistic.getTraces();
    }

    public String getCode() {
        return logistic.getCode();
    }

    public String getMessage() {
        return logistic.getMessage();
    }
}
