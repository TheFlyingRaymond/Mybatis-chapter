package com.raymond.raybatis.binding;

import java.lang.reflect.Method;

import com.raymond.raybatis.RaySqlSession;
import com.raymond.raybatis.configuration.RayConfiguration;

import lombok.Data;

//运行时的方法信息,根据方法信息可以拿到之前配置解析后获取的数据
@Data
public class RayMapperMethod {
    private RayConfiguration configuration;

    private String sql;

    public <T> RayMapperMethod(Class<T> mapperInterface, Method method, RayConfiguration configuration) {
        this.configuration = configuration;
    }

    public Object execute(RaySqlSession sqlSession, Object[] args) {
        return sqlSession.tempSelectOne(getSql());
    }
}
