package cn.kylinos.redis_data_generator;

import static java.lang.Thread.sleep;

public class TestRunner2 {
    public static void main(String[] args) throws InterruptedException {
        //JsonRunner
        while (true) {
            Thread t1 = new Thread(new JsonRunnable());
            sleep(100);
            t1.start();
            Thread t2 = new Thread(new HmsetRunnable());
            sleep(100);
            t2.start();
        }

        //HmsetRunner


    }

}
