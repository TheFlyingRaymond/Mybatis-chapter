package com.raymond.raybatis.builder;

import java.io.Reader;

import com.raymond.raybatis.DefaultRaySessionFactory;
import com.raymond.raybatis.RaySessionFactory;
import com.raymond.raybatis.configuration.RayConfiguration;

public class RaySessionFactoryBuilder {
    public RaySessionFactory build(Reader reader) {
        //todo 解析
        return new DefaultRaySessionFactory(mockConfiguration());
    }

    private RayConfiguration mockConfiguration() {
        RayConfiguration ret = new RayConfiguration();

        return ret;
    }
}
