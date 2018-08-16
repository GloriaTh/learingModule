package com.study.dubbo.mybatis;

import com.study.common.pojo.RolePermission;

import java.util.List;

public interface RolePermissionManager {

    public int deleteByPrimaryKey(Long roleId, Long permissionId);

    public int insert(RolePermission record);

    public List<RolePermission> selectAll();
}
