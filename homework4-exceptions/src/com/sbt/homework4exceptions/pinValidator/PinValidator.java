package com.sbt.homework4exceptions.pinValidator;

import com.sbt.homework4exceptions.MyTimer;

public class PinValidator {
    private String pin = "1234";
    private Integer countRequest = 0;
    private MyTimer timer;

    public PinValidator() {
        timer = new MyTimer();
    }

    private boolean checkValidation(String validationPin) { // Простая проверка на то, чтобы длина была 4
        boolean f = true;
        if (validationPin.length() != 4) {
            f = false;
        }
        return f;
    }

    public boolean access(String validationPin) throws NonCorrectPinException, AccountIsLockedException {
        Boolean access = false;
        if (!checkValidation(validationPin)) { // Проверяем что PIN 4х знач
            throw new NonCorrectPinException();
        }
        access = validationPin.equals(pin); //Сравниваем PINы

        if (!timer.lock()) { // Если не залочено
            if (access) {   // Если пины совпали то обнуляем счетчик запросов и разрешаем доступ
                countRequest = 0;
                return true;
            } else {
                countRequest++; // Если пины не совпали увеличиваем счетчик запросов
                countRequest = countRequest % 4;
                if (countRequest == 3) { //Если набралось три ошибки то лочим доступ и запускаем таймер
                    timer.start();
                    System.out.println("Вход заблокирован на "+ timer.secondsLeft()+"сек...");
                }
            }
        } else { //Если доступ залочен таймером и есть попытка получения доступа, то выкидываем исключение
            throw new AccountIsLockedException("Вход заблокирован на "+ timer.secondsLeft()+"сек...");
        }
        return false; // Не даем доступ
    }
}
