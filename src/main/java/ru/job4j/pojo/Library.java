package ru.job4j.pojo;

import java.util.Objects;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = new Book();
        Book[] books = new Book[4];
        book1.setName("Пушкин");
        book1.setLetter(100);
        book2.setName("Гоголь");
        book2.setLetter(398);
        book3.setName("Clean code");
        book3.setLetter(1000);
        book4.setName("Java");
        book4.setLetter(390);
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " страниц " + books[i].getLetter());
        }
        books[0] = book4;
        books[3] = book1;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " страниц " + books[i].getLetter());
        }
        for (int i = 0; i < books.length; i++) {
            if (Objects.equals(books[i].getName(), "Clean code")) {
                System.out.println(books[i].getName() + " страниц " + books[i].getLetter());
            }
        }
    }
}
