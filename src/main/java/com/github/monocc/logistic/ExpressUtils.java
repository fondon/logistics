package com.github.monocc.logistic;

import com.github.monocc.logistic.kdniao.KdniaoManager;
import com.github.monocc.logistic.utils.PropertiesUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 获取所有的已经实现的Manager
 */
public class ExpressUtils {

    public final static Properties DEFAULT_CONF = PropertiesUtils.load("kuaidi.default.api.properties");

    private static Map<String, LogisticManager> instanceMap = new ConcurrentHashMap<>();
    private static ReadWriteLock lock = new ReentrantReadWriteLock();

    private final static String KDNIAO_NAME = ExpressUtils.class.getName() + ".kdniao";

    /**
     * 取得快递鸟Manager
     * @return
     */
    public static LogisticManager getKdniaoLogisticManager() {
        LogisticManager manager = instanceMap.get(KDNIAO_NAME);
        if(manager == null) {
            String id = DEFAULT_CONF.getProperty("kdniao.api.id");
            String key = DEFAULT_CONF.getProperty(("kdniao.api.key"));
            manager = new KdniaoManager(id, key);
            instanceMap.put(KDNIAO_NAME, manager);
        }
        return manager;
    }

    /**
     * FIXME 有问题需要修复，由于暂时没有用到，不做处理。
     * @param key
     * @param apiId
     * @param apiKey
     * @return
     */
    protected static LogisticManager getLogisticManager(String key, String apiId, String apiKey) {
        LogisticManager manager = instanceMap.get(key);
        if(manager == null) {
            manager = new KdniaoManager(apiId, apiKey);
            instanceMap.put(key, manager);
        }
        return manager;
    }


    /**
     *
     * @param max 通常上百个，如果一个系统每天并发量上百万，那么該值肯定要设置上千，上万。
     * @param perHostMax  请求单个域名最大数量限制，设置不能过小，通常也是上几十。
     * @return
     */
    public PoolingHttpClientConnectionManager getPoolingHttpClientConnectionManager(int max, int perHostMax) {
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
        manager.setMaxTotal(max); //设置最大请求数量，如果超过就等待连接池有足够的数量
        manager.setDefaultMaxPerRoute(perHostMax); //每个host的最大请求数
        return manager;
    }


    public HttpClient getHttpClient(PoolingHttpClientConnectionManager manager) {
        return HttpClients.custom()
                .setConnectionManager(manager)
                .build();
    }


    public static void main(String[] args) {
//        Executor
    }

}
