package com.sbt.multithreading.part2;

public class Main {

    public static void main(String[] args) throws InterruptedException {

//        Account mainAcc = new Account();
//        AccountExample accountExample1 = new AccountExample(mainAcc);
//        AccountExample accountExample2 = new AccountExample(mainAcc);
//
//
//        Thread t1 = new Thread(accountExample1);
//        Thread t2 = new Thread(accountExample2);
//        t1.start();
//        t2.start();

        Test t = new Test();
        Thread thread = new Thread(t);
        thread.start();
        Thread.sleep(10000);
        thread.interrupt();

        thread.join();
        System.out.println(Thread.currentThread().getName() + " finished...");
    }
}
