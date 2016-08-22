package com.github.monocc.logistic;

import com.github.monocc.logistic.kdniao.KdniaoManager;
import com.github.monocc.logistic.utils.PropertiesUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 获取所有的已经实现的Manager
 */
public class ExpressUtils {

    public final static Properties DEFAULT_CONF = PropertiesUtils.load("kuaidi.default.api.properties");

    private static Map<String, Object> instanceMap = new ConcurrentHashMap<>();
    private static ReadWriteLock lock = new ReentrantReadWriteLock();

    private final static String KDNIAO = ExpressUtils.class.getName() + ".kdniao";
    private final static String HTTP_CLIENT_POOL = ExpressUtils.class.getName() + ".http.client.pool";
    private final static String HTTP_CLIENT_REQUEST_CONFIG = ExpressUtils.class.getName() + ".http.client.request.config";

    /**
     * 取得快递鸟Manager
     * @return
     */
    public static LogisticManager getKdniaoLogisticManager() {
        LogisticManager manager = (LogisticManager) instanceMap.get(KDNIAO);
        if(manager == null) {
            String id = DEFAULT_CONF.getProperty("kdniao.api.id");
            String key = DEFAULT_CONF.getProperty(("kdniao.api.key"));
            manager = new KdniaoManager(id, key);
            instanceMap.put(KDNIAO, manager);
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
        LogisticManager manager = (LogisticManager) instanceMap.get(key);
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


    public HttpClient getHttpClient(PoolingHttpClientConnectionManager manager, RequestConfig requestConfig) {
        // 配置请求的超时设置
        return HttpClients.custom()
                .setConnectionManager(manager)
                .setDefaultRequestConfig(requestConfig)
                .build();
    }


    public HttpClient getHttpClientWithDefaultPool() {
        PoolingHttpClientConnectionManager manager = (PoolingHttpClientConnectionManager) instanceMap.get(HTTP_CLIENT_POOL);
        RequestConfig requestConfig = (RequestConfig) instanceMap.get(HTTP_CLIENT_REQUEST_CONFIG);
        if(manager == null || requestConfig == null) {
            //设置总连接数，和每个域名最大的线程，如果是只请求一个域名，那么两个值设置一致。否则，按实际情况设置，比如
            //permax连接数满了，permax又==max那么，有一个新域名来了，就必定要关闭原有连接，然后重建。浪费链接量
            manager = getPoolingHttpClientConnectionManager(200, 20);
            requestConfig = RequestConfig.custom()
                    .setConnectionRequestTimeout(3000)
                    .setConnectTimeout(3000)
                    .setSocketTimeout(3000)
                    .build();
            instanceMap.put(HTTP_CLIENT_POOL, manager);
        }
        return getHttpClient(manager, requestConfig);
    }


    public static void main(String[] args) {
//        Executor
    }

}
