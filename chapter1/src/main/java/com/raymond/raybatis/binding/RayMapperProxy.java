package com.raymond.raybatis.binding;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.raymond.raybatis.testdata.dao.Country;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RayMapperProxy<T> implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("拦截到了方法:{}", method.getName());

        Object ret = mockRet(method);
        if (ret != null) {
            log.info("成功mock返回数据:{}", ret);
            return ret;
        }

        log.info("未匹配mock策略，返回null");
        return null;
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
