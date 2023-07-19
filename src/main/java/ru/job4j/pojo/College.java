package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Калинин Питрий");
        student.setGroup(123);
        student.setDateOfEntry(LocalDate.of(2022, 9, 21));
        System.out.println("Студент: " + student.getName() + " из группы " + student.getGroup() + " поступил " + student.getDateOfEntry());

    }
}
