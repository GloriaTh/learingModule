package com.study.mybatis.impl;

import com.study.common.pojo.Permission;
import com.study.mybatis.dao.RoleMapper;
import com.study.common.pojo.Role;
import com.study.dubbo.mybatis.RoleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gloria
 */
@Service("roleManager")
public class RoleManagerImpl implements RoleManager {
    @Autowired
    RoleMapper roleMapper;

    @Override
    public int deleteByPrimaryKey(Long roleId) {
        return roleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    @Override
    public Role selectByPrimaryKey(Long roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public List<Role> selectAll() {
        return roleMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Permission> selectPermissionById(Long roleId) {
        return roleMapper.selectPermissionById(roleId);
    }
}
