package com.raymond.raybatis.Executor;

import java.sql.Connection;
import java.sql.ResultSet;

import com.raymond.raybatis.configuration.RayConfiguration;
import com.raymond.raybatis.testdata.dao.Country;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MockRayExecutor implements RayExecutor {
    @Override
    public Object tempSelectOne(RayConfiguration configuration, String sql) {
        log.info("MockRayExecutor tempSelectOne, sql:{}", sql);
        try {
            Connection connection = configuration.getEnvironment().getDataSource().getConnection();
            ResultSet resultSet = connection.prepareStatement(sql).executeQuery();
            if (resultSet.next()) {
                Country country = new Country();
                country.setId(resultSet.getLong("id"));
                country.setCountryName(resultSet.getString("country_name"));
                country.setCountryCode(resultSet.getString("country_code"));
                log.info("MockRayExecutor tempSelectOne, sql:{}, ret:{}", sql, country);
                return country;
            }
        } catch (Exception e) {
            log.error("tempSelectOne error", e);
        }

        return null;
    }
}
