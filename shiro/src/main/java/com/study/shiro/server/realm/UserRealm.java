package com.study.shiro.server.realm;

import com.study.common.pojo.Permission;
import com.study.common.pojo.Role;
import com.study.common.pojo.User;
import com.study.common.util.UsefulUtil;
import com.study.dubbo.mybatis.RoleManager;
import com.study.dubbo.mybatis.UserManager;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserManager userManager;
    @Autowired
    RoleManager roleManager;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        if (!UsefulUtil.isNull(username)) {
            User user = userManager.selectByPrimaryKey(username);
            Set<String> roleset = new HashSet<>();
            Set<String> permissionset = new HashSet<>();

            List<Role> roles = userManager.selectRoleByUserId(user.getUserId());
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            for (Role role : roles) {
                List<Permission> permissions = roleManager.selectPermissionById(role.getRoleId());
                for (Permission permission : permissions) {
                    permissionset.add(permission.getPermissionName());
                }
                roleset.add(role.getRoleName());
            }
            simpleAuthorizationInfo.setRoles(roleset);
            simpleAuthorizationInfo.setStringPermissions(permissionset);

            return simpleAuthorizationInfo;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
//        User user = userManager.selectByPrimaryKey(userName);
        String password = userManager.selectPassByUserName(userName);

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName, password, ByteSource.Util.bytes("qq654123"),
                this.getName());

        return authenticationInfo;
    }
}
