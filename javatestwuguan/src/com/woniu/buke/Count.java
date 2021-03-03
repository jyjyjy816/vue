package com.woniu.buke;

public class Count {
    static Lock lock=new Lock();
    public static void main(String [] args) throws InterruptedException {
        lock.lock();
        doAll();
        lock.unlock();
    }
    public static void doAll() throws InterruptedException {
        lock.lock();
        lock.unlock();
    }
}
