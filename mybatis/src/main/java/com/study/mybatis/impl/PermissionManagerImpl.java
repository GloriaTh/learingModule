package com.study.mybatis.impl;

import com.study.mybatis.dao.PermissionMapper;
import com.study.common.pojo.Permission;
import com.study.dubbo.mybatis.PermissionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gloria
 */
@Service("permissionManager")
public class PermissionManagerImpl implements PermissionManager {
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public int deleteByPrimaryKey(Long permissionId) {
        return permissionMapper.deleteByPrimaryKey(permissionId);
    }

    @Override
    public int insert(Permission record) {
        return permissionMapper.insert(record);
    }

    @Override
    public Permission selectByPrimaryKey(Long permissionId) {
        return permissionMapper.selectByPrimaryKey(permissionId);
    }

    @Override
    public List<Permission> selectAll() {
        return permissionMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Permission record) {
        return permissionMapper.updateByPrimaryKey(record);
    }

}
