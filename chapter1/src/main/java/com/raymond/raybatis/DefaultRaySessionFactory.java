package com.raymond.raybatis;

import com.raymond.raybatis.configuration.RayConfiguration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultRaySessionFactory implements RaySessionFactory {
    private final RayConfiguration configuration;

    public DefaultRaySessionFactory(RayConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public RaySqlSession openSession() {
        return new DefaultRaySqlSession(configuration);
    }
}
