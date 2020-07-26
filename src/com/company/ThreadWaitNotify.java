package com.company;

public class ThreadWaitNotify {
    public static void main(String[] args) throws InterruptedException {
        TestRunnable1 testRunnable1 = new TestRunnable1();
        TestRunnable2 testRunnable2 = new TestRunnable2(testRunnable1);
        Thread t1 = new Thread(testRunnable1,"T1");
        Thread t2 = new Thread(testRunnable2,"T2");
        t2.start();
        Thread.sleep(100);
        t1.start();
    }
}
class TestRunnable1 implements Runnable{

    @Override
    public void run() {
        synchronized (this){
            try {
                System.out.println("2");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.notify();
            System.out.println("3");
        }
    }
}
class TestRunnable2 extends Thread{
    TestRunnable1 testRunnable1;
    TestRunnable2(TestRunnable1 obj){
        testRunnable1 = obj;
    }

    @Override
    public void run() {
        synchronized (this.testRunnable1){
            System.out.println("1");
            try {
                this.testRunnable1.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("4");
        }
    }
}
