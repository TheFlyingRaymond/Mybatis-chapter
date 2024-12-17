package com.raymond.raybatis.binding;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.raymond.raybatis.RaySqlSession;

public class RayMapperProxyFactory<T> {
    // 对应SQL的java接口类
    private final Class<T> mapperInterface;
    private final Map<Method, RayMapperMethod> methodCache = new ConcurrentHashMap<>();

    public RayMapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(RaySqlSession sqlSession) {
        final RayMapperProxy<T> mapperProxy = new RayMapperProxy<>(sqlSession, mapperInterface, methodCache);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }
}
