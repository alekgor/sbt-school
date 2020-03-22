package com.sbt.homework4exceptions;

import com.sbt.homework4exceptions.pinValidator.AccountIsLockedException;
import com.sbt.homework4exceptions.pinValidator.NonCorrectPinException;
import com.sbt.homework4exceptions.pinValidator.PinValidator;
import com.sbt.homework4exceptions.terminalServer.ServerException;
import com.sbt.homework4exceptions.terminalServer.TerminalServer;

import java.util.Scanner;

public class TerminalImpl implements Terminal {

    private final TerminalServer server;
    private final PinValidator pinValidator;

    public TerminalImpl() {
        this.server = new TerminalServer();
        this.pinValidator = new PinValidator();
    }

    public TerminalImpl(TerminalServer server, PinValidator pinValidator) {
        this.server = server;
        this.pinValidator = pinValidator;
    }


    @Override
    public void check() { //    Проверка счета(Вывод баланса)
        boolean accessToAccount = false;
        Integer balanceAccount = null;

        while (!accessToAccount) {
            System.out.println("Введите PIN для проверки баланса: ");
            Scanner console = new Scanner(System.in);
            String pin = console.nextLine();                   // Считываем пин
            try {
                accessToAccount = pinValidator.access(pin);   // Проверяем доступ по pin через валидатор
            } catch (AccountIsLockedException | NonCorrectPinException e) {
                System.out.println(e.getMessage());
                continue;
            }
            if (accessToAccount) {
                balanceAccount = server.getBalance();             // Запрашиваем у сервера счет аккаунта
            } else {
                System.out.println("Неверный PIN");
            }
        }
        System.out.println("Ваш баланс: " + balanceAccount + server.getCurrency());
    }

    @Override
    public void get() {
        boolean accessToAccount = false;
        while (!accessToAccount) {
            System.out.println("Введите PIN для снятия денег: ");
            Scanner console = new Scanner(System.in);
            String pin = console.nextLine();                   // Считываем пин
            try {
                accessToAccount = pinValidator.access(pin);   // Проверяем доступ по pin через валидатор
            } catch (AccountIsLockedException | NonCorrectPinException e) {
                System.out.println(e.getMessage());
                continue;
            }
            if (accessToAccount) {  // Если есть доступ к аккаунту
                boolean successOp = false;
                while (!successOp) {
                    try {
                        System.out.println("Введите сумму снятия денег: ");
                        Integer sum = console.nextInt();
                        server.get(sum);             // Запрашиваем у сервера снятие денег
                        successOp = true;
                    } catch (ServerException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else {
                System.out.println("Неверный PIN");
            }
        }
        System.out.println("Ваш баланс: " + server.getBalance() + server.getCurrency());
    }

    @Override
    public void put() {

    }
}
