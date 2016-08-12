package com.github.monocc.logistic;

import java.util.List;

/**
 * 物流信息
 */
public interface Logistic {

    /**
     * 接口状态
     */
    Status getStatus();

    /**
     * 消息，接口出错消息等
     * @return
     */
    String getMessage();

    /**
     * 物流编码
     * @return
     */
    String getCode();

    /**
     * 取得快递单状态
     * @return
     */
    State getState();


    /**
     * 快递公司
     * @return
     */
    ShipperCompany shipperCompany();


    /**
     * 物流跟踪列表
     * @return
     */
    List<Trace> getTraces();







}
