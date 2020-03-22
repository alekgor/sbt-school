package com.sbt.homework4exceptions.terminalServer;

public class TerminalServer {
    private Integer balance;
    private String currency = "$";

    public String getCurrency() {
        return currency;
    }

    public TerminalServer() {
        this.balance = 10_000;
    }

    public Integer getBalance() {
        return balance;
    }

    public void get(Integer sum) throws ServerException {
        if (sum < 0) {
            throw new NonPositiveSumException("Сумма снятия должна быть положительна.");
        }
        if (balance - sum < 0) {
            throw new InsufficientFundsException("Недостаточно средств на счете.");
        }
        if (sum % 100 != 0) {
            throw new NonMultipleOf100Exception("Сумма снятия должна быть кратна 100.");
        }
        this.balance -= sum;
    }

    public void put(Integer sum) throws ServerException {
        if (sum < 0) {
            throw new NonPositiveSumException("Сумма снятия должна быть положительна.");
        }
        if (sum % 100 != 0) {
            throw new NonMultipleOf100Exception("Сумма снятия должна быть кратна 100.");
        }
        this.balance += sum;
    }
}
