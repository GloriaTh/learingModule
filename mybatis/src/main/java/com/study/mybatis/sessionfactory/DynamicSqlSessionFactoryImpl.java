package com.study.mybatis.sessionfactory;

import org.apache.ibatis.session.*;

import java.sql.Connection;
import java.util.Map;

/**
 * @author Gloria
 */
public class DynamicSqlSessionFactoryImpl implements DynamicSqlSessionFactory {
    private Map<Object, SqlSessionFactory> targetSqlSessionFactorys;
    private SqlSessionFactory defaultTargetSqlSessionFactory;

    @Override
    public SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory targetSqlSessionFactory = targetSqlSessionFactorys.get(MultiSessionFactory.getName());
        if (targetSqlSessionFactory != null) {
            return targetSqlSessionFactory;
        } else if (defaultTargetSqlSessionFactory != null) {
            return defaultTargetSqlSessionFactory;
        }
        return null;
    }

    public void setTargetSessionFactorys(Map<Object, SqlSessionFactory> targetSqlSessionFactorys) {
        this.targetSqlSessionFactorys = targetSqlSessionFactorys;
    }

    public void setDefaultTargetSessionFactory(SqlSessionFactory defaultTargetSqlSessionFactory) {
        this.defaultTargetSqlSessionFactory = defaultTargetSqlSessionFactory;
    }

    @Override
    public SqlSession openSession() {
        return this.getSqlSessionFactory().openSession();
    }

    @Override
    public SqlSession openSession(boolean b) {
        return this.getSqlSessionFactory().openSession(b);
    }

    @Override
    public SqlSession openSession(Connection connection) {
        return this.getSqlSessionFactory().openSession(connection);
    }

    @Override
    public SqlSession openSession(TransactionIsolationLevel transactionIsolationLevel) {
        return this.getSqlSessionFactory().openSession(transactionIsolationLevel);
    }

    @Override
    public SqlSession openSession(ExecutorType executorType) {
        return this.getSqlSessionFactory().openSession(executorType);
    }

    @Override
    public SqlSession openSession(ExecutorType executorType, boolean b) {
        return this.getSqlSessionFactory().openSession(executorType, b);
    }

    @Override
    public SqlSession openSession(ExecutorType executorType, TransactionIsolationLevel transactionIsolationLevel) {
        return this.getSqlSessionFactory().openSession(executorType, transactionIsolationLevel);
    }

    @Override
    public SqlSession openSession(ExecutorType executorType, Connection connection) {
        return this.getSqlSessionFactory().openSession(executorType, connection);
    }

    @Override
    public Configuration getConfiguration() {
        return this.getSqlSessionFactory().getConfiguration();
    }
}
