package cn.bk998.thread.produce;

import cn.bk998.thread.supermarket.Supermarket;

/**
 * @author XY
 * @DESCRIPTION
 * @create 2019/8/6
 */
public class Produce implements Runnable{
    private Supermarket supermarket;

    public Produce(Supermarket supermarket) {
        this.supermarket = supermarket;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            supermarket.putStorage();
        }
    }

}
