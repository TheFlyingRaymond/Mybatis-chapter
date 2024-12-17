package com.raymond.raybatis;

import org.junit.Assert;
import org.junit.Test;

import com.raymond.raybatis.testdata.dao.Country;
import com.raymond.raybatis.testdata.mapper.CountryMapper;

public class MainTest extends RayBaseTest {

    @Test
    public void test_selectMax_mock() throws Exception {
        Country country = sessionFactory.openSession().getMapper(CountryMapper.class).selectMax();
        System.out.println(country);
        Assert.assertNotNull(country);
    }

    @Test
    public void test_count_mock() throws Exception {
        Long count = sessionFactory.openSession().getMapper(CountryMapper.class).count();
        System.out.println(count);
        Assert.assertNotNull(count);
    }
}
