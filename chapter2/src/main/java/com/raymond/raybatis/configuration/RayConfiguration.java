package com.raymond.raybatis.configuration;

import com.raymond.raybatis.RaySqlSession;
import com.raymond.raybatis.binding.RayMapperRegistry;

import lombok.Data;

@Data
public class RayConfiguration {
    protected RayEnvironment environment;
    private RayMapperRegistry mapperRegistry = new RayMapperRegistry(this);

    public <T> T getMapper(Class<T> type, RaySqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }
}
