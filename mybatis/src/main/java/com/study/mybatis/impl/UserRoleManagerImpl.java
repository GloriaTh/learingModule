package com.study.mybatis.impl;

import com.study.mybatis.dao.UserRoleMapper;
import com.study.common.pojo.UserRole;
import com.study.dubbo.mybatis.UserRoleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gloria
 */
@Service("userRoleManager")
public class UserRoleManagerImpl implements UserRoleManager {
    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public int deleteByPrimaryKey(Long userId, Long roleId) {
        return userRoleMapper.deleteByPrimaryKey(userId, roleId);
    }

    @Override
    public int insert(UserRole record) {
        return userRoleMapper.insert(record);
    }

    @Override
    public List<UserRole> selectAll() {
        return userRoleMapper.selectAll();
    }
}
