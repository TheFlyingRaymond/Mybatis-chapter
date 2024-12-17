package com.raymond.raybatis.testdata.mapper;

import java.util.List;

import com.raymond.raybatis.testdata.dao.User;

public interface UserMapper {
    List<User> selectAll();

    User selectMax();

    Long count();
}
