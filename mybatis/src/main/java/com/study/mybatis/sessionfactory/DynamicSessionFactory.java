package com.study.mybatis.sessionfactory;

import org.apache.ibatis.session.SqlSessionFactory;

public interface DynamicSessionFactory extends SqlSessionFactory {
    public SqlSessionFactory getSqlSessionFactory();
}