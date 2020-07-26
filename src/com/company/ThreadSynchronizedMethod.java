package com.company;

public class ThreadSynchronizedMethod {

    public static void main(String[] args) {
    TestRunnable runnable = new TestRunnable();
    Thread t1 = new Thread(runnable,"T1");
    Thread t2 = new Thread(runnable,"T2");
    t1.start();
    t2.start();
    }
}

class TestRunnable implements Runnable {

    @Override
    public void run() {
        method2();
    }
     synchronized void method() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
     void method2() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
