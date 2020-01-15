package cn.kylinos.redis_data_generator;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import redis.clients.jedis.Jedis;

import java.io.*;

public class JsonRunnable implements Runnable {

    public void jedisLpush(String filePath) {

        File file = new File(filePath);
        try {
            String file1 = FileUtils.readFileToString(file);
            JSONObject jobj = JSON.parseObject(file1);

            JSONArray tradestoreList = jobj.getJSONArray("tradestore");
            Jedis jedisData = JedisClass.getInstance().getJedis();
            for (Object o : tradestoreList) {
                JSONObject key = (JSONObject) o;
                String tradestoreValue = (String) key.get("value");
                jedisData.lpush("tradestore", tradestoreValue);
            }
            System.out.println("tradestore List completed");
            JSONArray vlprstoreList = jobj.getJSONArray("vlprstore");

            for (Object o : vlprstoreList) {
                JSONObject key = (JSONObject) o;
                String vlprstoreValue = (String) key.get("value");
                jedisData.lpush("vlprstore", vlprstoreValue);
            }
            System.out.println("vlprstore List completed");
            JSONArray otherstoreList = jobj.getJSONArray("otherstore");

            for (Object o : otherstoreList) {
                JSONObject key = (JSONObject) o;
                String otherstoreValue = (String) key.get("value");
                jedisData.lpush("otherstore", otherstoreValue);
            }
            System.out.println("otherstore List completed");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.jedisLpush("/home/kylin/redis.json");
        System.out.println(Thread.currentThread().getName() + ":" + "Json completed!");
    }
}
