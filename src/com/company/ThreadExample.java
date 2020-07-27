package com.company;

public class ThreadExample implements Runnable {
    ClassExample classExample;

    public static void main(String[] args) {
        new ThreadExample().method1();
    }

    void method1() {
        classExample = new ClassExample();
        new Thread(new ThreadExample()).start();
        new Thread(new ThreadExample()).start();
    }

    @Override
    public void run() {
        classExample.method(Thread.currentThread().getName());
    }
}

class ClassExample {
    void method(String name) {
        for (int i = 1; i <= 2; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
