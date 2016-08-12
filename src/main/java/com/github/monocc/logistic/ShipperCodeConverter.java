package com.github.monocc.logistic;

/**
 * 标准定义物流编码 转换为 指定第三方 快递公司规定的物流编码
 */
public interface ShipperCodeConverter {

    ShipperCompany convert(String standardShipperCode);
}
