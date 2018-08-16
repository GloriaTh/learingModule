package com.study.mybatis.dao;

import com.study.common.pojo.Role;
import com.study.common.pojo.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String userName);

    int insert(User record);

    User selectByPrimaryKey(String userName);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    String Test();

    List<Role> selectRoleByUserId(Long userId);

    String selectPassByUserName(String userName);
}