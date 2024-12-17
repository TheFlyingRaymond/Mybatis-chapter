package com.raymond.raybatis.configuration;

import javax.sql.DataSource;

import lombok.Data;

@Data
public class RayEnvironment {
    private DataSource dataSource;

}
