package com.sbt.multithreading.part2;

public class AccountExample implements Runnable {
    private Account acct;

    public AccountExample(Account acct) {
        this.acct = acct;
    }

    private synchronized void makeWithdraw(int amt) {
        if (acct.getBalance() >= amt) {
            acct.withdraw(amt);
        }
    }

    @Override
    public void run() {
        for (int x = 0; x < 5; x++) {
            makeWithdraw(10);
            if (acct.getBalance() < 0) {
                System.out.println("account is overdrawn!");
            }
        }
    }

}
