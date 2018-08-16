package com.study.dubbo.mybatis;

import com.study.common.pojo.Permission;
import com.study.common.pojo.Role;
import com.study.common.pojo.User;

import java.util.List;

public interface UserManager {
    public int deleteByPrimaryKey(String userName);

    public int insert(User record);

    public User selectByPrimaryKey(String userName);

    public List<User> selectAll();

    public int updateByPrimaryKey(User record);

    public String Test();

    List<Role> selectRoleByUserName(String userName);

    List<Permission> selectPermissionByUserName(String userName);

    String selectPassByUserName(String userName);

    List<Role> selectRoleByUserId(Long userId);
}
