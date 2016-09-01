package com.github.monocc.logistic;

/**
 * 快递公司
 */
public class ShipperCompany {

    private String name;
    private String code;

    public ShipperCompany(String code, String name) {
        this.name = name;
        this.code = code;
    }


    /**
     * 快递公司代码
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * 快递名称
     * @return
     */
    public String getName() {
        return name;
    }
}
