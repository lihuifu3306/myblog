package com.crazy.article.redis;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shiyi
 * @version 1.0
 * @date 2020-7-18 15:27
 */
public class RedisTest {

    // 库存
    private static Integer inventory = 1001;
    private static final int NUM = 1000;
    private static LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(inventory, inventory, 10L, TimeUnit.SECONDS, linkedBlockingDeque);
        final CountDownLatch countDownLatch = new CountDownLatch(NUM);
        long start = System.currentTimeMillis();
        for (int i = 0; i <= NUM; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    reentrantLock.lock();
                    inventory--;
                    reentrantLock.unlock();
                    System.out.println("线程执行:" + Thread.currentThread().getName());
                    countDownLatch.countDown();
                }
            });
        }
        threadPoolExecutor.shutdown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("执行线程数：" + NUM + " 总耗时" + (end - start) + "库存数为" + inventory);

    }
}
