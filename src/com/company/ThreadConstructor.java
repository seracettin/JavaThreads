package com.company;

public class ThreadConstructor {

    public static void main(String[] args) {
        Thread thread = new TestThread(){
            @Override
            public void run() {
                System.out.println("3");
            }
        };
        thread.start();
    }
}
class TestThread extends Thread{
    TestThread(){
        System.out.println("1");
    }

    @Override
    public void run() {
        System.out.println("2");
    }
}
