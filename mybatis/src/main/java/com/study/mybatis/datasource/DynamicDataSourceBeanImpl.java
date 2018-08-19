package com.study.mybatis.datasource;


/**
 * @author Gloria
 */
public class DynamicDataSourceBeanImpl extends DynamicDataSourceBean {
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    public DynamicDataSourceBeanImpl(String beanName) {
        super(beanName);
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    protected String getBeanXml() {
        return null;
    }
}
