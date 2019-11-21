package com.ytq.redis;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisSentinelPool;

/**
 * @author yuantongqin
 * 2019/10/27
 */
public class JedisTest {

    public static void main(String[] args) {
//        JedisPool
//        JedisSentinelPool jedisSentinelPool = new JedisSentinelPool()
//
//        JedisCluster cluster = new JedisCluster();
//        cluster.set()


        JedisPool jedisPool = new JedisPool("",8000);
        Jedis jedis = jedisPool.getResource();

    }

    public void s(){

        ReentrantReadWriteLock readLock = new ReentrantReadWriteLock();

        ReentrantReadWriteLock.ReadLock readLock1 = readLock.readLock();

    }

}
