package com.company;

import java.util.ArrayList;
import java.util.List;

public class ThreadConusmerProducer {
    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer();
        Consumer consumer = new Consumer(producer);
        Thread t1 = new Thread(producer,"producerThread");
        Thread t2 = new Thread(consumer,"consumerThread");
        t2.start();
        Thread.sleep(100);
        t1.start();
    }

}
class Producer implements Runnable{
    List<Integer> sharedQuenue;
    Producer(){
        sharedQuenue = new ArrayList<>();
    }
    @Override
    public void run() {
        synchronized (this){
            for(int i=1;i<=3;i++){
                sharedQuenue.add(i);
                System.out.println("Producer is still Producing. Produced:" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Production is over, consumer can consume.");
            this.notify();
        }

    }
}
class Consumer extends Thread{
    Producer prod;
    Consumer(Producer prod){
        this.prod = prod;
    }

    @Override
    public void run() {
        synchronized (this.prod){
            System.out.println("Consumer waiting for production to get over.");
            try {
                this.prod.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int productionSize = this.prod.sharedQuenue.size();
        for(int i=0;i<productionSize;i++){
            System.out.println("Consumed : "+ this.prod.sharedQuenue.remove(0)+" ");
        }
    }
}
