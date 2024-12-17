package com.raymond.raybatis.testdata.mapper;


import com.raymond.raybatis.testdata.dao.Country;

public interface CountryMapper {
    Country selectMax();

    Long count();
}
