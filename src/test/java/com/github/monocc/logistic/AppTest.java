package com.github.monocc.logistic;

import com.alibaba.fastjson.JSON;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testMain() {
        Logistic logistic = LogisticUtils.getKdniaoLogisticManager().query("YZBK", "9977937815523");
        System.out.println(JSON.toJSONString(logistic));
    }

}
