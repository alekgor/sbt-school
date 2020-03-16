package com.sbt.exception;

import java.io.File;
import java.util.Scanner;

class MyException extends Exception {
    public MyException() {
        super("Считана пустая строка");
    }

    public MyException(String message) {
        super(message);
    }
}


public class Main {

    public static String read() throws MyException {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        switch (line) {
            case (""):
                throw new MyException();
            case (" "):
                throw new MyException("Строка состоит из пробела");
            default:
                break;
        }
        return line;
    }

    public static void main(String[] args) {
        String line;
        try {
            System.out.println("Введите строку:");
            line = Main.read();
        } catch (MyException e) {
            System.out.println("e.getMessage(): " + e.getMessage());
            line = "0";
        }

        System.out.println(line + '\n');
//        try-with-resources

        System.out.println("Содержимое файла : ");
        try (Scanner inFile = new Scanner(new File("src/com/sbt/exception/text.txt"))) {
            while (inFile.hasNextLine()) {
                System.out.println(inFile.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Не удалось открыть файл : " + e.getMessage());
        }
    }
}
