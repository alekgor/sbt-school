package com.sbt.classloaders;

import java.io.File;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        // Создаем кодировщик, все файлы будут кодироваться в папку crypted
        Coder coder = new Coder("crypted");

        // Ищем файл который надо зашифровать
        File f = FileHelper.findFile("out/production/homework7-CL-EncryptedClassloader", "com.sbt.classloaders.PersonImp");

        // Шифруем файл
        File encodePerson = coder.encode(f);

        // Создадим наш загрузчик
        ClassLoader loader = new EncryptedClassLoader("10", new File("crypted"), ClassLoader.getSystemClassLoader());
        Person person;
        // Загрузим и получим экземпляр
        person = (Person) Class.forName("com.sbt.classloaders.PersonImp",false,loader).newInstance();

        // Проверим работу
        person.hello();

    }
}
