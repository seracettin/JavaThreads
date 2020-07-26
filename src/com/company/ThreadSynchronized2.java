package com.company;

public class ThreadSynchronized2 {
    public static void main(String[] args) throws InterruptedException {
        TestRunnable5 testRunnable5 = new TestRunnable5();
        Thread t1 = new Thread(testRunnable5,"Thread-1");
        Thread t2 = new Thread(testRunnable5,"Thread-2");
        t1.start();
        Thread.sleep(10);
        t2.start();

    }
}

class TestRunnable5 implements Runnable {

    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("Thread-1")){
            method1();
        }else{
            method2();
        }
    }
    synchronized void method1(){
        System.out.println(Thread.currentThread().getName()+" in synchronized void method1() start.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" in synchronized void method1() ended.");

    }
    synchronized void method2(){
        System.out.println(Thread.currentThread().getName()+" in synchronized void method2() start.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" in synchronized void method2() ended.");

    }
}
