package com.study.redis;

import com.study.redis.util.RedisPoolUtil;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        RedisPoolUtil.set("Gloria","zhaoshi");
        System.out.println(RedisPoolUtil.get("Gloria"));
        System.out.println("Hello World!");
    }
}
