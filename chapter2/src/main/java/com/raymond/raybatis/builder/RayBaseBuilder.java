package com.raymond.raybatis.builder;

import com.raymond.raybatis.configuration.RayConfiguration;

public class RayBaseBuilder {
    protected RayConfiguration configuration;

    public RayBaseBuilder(RayConfiguration configuration) {
        this.configuration = configuration;
    }
}
