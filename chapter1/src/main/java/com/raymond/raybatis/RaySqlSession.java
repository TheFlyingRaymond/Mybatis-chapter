package com.raymond.raybatis;

import com.raymond.raybatis.configuration.RayConfiguration;

public interface RaySqlSession {
    <T> T getMapper(Class<T> type);

    RayConfiguration getConfiguration();
}
