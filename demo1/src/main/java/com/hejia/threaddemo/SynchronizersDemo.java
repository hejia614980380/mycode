package com.hejia.threaddemo;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;

/**
 * @Author: hj
 * @Date: 2021/7/8 13:37
 */
public class SynchronizersDemo {
    @Test
    public void test1() {
        System.out.println(0xff);
    }

    //    public static void main(String[] args) {
//        CountDownLatch countDownLatch = new CountDownLatch(3);
//        try {
//            long now = System.currentTimeMillis();
//            new Thread(() -> {
//                System.out.println(Thread.currentThread().getName() + "已执行");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                countDownLatch.countDown();
//            }, "A").start();
//            new Thread(() -> {
//                System.out.println(Thread.currentThread().getName() + "已执行");
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                countDownLatch.countDown();
//            }, "B").start();
//            new Thread(() -> {
//                System.out.println(Thread.currentThread().getName() + "已执行");
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                countDownLatch.countDown();
//            }, "C").start();
//            countDownLatch.await();
//            System.out.println("继续执行");
//            System.out.println(System.currentTimeMillis() - now);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    public static void main(String[] args) {
//        Semaphore semaphore = new Semaphore(1);
//        long now = System.currentTimeMillis();
//        new Thread(() -> {
//            try {
//                semaphore.acquire();
//                System.out.println(Thread.currentThread().getName() + "进来了");
//                Thread.sleep(5000);
//                semaphore.release();
//                System.out.println(Thread.currentThread().getName() + "出去了");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, "A").start();
//        new Thread(() -> {
//            try {
//                semaphore.acquire();
//                System.out.println(Thread.currentThread().getName() + "进来了");
//                Thread.sleep(5000);
//                semaphore.release();
//                System.out.println(Thread.currentThread().getName() + "出去了");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, "B").start();
//        try {
//            semaphore.acquire();
//            System.out.println(System.currentTimeMillis() - now);
//            semaphore.release();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "发送数据");
            try {
                String content = exchanger.exchange("你好呀");
                System.out.println(content);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "发送数据");
            try {
                String content = exchanger.exchange("我不好");
                System.out.println(content);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
    }
}
