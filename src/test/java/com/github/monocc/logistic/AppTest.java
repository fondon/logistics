package com.github.monocc.logistic;

import com.alibaba.fastjson.JSON;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testMain() {
        Logistic logistic = ExpressUtils.getKdniaoLogisticManager().query("YTO", "882456690862029473");
        System.out.println(JSON.toJSONString(logistic));
    }

}
