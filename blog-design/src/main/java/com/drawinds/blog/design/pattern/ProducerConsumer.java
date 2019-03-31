package com.drawinds.blog.design.pattern;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/3/30 23:46
 * Description:
 */
public class ProducerConsumer {
    public static int MAX_CAPACITY = 10;
    private Lock lock = new ReentrantLock();
    private Condition fullConfition = lock.newCondition();
    private Condition emptyCondition = lock.newCondition();

    public static void main(String[] args) {

    }

}


class Producer implements Runnable {

    List<Product> storage;
    private Lock lock;
    private Condition fullConfition;
    private Condition emptyCondition;

    public Producer(List<Product> storage, Lock lock, Condition fullCondition, Condition emptyCondition) {
        assert storage != null;
        this.storage = storage;
        this.lock = lock;
        this.fullConfition = fullCondition;
        this.emptyCondition = emptyCondition;
    }


    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                while (storage.size()==ProducerConsumer.MAX_CAPACITY){
                    fullConfition.await();
                }
                storage.add(ProductFactory.create());
                emptyCondition.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

class Consumer implements Runnable {

    List<Product> storage;
    private Lock lock;
    private Condition fullConfition;
    private Condition emptyCondition;

    public Consumer(List<Product> storage, Lock lock, Condition fullCondition, Condition emptyCondition) {
        assert storage != null;
        this.storage = storage;
        this.lock = lock;
        this.fullConfition = fullCondition;
        this.emptyCondition = emptyCondition;
    }

    @Override
    public void run() {

    }
}


class ProductFactory {
    public static Product create() {
        return new Product();
    }
}

class Product {

}
