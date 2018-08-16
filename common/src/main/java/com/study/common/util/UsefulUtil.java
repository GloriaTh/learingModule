package com.study.common.util;

public class UsefulUtil {
    public static boolean isNull(String value) {
        if (value == null || value.length() == 0) {
            return true;
        }
        return false;
    }
}
