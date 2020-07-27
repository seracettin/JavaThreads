package com.company;

public class ThreadExample2 {
    public static void main(String[] args) throws InterruptedException {
        synchronized (args){
            System.out.println("1");
            args.wait();
            System.out.println("2");
        }
    }
}
