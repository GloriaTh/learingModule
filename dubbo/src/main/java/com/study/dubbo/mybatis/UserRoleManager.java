package com.study.dubbo.mybatis;

import com.study.common.pojo.UserRole;

import java.util.List;

public interface UserRoleManager {
    public int deleteByPrimaryKey(Long userId, Long roleId);

    public int insert(UserRole record);

    public List<UserRole> selectAll();
}
