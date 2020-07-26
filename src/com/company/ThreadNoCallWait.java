package com.company;

public class ThreadNoCallWait {
    public static void main(String[] args) {
        TestRunnable3 testRunnable3 = new TestRunnable3();
        TestRunnable4 testRunnable4 = new TestRunnable4();
        Thread thread = new Thread(testRunnable3,"T1");
        Thread thread1 = new Thread(testRunnable4,"T2");
        thread.start();
        thread1.start();
    }
}
class TestRunnable3 implements Runnable{

    @Override
    public void run() {
        synchronized (this){
            System.out.println(Thread.currentThread().getName() + ": 1");
            try {
                this.wait(1000);
                System.out.println(Thread.currentThread().getName() + ": 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
class TestRunnable4 implements Runnable{

    @Override
    public void run() {
        synchronized (this){
            System.out.println(Thread.currentThread().getName() + ": 1");
            try {
                this.wait();
                System.out.println(Thread.currentThread().getName() + ": 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
