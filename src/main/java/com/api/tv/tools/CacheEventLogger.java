package com.api.tv.tools;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheEventLogger implements CacheEventListener<Object, Object> {

    private static final Logger log = LoggerFactory.getLogger(CacheEventLogger.class);

    @Override
    public void onEvent(CacheEvent cacheEvent) {
        switch (cacheEvent.getType()) {
            case CREATED: log.info("Cache event created for item with key {} and value {}.",
                cacheEvent.getKey(), cacheEvent.getNewValue());
            case EXPIRED: log.info("Cache event expired for item with key {} and value {}.",
                cacheEvent.getKey(), cacheEvent.getNewValue());
        }

    }
}
