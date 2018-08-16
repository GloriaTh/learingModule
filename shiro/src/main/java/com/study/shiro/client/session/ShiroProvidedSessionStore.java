package com.study.shiro.client.session;

import org.apache.shiro.session.Session;

/**
 * @Desc 提供会话存储
 * @Author 何明胜
 * @Created at 2018年4月17日 上午12:00:09
 * @Version 1.0.1
 */
public class ShiroProvidedSessionStore extends ShiroSessionStore {

    private Session session;
    public ShiroProvidedSessionStore(Session session) {
        this.session = session;
    }
    @Override
    protected Session getSession(final boolean createSession) {
        return session;
    }
}