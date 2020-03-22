package com.sbt.homework4exceptions.terminalServer;

public class TerminalServer {
    private Integer bankAccount;
    private String currency = "$";

    public String getCurrency() {
        return currency;
    }

    public TerminalServer() {
        this.bankAccount = 10_000;
    }

    public Integer check(){
        return bankAccount;
    }

}
