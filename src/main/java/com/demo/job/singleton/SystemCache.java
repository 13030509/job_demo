package com.demo.job.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: jiangjie
 * @date: 2019/11/26
 */
public class SystemCache {

    private SystemCache() {

    }

    private static SystemCache sysCache = new SystemCache();

    private Map<String, Object> mapCache = new HashMap();

    public static SystemCache getInstance() {
        return sysCache;
    }

    public Map<String, Object> getCacheMap() {
        return mapCache;
    }


}
