package com.raymond.raybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.junit.Before;

import com.raymond.raybatis.parsing.RayXPathParser;

public class RayBaseTest {
//        protected RayXMLConfigBuilder builder;
    protected Reader reader;
    protected RayXPathParser parser;

    @Before
    public void before() throws Exception {
        parser = new RayXPathParser(reader = Resources.getResourceAsReader("batis-config.xml"));
//        builder = new RayXMLConfigBuilder();
    }
}
