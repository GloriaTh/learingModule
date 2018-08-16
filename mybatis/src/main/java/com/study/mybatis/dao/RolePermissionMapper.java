package com.study.mybatis.dao;

import com.study.common.pojo.RolePermission;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    int insert(RolePermission record);

    List<RolePermission> selectAll();
}