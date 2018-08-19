package com.study.mybatis.datasource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author Gloria
 */
@Component
public class DynamicLoadBean implements ApplicationContextAware {

    private ConfigurableApplicationContext applicationContext = null;
    private XmlBeanDefinitionReader beanDefinitionReader;

    public void init() {
        beanDefinitionReader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) applicationContext.getBeanFactory());
        beanDefinitionReader.setEntityResolver(new ResourceEntityResolver(applicationContext));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (ConfigurableApplicationContext) applicationContext;
    }

    private ConfigurableApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public boolean hasBean(String beanName) {

        return applicationContext.containsBean(beanName);
    }

    public void loadBean(String configLocationString) {

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) getApplicationContext().getBeanFactory());
        beanDefinitionReader.setResourceLoader(getApplicationContext());
        beanDefinitionReader.setEntityResolver(new ResourceEntityResolver(getApplicationContext()));

        try {
            String[] configLocations = new String[]{configLocationString};
            for (String config : configLocations) {
                beanDefinitionReader.loadBeanDefinitions(getApplicationContext().getResources(config));
            }
        } catch (BeansException | IOException e) {
            e.printStackTrace();
        }
    }

    public void loadBean(DynamicDataSourceBean dynamicDataSourceBean) {
        String beanName = dynamicDataSourceBean.getBeanName();
        if (applicationContext.containsBean(beanName)) {
            return;
        }
        beanDefinitionReader.loadBeanDefinitions(new DynamicResource(dynamicDataSourceBean));
    }

    public void removeBean(String beanName) {
        if (applicationContext.containsBean(beanName)) {
            BeanDefinitionRegistry beanDefinitionRegistry = (BeanDefinitionRegistry) applicationContext.getBeanFactory();
            beanDefinitionRegistry.removeBeanDefinition(beanName);
        }
    }

}