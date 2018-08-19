package com.study.mybatis.sessionfactory;

import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author Gloria
 */
public interface DynamicSqlSessionFactory extends SqlSessionFactory {
    /**
     * getSqlSessionFactory
     *
     * @return SqlSessionFactory
     */
    SqlSessionFactory getSqlSessionFactory();
}