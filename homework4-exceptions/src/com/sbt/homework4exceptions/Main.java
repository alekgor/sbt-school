package com.sbt.homework4exceptions;

import com.sbt.homework4exceptions.TerminalImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TerminalImpl terminal = new TerminalImpl();
        Scanner s = new Scanner(System.in);
        terminal.check();
    }

}
