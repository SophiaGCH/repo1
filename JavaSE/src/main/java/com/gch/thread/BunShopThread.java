package com.gch.thread;

/**
 * @author: Sophia
 * @description:
 * @date: Create in 2021/7/31 9:12
 */
public class BunShopThread extends Thread{

    Bun bun;

    public BunShopThread(Bun bun) {
        this.bun = bun;
    }

    @Override
    public void run() {
        int count = 0;
        while (true){
            synchronized (bun){
                if (bun.isFlag()){
                    // 证明包子铺还有包子,让包子铺等待
                    System.out.println("店铺中有" + bun.getSkin() + bun.getFilling() + "的包子");
                    try {
                        bun.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    bun.setFlag(false);
                }else {
                    // 没有包子了，让老板做包子
                    if (count % 2 == 0){
                        bun.setSkin("薄皮");
                        bun.setFilling("韭菜鸡蛋");
                    }else {
                        bun.setSkin("米皮");
                        bun.setFilling("猪肉大葱");
                    }
                    bun.setFlag(true);
                    System.out.println("包子铺老板正在做" + bun.getSkin() + bun.getFilling() + "的包子");
                    try {
                        Thread.sleep(2000);// 做包子需要3秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    bun.notify();
                }

            }
        }
    }
}
