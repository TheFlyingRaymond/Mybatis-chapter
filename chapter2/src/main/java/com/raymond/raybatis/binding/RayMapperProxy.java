package com.raymond.raybatis.binding;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

import com.raymond.raybatis.RaySqlSession;
import com.raymond.raybatis.testdata.dao.Country;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RayMapperProxy<T> implements InvocationHandler {
    private final RaySqlSession sqlSession;
    private final Class<T> mapperInterface;
    private final Map<Method, RayMapperMethod> methodCache;

    public RayMapperProxy(RaySqlSession sqlSession, Class<T> mapperInterface,
                          Map<Method, RayMapperMethod> methodCache) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
        this.methodCache = methodCache;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RayMapperMethod rayMapperMethod = cachedMapperMethod(method);
        return rayMapperMethod.execute(sqlSession, args);
    }

    private RayMapperMethod cachedMapperMethod(Method method) {
        return methodCache.computeIfAbsent(method, k -> new RayMapperMethod(mapperInterface, method,
                sqlSession.getConfiguration()));
    }

    private Object mockRet(Method method) {
        if (!method.getDeclaringClass().getSimpleName().equals("CountryMapper")) {
            return null;
        }

        String name = method.getName();
        if ("count".equals(name)) {
            return 100L;
        }

        if ("selectMax".equals(name)) {
            return new Country(1L, "中国", "CN");
        }
        return null;
    }
}
