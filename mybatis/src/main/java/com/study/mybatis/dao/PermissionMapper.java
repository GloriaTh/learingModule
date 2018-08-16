package com.study.mybatis.dao;

import com.study.common.pojo.Permission;
import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long permissionId);

    int insert(Permission record);

    Permission selectByPrimaryKey(Long permissionId);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);
}