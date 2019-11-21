package com.ytq.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;

/**
 * @author yuantongqin
 * 2019/10/27
 */
public class RedissonTest {

    public static void main(String[] args) {

        Config config = new Config();
        ClusterServersConfig clusterServersConfig = config.useClusterServers().addNodeAddress("");



        RedissonClient redissonClient = Redisson.create(config);
        redissonClient.getLock("");

    }

}
