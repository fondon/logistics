package com.github.monocc.logistic;

import org.apache.commons.lang3.Validate;

import java.util.Properties;

/**
 * 抽象实现LogisticManager
 */
public abstract class AbstarctLogisticManager implements LogisticManager {

    @Override
    public boolean supports(String shipperCompanyCode) {
        if(getProperties() != null) {
            return getProperties().getProperty(shipperCompanyCode) != null;
        }
        return false;
    }

    @Override
    public Logistic query(String shipperCompanyCode, String logisticCode, TracesOrder tracesOrder) {
        Validate.notBlank(shipperCompanyCode, "物流公司代码不能为空");
        Validate.notBlank(logisticCode, "物流号不能为空");
        if(tracesOrder == null) {
            tracesOrder = TracesOrder.DESC;
        }
        return doQuery(shipperCompanyCode, logisticCode, tracesOrder);
    }


    @Override
    public Logistic query(String shipperCompanyCode, String logisticCode) {
        return query(shipperCompanyCode, logisticCode, TracesOrder.DESC);
    }

    public abstract Logistic doQuery(String shipperCompanyCode, String logisticCode, TracesOrder tracesOrder);

    @Override
    public int order() {
        return 0;
    }

    /**
     * 如果实现了该方法，可以不用重写{@link AbstarctLogisticManager#supports(String)}方法， 否则需要重写 supports方法。
     */
    protected Properties getProperties() {
        return new Properties();
    }
}
