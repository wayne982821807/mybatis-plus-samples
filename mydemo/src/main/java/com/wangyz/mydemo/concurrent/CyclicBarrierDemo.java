package com.wangyz.mydemo.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @description:
 * @author: wangyz
 * @date: 2020/4/30 17:01
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        Random random = new Random();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        List<Thread> threads = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(()->{
                int time = random.nextInt(5) + 1;
                try {
                    // 通过线程休眠来模拟每位运动员的准备时间
                    Thread.sleep(time * 1000);
                    System.out.println(Thread.currentThread().getName() + "准备就绪");
                    // 运动员准备就绪后，就示意发令员自己准备好了，即调用await()方法
                    cyclicBarrier.await();
                    System.out.println("起跑枪响，"+Thread.currentThread().getName() + "起跑");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            },"运动员"+(i+1)));
        }

        for (Thread thread : threads) {
            thread.start();
        }

    }
}
