package com.study.mybatis.dao;

import com.study.common.pojo.Permission;
import com.study.common.pojo.Role;
import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(Role record);

    Role selectByPrimaryKey(Long roleId);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    List<Permission> selectPermissionById(Long roleId);
}