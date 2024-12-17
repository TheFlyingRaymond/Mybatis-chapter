package com.raymond.raybatis.builder;

import org.junit.Assert;
import org.junit.Test;

import com.raymond.raybatis.RayBaseTest;
import com.raymond.raybatis.configuration.RayConfiguration;
import com.raymond.raybatis.configuration.RayEnvironment;

public class RayEnvironmentBuilderTest extends RayBaseTest {

    @Test
    public void environments_parse_test() {
        RayConfiguration configuration = new RayConfiguration();
        String environment = "development";

        new RayEnvironmentBuilder(configuration, parser.evalNode("/configuration" +
                "/environments"), environment).parse();

        RayEnvironment ret = configuration.getEnvironment();
        System.out.println(ret);
        Assert.assertNotNull(ret);
    }
}
