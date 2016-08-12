package com.github.monocc.logistic;

/**
 * Created by chongdi.yang on 2016/8/8.
 */
public class SimpleShipperCompany implements ShipperCompany {
    private String name;
    private String code;

    public SimpleShipperCompany(String code, String name) {
        this.name = name;
        this.code = code;
    }


    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
