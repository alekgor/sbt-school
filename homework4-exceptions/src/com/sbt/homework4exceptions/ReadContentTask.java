package com.sbt.homework4exceptions;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

//        Реализуйте метод readContent(String url), который отображает на экран
//        содержимое сайта, ссылка на который задаётся параметром url.
//
//        Напишите программу, считывающую из консоли строку (URL ресурса) и вызывающую
//        метод readContent. В том случае, если введённый URL неправильного формата
//        или нет доступа до указанного ресурса, пользователю предлагается повторить ввод.

public class ReadContentTask {

    public static void readContent(String url) throws IOException {
        URL newUrl = new URL(url);
        Scanner scanURL = new Scanner(newUrl.openConnection().getInputStream());
        while (scanURL.hasNextLine()) {
            System.out.println(scanURL.nextLine());
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите Url: ");
        try {
            String url = console.nextLine();
            readContent(url);
        } catch (IOException e) {
            System.out.println("Повторите ввод Url: ");
            String url = console.nextLine();
            readContent(url);
        }
    }
}
