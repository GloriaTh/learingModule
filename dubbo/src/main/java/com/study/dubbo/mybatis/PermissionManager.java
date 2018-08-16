package com.study.dubbo.mybatis;

import com.study.common.pojo.Permission;

import java.util.List;

public interface PermissionManager {
    public int deleteByPrimaryKey(Long permissionId);

    public int insert(Permission record);

    public Permission selectByPrimaryKey(Long permissionId);

    public List<Permission> selectAll();

    public int updateByPrimaryKey(Permission record);
}
