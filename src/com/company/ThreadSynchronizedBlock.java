package com.company;

public class ThreadSynchronizedBlock {

    public static void main(String[] args) {
        Thread thread1 = new Thread("Thread-1") {
            public void run() {
                synchronized (String.class) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("1");
                    synchronized (Object.class) {
                        System.out.println("2");
                    }
                }
                System.out.println("3");
            }
        };
        Thread thread2 = new Thread("Thread-2") {
            public void run() {
                synchronized (Object.class) {
                    System.out.println("4");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (String.class) {
                        System.out.println("5");
                    }
                }
                System.out.println("6");
            }
        };
        thread1.start();
        thread2.start();
    }
}
