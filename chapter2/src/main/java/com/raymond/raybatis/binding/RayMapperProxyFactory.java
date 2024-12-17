package com.raymond.raybatis.binding;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.raymond.raybatis.RaySqlSession;
import com.raymond.raybatis.testdata.mapper.CountryMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RayMapperProxyFactory<T> {
    // 对应SQL的java接口类
    private final Class<T> mapperInterface;
    private final Map<Method, RayMapperMethod> methodCache = new ConcurrentHashMap<>();

    public RayMapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
        initMockMethod();
    }

    private void initMockMethod() {
        try {
            Method method = CountryMapper.class.getMethod("selectMax");
            RayMapperMethod rayMapperMethod = new RayMapperMethod(CountryMapper.class, method, null);
            rayMapperMethod.setSql("select * from country order by id desc limit 1");
            methodCache.put(method,rayMapperMethod );
        } catch (Exception e) {
            log.error("初始化mock方法失败", e);
        }
    }

    public T newInstance(RaySqlSession sqlSession) {
        final RayMapperProxy<T> mapperProxy = new RayMapperProxy<>(sqlSession, mapperInterface, methodCache);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }
}
