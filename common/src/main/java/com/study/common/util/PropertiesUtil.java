package com.study.common.util;

import com.study.common.constant.Constant;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Log4j2
public class PropertiesUtil {
    private static Properties properties;

    static {
        log.info("PropertiesUtil开始初始化");
        String fileName = Constant.PROPERTIES_FILENAME;
        properties = new Properties();
        InputStream is = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
        try {
            properties.load(is);
        } catch (IOException e) {
            log.error("PropertiesUtil开始报错", e);
            e.printStackTrace();
        }
        log.info("PropertiesUtil初始化成功");
    }

    public static String getProperty(String name, String defaultValue) {
        String value = properties.getProperty(name);
        if (UsefulUtil.isNull(value)) {
            return defaultValue;
        }
        return value;
    }

    public static String getProperty(String name) {
        return properties.getProperty(name);
    }
}
