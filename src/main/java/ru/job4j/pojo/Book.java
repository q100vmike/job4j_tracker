package ru.job4j.pojo;

public class Book {
    private String name;
    private int letter;

    public Book(String name, int letter) {
        this.name = name;
        this.letter = letter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLetter() {
        return letter;
    }

    public void setLetter(int letter) {
        this.letter = letter;
    }
}
