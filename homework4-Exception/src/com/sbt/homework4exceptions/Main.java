package com.sbt.homework4exceptions;


public class Main {


    public static void main(String[] args) {
        TerminalImpl terminal = new TerminalImpl();
        terminal.checkBalance();
        terminal.get();
        terminal.put();
        terminal.checkBalance();
    }

}
