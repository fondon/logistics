package com.github.monocc.logistic;

import com.github.monocc.logistic.utils.PropertiesUtils;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 标准StandarCompany对应关系
 */
public class StandarShipperCompany {

    private static String PATH = "kuaidi.standar.properties";

    private static Map<String, ShipperCompany> STANDAR = new ConcurrentHashMap<>();

    static {
        Properties properties = PropertiesUtils.load(PATH, StandarShipperCompany.class.getClassLoader());
        ShipperCompany company = null;
        for(Map.Entry<Object, Object> entry : properties.entrySet()) {
            company = new SimpleShipperCompany(entry.getKey().toString(), entry.getValue().toString());
            STANDAR.put(company.getCode(), company);
        }
    }

    public static ShipperCompany getStandarShipperCompany(String key) {
        return STANDAR.get(key);
    }

    public static void main(String[] args) {
        System.out.println(STANDAR);
    }

}
