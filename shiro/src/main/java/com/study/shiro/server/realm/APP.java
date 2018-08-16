package com.study.shiro.server.realm;

import com.study.common.pojo.User;
import com.study.dubbo.mybatis.RolePermissionManager;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class APP {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        context.start();
        User user = new User();
        user.setUserName("aaa");
//        UserManager userManager = (UserManager) context.getBean("userManager");
//        System.out.println(userManager);
//        System.out.println(userManager.Test());
        RolePermissionManager rolePermissionManager = (RolePermissionManager) context.getBean("rolePermissionManager");
        rolePermissionManager.deleteByPrimaryKey(1L,2L);
    }
}
