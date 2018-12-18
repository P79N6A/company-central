package com.ihappy.partner.common.util;

import com.ihappy.myredis.MyRedisClusterForHessian;

import java.util.Collections;
import java.util.Set;

/**
 * Created by sunjd on 2018/9/27.
 */
public class RedisTool {
    private static MyRedisClusterForHessian myRedis;

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    private static final Long RELEASE_SUCCESS = 1L;

    public void setMyRedis(MyRedisClusterForHessian myRedis) {
        RedisTool.myRedis = myRedis;
    }

    /**
     * 尝试获取分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间 单位秒
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(String lockKey, String requestId,int expireTime) {

        String result = myRedis.getJedisCluster().set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);

        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    /**
     * 释放分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public static boolean releaseDistributedLock(String lockKey, String requestId) {

        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = myRedis.getJedisCluster().eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    /**
     * 向名称为key的set中添加元素member
     * @param key
     * @param member
     * @return
     */
    public static Long sadd(String key,String... member){
        return myRedis.getJedisCluster().sadd(key,member);
    }

    /**
     *  移除并返回集合中的一个随机元素
     * @param key
     * @return
     */
    public static String spop(String key){
        return myRedis.getJedisCluster().spop(key);
    }

    /**
     * 将 srckey 的元素，移动到 dstkey,并返回srckey 当时的set
     * @param srckey
     * @param dstkey
     * @return
     */
    public static Set<String> smove(String srckey, String dstkey){
        Set<String> srcSet = myRedis.getJedisCluster().smembers(srckey);
        srcSet.forEach((obj) -> {
            myRedis.getJedisCluster().smove(srckey,dstkey,obj);
        });
        return srcSet;
    }
    
    /**
     * @Author sunjd
     * @Description 元素的个数
     * @Date 15:26 2018/9/30
     * @Param [key]
     * @return java.lang.Long
     **/
    public static Long scard(String key){
        return myRedis.getJedisCluster().scard(key);
    }
}
