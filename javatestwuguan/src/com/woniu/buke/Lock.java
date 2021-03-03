package com.woniu.buke;

import javax.sound.midi.Soundbank;

public class Lock {
    private boolean isLocked=false;

    public synchronized void lock() throws InterruptedException {
        while(isLocked){
            System.out.println("lock");
            wait();
        }
        isLocked=true;
    }
    public synchronized void unlock(){
        System.out.println("unlock");
        isLocked=false;
        notify();
    }
}
