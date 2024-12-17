package com.raymond.raybatis.Executor;

import com.raymond.raybatis.configuration.RayConfiguration;

public interface RayExecutor{
    Object tempSelectOne(RayConfiguration configuration, String sql);
}
