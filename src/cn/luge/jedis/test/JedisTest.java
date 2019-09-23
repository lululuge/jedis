package cn.luge.jedis.test;

import cn.luge.jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest {
    @Test
    public void test1() {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("username", "zhangsan");
        String username = jedis.get("username");
        System.out.println(username);
        jedis.close();
    }

    @Test
    public void test2() {
        /**
         * jedis连接池
         */
        JedisPool pool = new JedisPool();
        Jedis jedis = pool.getResource();
        jedis.set("name", "陆昝");
        String name = jedis.get("name");
        System.out.println(name);
        jedis.close();

    }

    @Test
    public void test3() {
        /**
         * 使用jedisPool工具类
         *
         */
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("name", "陆昝");
        String name = jedis.get("name");
        System.out.println(name);
        jedis.close();
    }

}
