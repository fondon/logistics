package com.github.monocc.logistic.context;

import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * Created by chongdi.yang on 2016/8/13.
 */
public class HttpPoolConnectManager {

    PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();

    public HttpPoolConnectManager() {

    }


}
