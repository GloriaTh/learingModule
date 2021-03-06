package com.study.server.controller;

import com.study.common.annotation.DataSource;
import com.study.common.pojo.User;
import com.study.dubbo.mybatis.UserManager;
import com.study.mybatis.datasource.DbMultiDataSource;
import com.study.mybatis.sessionfactory.MultiSessionFactory;
import com.study.server.exception.GlobalException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.study.activemq.service.ProducerService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Gloria
 */
@Controller
@RequestMapping("/user/")
@EnableAspectJAutoProxy
public class UserController {
    @Autowired
    UserManager userManager;
    @Autowired
    private ProducerService producerService;
    //    @Autowired
//    private DbMultiDataSource multiDataSource;
    @Autowired
    MultiSessionFactory multiSessionFactory;

    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public void login(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(username, password, true));
    }

    @RequestMapping(value = "delete.do", method = RequestMethod.GET)
    @ResponseBody
    public void delete(String username, String password, HttpServletResponse httpServletResponse) throws GlobalException {
        Subject subject = SecurityUtils.getSubject();
        boolean permitted = subject.isPermitted("user:delete");
        System.out.println(permitted);
        System.out.println("delete");
        throw new GlobalException("Test");
    }

    @RequestMapping(value = "file.do")
    @ResponseBody
    public void file(MultipartFile file) throws GlobalException {
        File targetFile = new File(this.getClass().getClassLoader().getResource("/").getPath() + "/download/" + file.getOriginalFilename());
        System.out.println(targetFile.getAbsolutePath());
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "msg.do", method = RequestMethod.GET)
    @ResponseBody
    public void msg() {
        producerService.sendMessageTopic("tioew");
    }

    @RequestMapping(value = "msg2.do", method = RequestMethod.GET)
    @ResponseBody
    public void msg2() {
        producerService.sendMessage("World");
    }


    @RequestMapping(value = "test.do", method = RequestMethod.GET)
    @ResponseBody
    @DataSource(value = "mysqlSqlSessionFactory")
    public void test(String sourceName) {
//        multiDataSource.switchDataSource(sourceName);
//        multiSessionFactory.switchDataSource(sourceName);
        List<User> list = userManager.selectAll();
        System.out.println(list.toArray().toString());
    }
}
