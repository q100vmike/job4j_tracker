package ru.job4j.tracker.checkstyle;

public class Broken {
    private int sizeOfEmpty = 1;
    private String surname;
    private static final String NEWVALUE = "тест";
    private String name;

    public Broken() {
    }

    public void echo() { }

    public void media(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }

    public void method(int b, int c, int d, int e, int f, int g, int h) {

    }
}
