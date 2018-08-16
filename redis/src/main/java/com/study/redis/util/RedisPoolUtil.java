package com.study.redis.util;

import com.study.redis.RedisPool;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Set;

@Service
@Log4j2
public class RedisPoolUtil {
    public static Long expire(String key, int exTime) {
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = RedisPool.getResource();
            result = jedis.expire(key, exTime);
        } catch (Exception e) {
            log.error("Redis expire error key:{},exTime{},", key, exTime, e);
            e.printStackTrace();
        }
        return result;
    }

    public static Long expire(byte[] key, int exTime) {
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = RedisPool.getResource();
            result = jedis.expire(key, exTime);
        } catch (Exception e) {
            log.error("Redis expire error key:{},exTime{},", key, exTime, e);
            e.printStackTrace();
        }
        return result;
    }

    public static String set(String key, String value) {
        Jedis jedis = null;
        String result = null;
        try {
            jedis = RedisPool.getResource();
            result = jedis.set(key, value);
        } catch (Exception e) {
            log.error("Redis set error key:{},value{},", key, value, e);
            e.printStackTrace();
        }
        return result;
    }

    public static String set(byte[] key, byte[] value) {
        Jedis jedis = null;
        String result = null;
        try {
            jedis = RedisPool.getResource();
            result = jedis.set(key, value);
        } catch (Exception e) {
            log.error("Redis set error key:{},value{},", key, value, e);
            e.printStackTrace();
        }
        return result;
    }

    public static String get(String key) {
        Jedis jedis = null;
        String result = null;
        try {
            jedis = RedisPool.getResource();
            result = jedis.get(key);
        } catch (Exception e) {
            log.error("Redis get error key:{}", key, e);
            e.printStackTrace();
        }
        return result;
    }

    public static byte[] get(byte[] key) {
        Jedis jedis = null;
        byte[] result = null;
        try {
            jedis = RedisPool.getResource();
            result = jedis.get(key);
        } catch (Exception e) {
            log.error("Redis get error key:{}", key, e);
            e.printStackTrace();
        }
        return result;
    }

    public static Long del(String key) {
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = RedisPool.getResource();
            result = jedis.del(key);
        } catch (Exception e) {
            log.error("Redis del error key:{}", key, e);
            e.printStackTrace();
        }
        return result;
    }

    public static Long del(byte[] key) {
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = RedisPool.getResource();
            result = jedis.del(key);
        } catch (Exception e) {
            log.error("Redis del error key:{}", key, e);
            e.printStackTrace();
        }
        return result;
    }

    public static Set<byte[]> keys(String sHIRO_SESSION_PREFIX) {
        Jedis jedis = RedisPool.getResource();
        try {
            return jedis.keys(sHIRO_SESSION_PREFIX.getBytes());
        } finally {
            // TODO: handle finally clause
            jedis.close();
        }
    }
}
