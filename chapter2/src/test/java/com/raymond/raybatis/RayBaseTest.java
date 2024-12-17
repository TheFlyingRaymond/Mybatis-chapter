package com.raymond.raybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.junit.Before;

import com.raymond.raybatis.builder.RaySessionFactoryBuilder;
import com.raymond.raybatis.parsing.RayXPathParser;

public class RayBaseTest {
    protected RaySessionFactory sessionFactory;
    protected RayXPathParser parser;

    @Before
    public void before() throws Exception {

        sessionFactory = new RaySessionFactoryBuilder().build(Resources.getResourceAsReader("batis-config.xml"));

    }
}
