package com.sbt;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File dir = new File("./save/");         // Папка сохранений

        StudentsList studentsList = new StudentsList();
        studentsList.add(new Student("Mary"));      // Добавим в список нового студента
        System.out.println(studentsList);
        Serializer.serialize(dir, studentsList);           // Сохраним

        StudentsList newStudentList = Serializer.deserialize(new File(dir.getPath() + "/" + StudentsList.class.getName()), StudentsList.class);
        System.out.println(newStudentList);
        newStudentList.validateObject();
    }
}
