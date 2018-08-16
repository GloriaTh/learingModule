package com.study.mybatis.impl;

import com.study.mybatis.dao.RolePermissionMapper;
import com.study.common.pojo.RolePermission;
import com.study.dubbo.mybatis.RolePermissionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gloria
 */
@Service("rolePermissionManager")
public class RolePermissionManagerImpl implements RolePermissionManager {
    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @Override
    public int deleteByPrimaryKey(Long roleId, Long permissionId) {
        return rolePermissionMapper.deleteByPrimaryKey(roleId, permissionId);
    }

    @Override
    public int insert(RolePermission record) {
        return rolePermissionMapper.insert(record);
    }

    @Override
    public List<RolePermission> selectAll() {
        return rolePermissionMapper.selectAll();
    }
}
