package com.baomidou.mybatisplus.samples.wrapper;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: wangyz
 * @date: 2020/4/29 16:08
 */
public class ReentrantLockTest2 {
    static Lock lock1 = new ReentrantLock(true);
    static Lock lock2 = new ReentrantLock(false);
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new waitDemo("线程1"));
        Thread thread2=new Thread(new waitDemo("线程2"));
        thread1.start();
        thread2.start();
//        for (int i=0;i<10;i++){
//            new Thread(new ThreadDemo("线程"+i)).start();
//        }
    }

    static class ThreadDemo implements Runnable {
        private String name;
        public ThreadDemo(String name){
            this.name=name;
        }

        @Override
        public void run() {
            try {
                lock1.lock();
                System.out.println(name+"获取锁");
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
//                lock1.unlock();
                System.out.println(name+"释放锁");

            }
        }
    }
    static class waitDemo implements Runnable{
        private String name;
        private int count=0;
        public waitDemo(String name){
            this.name=name;
        }

        @Override
        public void run() {
            for (;;) {
                count++;
                try {
                    TimeUnit.SECONDS.sleep(1);
                    lock2.lock();
                    System.out.println(count+"次"+name+"获取锁");
                } catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock2.unlock();
                    System.out.println(count+"次"+name+"释放锁");

                }
            }

        }
    }
}