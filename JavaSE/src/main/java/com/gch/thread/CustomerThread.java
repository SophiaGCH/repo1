package com.gch.thread;

/**
 * @author: Sophia
 * @description:
 * @date: Create in 2021/7/31 9:20
 */
public class CustomerThread extends Thread{
    Bun bun;

    public CustomerThread(Bun bun) {
        this.bun = bun;
    }

    @Override
    public void run() {
        while (true){
            synchronized (bun){
                if (bun.isFlag()){
                    System.out.println("顾客正在购买" + bun.getSkin() + bun.getFilling() + "的包子");
                    bun.setFlag(false);
                    System.out.println("包子卖完了，老板可以做包子了！");
                    System.out.println("--------------------------");
                    bun.notify();
                }
            }
        }
    }
}
