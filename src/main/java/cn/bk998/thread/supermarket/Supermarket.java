package cn.bk998.thread.supermarket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

/**
 * @author XY
 * @DESCRIPTION
 * @create 2019/8/6
 */
public class Supermarket {

    private Integer[] cola = new Integer[1];

    public synchronized void putStorage() {
        while (cola.length >= 20) {
            System.out.println(Thread.currentThread().getName() + "->库存已满！");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "等待...");
        }
        this.notifyAll();
        cola = Arrays.copyOf(cola, cola.length + 1);
        for (int i = 0; i < cola.length; i++) {
            cola[i] = (int) (Math.random() * 100);
        }
        System.out.println(Thread.currentThread().getName() + "->生产【" + Arrays.toString(cola)+"】");
    }

    public synchronized void sell() {
        while (cola.length <= 0) {
            System.err.println(Thread.currentThread().getName() + "->库存已空！");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println(Thread.currentThread().getName() + "等待...");
        }
        this.notifyAll();
        System.out.println(Thread.currentThread().getName() + "->消耗【" + cola[cola.length - 1]+"】");
        cola = Arrays.copyOf(cola, cola.length - 1);
        System.out.println(Thread.currentThread().getName() + "->" + Arrays.toString(cola));
    }

}
