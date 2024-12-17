package com.raymond.raybatis;

import java.lang.reflect.Proxy;

import com.raymond.raybatis.binding.RayMapperProxy;
import com.raymond.raybatis.configuration.RayConfiguration;

public class DefaultRaySqlSession implements RaySqlSession {
    private final RayConfiguration configuration;

    public DefaultRaySqlSession(RayConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return getProxy(type);
    }

    private <T> T getProxy(Class<T> type) {
        return (T) Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, new RayMapperProxy<>());
    }

    @Override
    public RayConfiguration getConfiguration() {
        return configuration;
    }
}
