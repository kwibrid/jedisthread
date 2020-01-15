package cn.kylinos.redis_data_generator;

import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HmsetRunnable implements Runnable {

    public void jedisHmset() {

        try {
            Jedis jedisData = JedisClass.getInstance().getJedis();
//            jedisData.select(databassIndex);
            Map<String, String> map = new HashMap<String, String>();
            map.put("version", "v.1.7.0");
            map.put("state", "0");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = df.format(new Date());
            map.put("heartbeatime", date);
            jedisData.hmset("module_monitor*prod_2", map);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
//        this.jedisHmset(2);
        this.jedisHmset();
        System.out.println(Thread.currentThread().getName() + ":" + "jedisHmset completed!");
    }
}
