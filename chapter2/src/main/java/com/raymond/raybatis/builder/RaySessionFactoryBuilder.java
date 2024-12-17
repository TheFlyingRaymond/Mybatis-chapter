package com.raymond.raybatis.builder;

import java.io.Reader;

import com.raymond.raybatis.DefaultRaySessionFactory;
import com.raymond.raybatis.RaySessionFactory;
import com.raymond.raybatis.configuration.RayConfiguration;
import com.raymond.raybatis.parsing.RayXPathParser;

public class RaySessionFactoryBuilder {
    public RaySessionFactory build(Reader reader) {
        return new DefaultRaySessionFactory(new RayXMLConfigBuilder(new RayXPathParser(reader)).parse());
    }

    private RayConfiguration mockConfiguration() {
        RayConfiguration ret = new RayConfiguration();

        return ret;
    }
}
