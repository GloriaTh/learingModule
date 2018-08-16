package com.study.dubbo.mybatis;

import com.study.common.pojo.Permission;
import com.study.common.pojo.Role;

import java.util.List;

public interface RoleManager {
    public int deleteByPrimaryKey(Long roleId);

    public int insert(Role record);

    public Role selectByPrimaryKey(Long roleId);

    public List<Role> selectAll();

    public int updateByPrimaryKey(Role record);

    List<Permission> selectPermissionById(Long roleId);
}
