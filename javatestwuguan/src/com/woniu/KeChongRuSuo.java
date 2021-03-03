package com.woniu;

import javax.sound.midi.Soundbank;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class KeChongRuSuo {
    public static void main(String[] agrs){
       // 什 么 是 可 重 入 性 ， 为 什 么 说 Synchronized 是 可 重 入 锁 ？
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    synchronized (this) {
//                        System.out.println("第1次获取锁，这个锁是：" + this);
//                        int index = 1;
//                        while (true) {
//                            synchronized ("11") {
//                                System.out.println("第" + (++index) + "次获取锁，这个锁是：" + this);
//                            }
//                            if (index == 10) {
//                                break;
//                            }
//                        }
//                    }
//                }
//            }).start();
        haha2();
    }

    public static synchronized void haha1(){
        for (int i = 0; i <10 ; i++) {
            System.out.println(i+">>>>>haha1");
        }

    }

    public static synchronized void haha2(){
        haha1();
        System.out.println("haha2");
    }

//    public static void main(String[] args) {
//        ReentrantLock lock = new ReentrantLock();
//        System.out.println("一开始=="+lock);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    lock.lock();
//                    System.out.println("第1次获取锁，这个锁是：" + lock);
//
//                    int index = 1;
//                    while (true) {
//                        try {
//                            lock.lock();
//                            System.out.println("第" + (++index) + "次获取锁，这个锁是：" + lock);
//
//                            try {
//                                Thread.sleep(new Random().nextInt(200));
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//
//                            if (index == 10) {
//                                break;
//                            }
//                        } finally {
//                            //lock.unlock();
//                        }
//
//                    }
//
//                } finally {
//                    System.out.println("haha=="+lock);
//                    lock.unlock();
//                    for (int i = 0; i < 9; i++) {
//                        lock.unlock();
//
//                    }
//                }
//            }
//        }).start();
//
//
//
//
//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                try {
//                    lock.lock();
//
//                    for (int i = 0; i < 20; i++) {
//                        System.out.println("threadName:" + Thread.currentThread().getName());
//                        try {
//                            Thread.sleep(new Random().nextInt(200));
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                } finally {
//                    lock.unlock();
//                }
//            }
//        }).start();
//        System.out.println("最后=="+lock);
//    }
}
