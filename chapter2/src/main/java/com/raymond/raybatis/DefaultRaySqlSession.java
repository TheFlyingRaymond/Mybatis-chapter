package com.raymond.raybatis;

import com.raymond.raybatis.Executor.MockRayExecutor;
import com.raymond.raybatis.Executor.RayExecutor;
import com.raymond.raybatis.configuration.RayConfiguration;

import lombok.Data;

@Data
public class DefaultRaySqlSession implements RaySqlSession {
    private RayConfiguration configuration;
    private RayExecutor executor;

    public DefaultRaySqlSession(RayConfiguration configuration) {
        this.configuration = configuration;
        this.executor = new MockRayExecutor();
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public RayConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public void setConfiguration(RayConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Object tempSelectOne(String sql) {
        return executor.tempSelectOne(configuration, sql);
    }
}
