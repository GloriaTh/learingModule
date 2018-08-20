package com.study.mybatis.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Gloria
 */
@Component
public class DbMultiDataSource {

    private static ThreadLocal<String> local = new ThreadLocal<>();

    private static String driverClassName;
    private static String preurl;
    private static String afurl;
    private static String username;
    private static String password;

    @Autowired
    private DynamicLoadBean dynamicLoadBean;

    static {
        Properties properties = new Properties();
        try {
            properties.load(DbMultiDataSource.class.getClassLoader().getResourceAsStream("datasource.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driverClassName = properties.getProperty("db.driverClassName");
        preurl = properties.getProperty("db.preurl");
        afurl = properties.getProperty("db.afurl");
        username = properties.getProperty("db.username");
        password = properties.getProperty("db.password");
    }

    public static String getName() {
        // 获取本线程中存入的数据源标识
        return local.get();
    }

    public int loadDynamicBean(String dataSourceName) {
        if (!dynamicLoadBean.hasBean(dataSourceName)) {
            /* ============== 动态装配DataSource begin ==================*/
            DynamicDataSourceBeanImpl dataSourceBean = new DynamicDataSourceBeanImpl(dataSourceName);
            dataSourceBean.setDriverClassName(driverClassName);
            dataSourceBean.setUrl(preurl + dataSourceName + afurl);
            dataSourceBean.setUsername(username);
            dataSourceBean.setPassword(password);

            dynamicLoadBean.loadBean(dataSourceBean);
        }
        // 切换数据源
        local.set(dataSourceName);

        return 0;
    }

    public static void switchDataSource(String dataSourceName) {
        // 切换数据源
        local.set(dataSourceName);
    }

    public void remove() {
        local.remove();
    }
}
