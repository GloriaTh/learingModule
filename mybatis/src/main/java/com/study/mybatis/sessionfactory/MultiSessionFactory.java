package com.study.mybatis.sessionfactory;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class MultiSessionFactory {
    private static ThreadLocal<String> local = new ThreadLocal<String>();

    public static int switchDataSource(String dataSourceName) {
        // 切换数据源
        if (StringUtils.isEmpty(dataSourceName)) {
            return 0;
        }
        local.set(dataSourceName);
        System.out.println(local.get());

        return 0;
    }

    public static String getName() {
        return local.get();
    }
}
