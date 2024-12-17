package com.raymond.raybatis.builder;

import org.apache.ibatis.parsing.XNode;

import com.raymond.raybatis.configuration.RayConfiguration;
import com.raymond.raybatis.parsing.RayXPathParser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RayXMLConfigBuilder {
    private RayXPathParser parser;
    private RayConfiguration configuration;

    private String environment;

    public RayXMLConfigBuilder(RayXPathParser parser) {
        this.parser = parser;
        this.configuration = new RayConfiguration();
    }

    public RayConfiguration parse() {
        log.info("开始解析配置文件");
        parseConfiguration(parser.evalNode("/configuration"));
        return configuration;
    }

    private void parseConfiguration(XNode xNode) {
        //environments：用户名密码等
        parseEnvironments(xNode.evalNode("environments"));
    }

    public void parseEnvironments(XNode context) {
        new RayEnvironmentBuilder(configuration, context, environment).parse();
    }
}
