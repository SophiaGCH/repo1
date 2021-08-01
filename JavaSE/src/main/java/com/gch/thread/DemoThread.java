package com.gch.thread;

public class DemoThread {
    public static void main(String[] args) {
        Bun bun = new Bun();
        new CustomerThread(bun).start();
        new BunShopThread(bun).start();
    }
}
