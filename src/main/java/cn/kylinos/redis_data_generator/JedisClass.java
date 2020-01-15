package cn.kylinos.redis_data_generator;

import redis.clients.jedis.Jedis;

public class JedisClass {

    private static JedisClass uniqueInstance = new JedisClass();


    private JedisClass(){
        this.jedis = new Jedis("172.17.66.143",6381);
    }

    /**
     * 定义一个方法来为客户端提供类实例
     * @return 一个Singleton的实例
     */

    public static JedisClass getInstance(){
        return uniqueInstance;
    }

    /**
     * 示意方法，单例可以有自己的操作
     */

    public void singletonOperation(){

    }


    private Jedis jedis;
    public Jedis getJedis(){
        return jedis;
    }

}