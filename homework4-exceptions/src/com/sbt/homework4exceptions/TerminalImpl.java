package com.sbt.homework4exceptions;

import com.sbt.homework4exceptions.pinValidator.AccountIsLockedException;
import com.sbt.homework4exceptions.pinValidator.NonCorrectPinException;
import com.sbt.homework4exceptions.pinValidator.PinValidator;
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
        Boolean accessToAccount = false;
        Integer bankAccount = null;

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
                bankAccount = server.check();             // Запрашиваем у сервера счет аккаунта
            } else {
                System.out.println("Неверный PIN");
            }
        }
        System.out.println("Ваш баланс: " + bankAccount + server.getCurrency());
    }

    @Override
    public void get(Integer value) {

    }

    @Override
    public void put(Integer value) {

    }
}
