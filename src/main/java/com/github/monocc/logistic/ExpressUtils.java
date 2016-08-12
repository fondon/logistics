package com.github.monocc.logistic;

import com.github.monocc.logistic.kdniao.KdniaoManager;
import com.github.monocc.logistic.utils.PropertiesUtils;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 获取所有的已经实现的Manager
 */
public class ExpressUtils {

    private final static Properties DEFAULT_CONF = PropertiesUtils.load("kuaidi.default.api.properties");

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

}
