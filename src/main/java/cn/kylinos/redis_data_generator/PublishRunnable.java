package cn.kylinos.redis_data_generator;

import redis.clients.jedis.Jedis;

public class PublishRunnable implements Runnable {

    public void jedisPublic() {

        try {
            Jedis jedisData = JedisClass.getInstance().getJedis();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.jedisPublic();
        System.out.println(Thread.currentThread().getName() + ":" + "Publish completed!");
    }
}
