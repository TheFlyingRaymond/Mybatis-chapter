package com.raymond.raybatis.binding;

import java.util.HashMap;
import java.util.Map;

import com.raymond.raybatis.RaySqlSession;
import com.raymond.raybatis.configuration.RayConfiguration;
import com.raymond.raybatis.testdata.mapper.CountryMapper;
import com.raymond.raybatis.testdata.mapper.UserMapper;

public class RayMapperRegistry {
    private RayConfiguration configuration;

    private final Map<Class<?>, RayMapperProxyFactory<?>> knownMappers = new HashMap<>();

    public RayMapperRegistry(RayConfiguration configuration) {
        this.configuration = configuration;
        initMock();
    }

    private void initMock() {
        knownMappers.put(UserMapper.class, new RayMapperProxyFactory<>(UserMapper.class));
        knownMappers.put(CountryMapper.class, new RayMapperProxyFactory<>(CountryMapper.class));
    }

    public <T> T getMapper(Class<T> type, RaySqlSession sqlSession) {
        if (!knownMappers.containsKey(type)) {
            throw new RuntimeException("未发现对应的代理工厂，class:" + type.getSimpleName());
        }
        return (T) knownMappers.get(type).newInstance(sqlSession);
    }
}
