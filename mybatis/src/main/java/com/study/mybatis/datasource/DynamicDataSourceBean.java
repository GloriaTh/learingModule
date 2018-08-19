package com.study.mybatis.datasource;

public abstract class DynamicDataSourceBean {
    protected String beanName;

    public DynamicDataSourceBean(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    /**
     * 获取bean 的xml描述
     *
     * @return
     */
    protected abstract String getBeanXml();

    /**
     * 生成完整的xml字符串
     *
     * @return
     */
    public String getXml() {
        StringBuffer buf = new StringBuffer();
        buf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
                .append("<beans xmlns=\"http://www.springframework.org/schema/beans\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"")
                .append("   xmlns:p=\"http://www.springframework.org/schema/p\" xmlns:aop=\"http://www.springframework.org/schema/aop\"")
                .append("   xmlns:context=\"http://www.springframework.org/schema/context\" xmlns:jee=\"http://www.springframework.org/schema/jee\"")
                .append("   xmlns:tx=\"http://www.springframework.org/schema/tx\"")
                .append("   xsi:schemaLocation=\"")
                .append("   http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-3.0.xsd")
                .append("   http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd")
                .append("   http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd")
                .append("   http://www.springframework.org/schema/jee http://www.springframework.org/schema/jee/spring-jee-3.0.xsd")
                .append("   http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-3.0.xsd\">")
                .append(getBeanXml()).append("</beans>");
        return buf.toString();
    }
}