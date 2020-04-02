package com.sbt;

import java.io.InvalidObjectException;
import java.io.ObjectInputValidation;
import java.io.Serializable;
import java.util.Arrays;

public class StudentsList implements Serializable, ObjectInputValidation {
    private Student[] students = new Student[]{new Student("Alex"), new Student("Max")};
    private int count = students.length;

    public Student[] getStudents() {
        return students;
    }

    public void add(Student student) {
        Student[] newStudents = new Student[++count];
        System.arraycopy(students, 0, newStudents, 0, count-1);
        newStudents[count-1] = student;
        this.students = newStudents;
    }



    @Override
    public String toString() {
        return "StudentsInfo{" +
                "students=" + Arrays.toString(students) +
                ", count=" + count +
                '}';
    }

    @Override
    public void validateObject() throws InvalidObjectException {
        for (Student s: students) {
            s.validateObject();
        }
    }
}
