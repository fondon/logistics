package com.github.monocc.logistic.kuaidi100;

import com.github.monocc.logistic.AbstarctLogisticManager;
import com.github.monocc.logistic.Logistic;
import com.github.monocc.logistic.TracesOrder;

/**
 * 接入快递100接口
 */
public class Kuaidi100Manager extends AbstarctLogisticManager {

    private String url = "https://www.kuaidi100.com/query?type=youzhengguonei&postid=9977937814368&temp=0.6672724718235279&phone=";
    private String companyUrl = "https://www.kuaidi100.com/autonumber/autoComNum?resultv2=1&text=9977937815525";

    @Override
    public Logistic doQuery(String shipperCompanyCode, String logisticCode, TracesOrder tracesOrder) {
        return null;
    }

}
