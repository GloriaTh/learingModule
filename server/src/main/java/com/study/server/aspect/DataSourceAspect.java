package com.study.server.aspect;

import com.study.common.annotation.DataSource;
import com.study.mybatis.datasource.DbMultiDataSource;
import com.study.mybatis.sessionfactory.MultiSessionFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Gloria
 */
@Aspect
@Component
public class DataSourceAspect {

    @Pointcut("execution(* com.study.server.controller.*.*(..))")
    public void pointCut() {
    }

    @Before(value = "pointCut()")
    public void before(JoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method m = signature.getMethod();
        DataSource annotation = m.getAnnotation(DataSource.class);
        if (m != null || annotation != null) {
            String value = annotation.value();
            MultiSessionFactory.switchDataSource(value);
        }
    }
}
