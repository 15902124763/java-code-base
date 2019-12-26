package com.yarm.service.impl;


import lombok.SneakyThrows;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: base-parent
 * @description: redis
 * @author: yarm.yang
 * @create: 2019-12-25 15:11
 */
public class RedisServiceImpl {

    public static void main(String[] args) {

        // 创建并填充节点信息
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("180.76.159.196", 7000));
        nodes.add(new HostAndPort("180.76.159.196", 7001));
        nodes.add(new HostAndPort("180.76.159.196", 7002));
        nodes.add(new HostAndPort("180.76.159.196", 7003));
        nodes.add(new HostAndPort("180.76.159.196", 7004));
        nodes.add(new HostAndPort("180.76.159.196", 7005));

        // 创建JedisCluster对象
//        JedisCluster jedisCluster = new JedisCluster(nodes);

        JedisPoolConfig config = new JedisPoolConfig();
        config =new JedisPoolConfig();
        config.setMaxTotal(60000);//设置最大连接数
        config.setMaxIdle(1000); //设置最大空闲数
        config.setMaxWaitMillis(3000);//设置超时时间
        config.setTestOnBorrow(true);

        JedisCluster jedisCluster = new JedisCluster(nodes, 20, 1, 1, "123456", config);

        // 使用jedisCluster操作redis
        String key = "jedisCluster";
        String setResult = jedisCluster.set(key, "hello redis!");
        System.out.println(setResult);

        String getResult = jedisCluster.get(key);
        System.out.println(getResult);

        // 关闭jedisCluster（程序执行完后才能关闭，内部封装了连接池）
//        jedisCluster.close();

    }
}
