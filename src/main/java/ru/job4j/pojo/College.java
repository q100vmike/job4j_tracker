package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setAdmission(new Date());
        student.setFio("Иванов Иван Иванович");
        student.setGroupnum(12);
        System.out.println("Студент " + student.getFio() + "группа " + student.getGroupnum() + "поступил " + student.getAdmission());
    }
}
