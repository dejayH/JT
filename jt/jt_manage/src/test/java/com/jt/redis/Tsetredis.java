package com.jt.redis;

import com.jt.config.RedisConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.params.Params;
import redis.clients.jedis.params.SetParams;

@SpringBootTest
public class Tsetredis {

    @Test
    public void testSet() throws InterruptedException {
        String host = "192.168.126.129";
        int port = 6379;
        Jedis jedis = new Jedis(host,port);

        jedis.set("2011","redis入门案例");
        System.out.println(jedis.get("2011"));
        jedis.flushAll();
        if(jedis.exists("2011")){
            jedis.del("2011");
        }else{
            jedis.set("num", "100");
            jedis.incr("num");
            jedis.expire("num", 20);
            Thread.sleep(2000);
            System.out.println(jedis.ttl("num"));
            jedis.persist("num");
        }

    }

    @Test
    public void testSetEx(){
        String host = "192.168.126.129";
        int port = 6379;
        Jedis jedis = new Jedis(host,port);

        /*jedis.set("a", "aa");
        jedis.expire("a", 60);*/
        jedis.setex("a", 20, "100");
        System.out.println(jedis.get("a"));

    }

    @Test
    public void testSetNX(){
        String host = "192.168.126.129";
        int port = 6379;
        Jedis jedis = new Jedis(host,port);

        jedis.set("a", "111");
        jedis.setnx("a", "123");
        System.out.println(jedis.get("a"));

        SetParams params = new SetParams();
        params.xx().ex(20);
        jedis.set("b", "bb", params);
    }

    @Test
    public void testHash(){
        String host = "192.168.126.129";
        int port = 6379;
        Jedis jedis = new Jedis(host,port);

        jedis.hset("user", "id","100");
        jedis.hset("user", "name","101");
        jedis.hset("user", "age","18");
        System.out.println(jedis.hkeys("user"));

    }

    @Test
    public void testList(){
        String host = "192.168.126.129";
        int port = 6379;
        Jedis jedis = new Jedis(host,port);

        jedis.lpush("list", "1,2,3,4");
        System.out.println(jedis.rpop("list"));
    }

    public void testTx(){
        String host = "192.168.126.129";
        int port = 6379;
        Jedis jedis = new Jedis(host,port);

        Transaction multi = jedis.multi();

    }

    @Autowired
    private Jedis jedis;

    @Test
    public void test(){
        jedis.set("aa", "123");
        System.out.println(jedis.get("aa"));
    }

}
