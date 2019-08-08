package cn.bk998.thread;

import cn.bk998.thread.consumer.Consumer;
import cn.bk998.thread.produce.Produce;
import cn.bk998.thread.supermarket.Supermarket;

/**
 * @author XY
 * @DESCRIPTION
 * @create 2019/8/4
 */
public class MyThread {

    public static void main(String[] args) {
       Supermarket supermarket = new Supermarket();
        Produce produce = new Produce(supermarket);
        Consumer consumer = new Consumer(supermarket);
        new Thread(produce, "生产者A").start();
        new Thread(consumer, "消费者A").start();
        new Thread(produce, "生产者B").start();
        new Thread(consumer, "消费者B").start();
    }




}

