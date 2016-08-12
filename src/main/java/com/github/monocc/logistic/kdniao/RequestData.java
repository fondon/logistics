package com.github.monocc.logistic.kdniao;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 快递鸟请求数据
 */
public class RequestData {

    @JSONField(name="OrderCode")
    private String orderCode = "";
    @JSONField(name="ShipperCode")
    private String shipperCode;
    @JSONField(name="LogisticCode")
    private String logisticCode;

    public RequestData(String shipperCode, String logisticCode) {
        this.shipperCode = shipperCode;
        this.logisticCode = logisticCode;
    }

    public RequestData(String orderCode, String shipperCode, String logisticCode) {
        this.orderCode = orderCode;
        this.shipperCode = shipperCode;
        this.logisticCode = logisticCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getShipperCode() {
        return shipperCode;
    }

    public void setShipperCode(String shipperCode) {
        this.shipperCode = shipperCode;
    }

    public String getLogisticCode() {
        return logisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        this.logisticCode = logisticCode;
    }
}
