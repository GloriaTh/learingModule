package com.study.mybatis.impl;

import com.study.common.pojo.Permission;
import com.study.common.pojo.Role;
import com.study.mybatis.dao.UserMapper;
import com.study.common.pojo.User;
import com.study.dubbo.mybatis.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gloria
 */
@Service("userManager")
public class UserManagerImpl implements UserManager {
    @Autowired
    UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(String userName) {
        return userMapper.deleteByPrimaryKey(userName);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public User selectByPrimaryKey(String userName) {
        return userMapper.selectByPrimaryKey(userName);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public String Test() {
        return "HELLO";
    }

    @Override
    public List<Role> selectRoleByUserName(String userName) {
        return null;
    }

    @Override
    public List<Permission> selectPermissionByUserName(String userName) {
        // TODO: 2018/7/28  
        return null;
    }

    @Override
    public String selectPassByUserName(String userName) {
        return userMapper.selectPassByUserName(userName);
    }

    @Override
    public List<Role> selectRoleByUserId(Long userId) {
        return userMapper.selectRoleByUserId(userId);
    }


}
