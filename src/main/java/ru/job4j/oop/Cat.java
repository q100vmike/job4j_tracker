package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;

    public void show() {
        System.out.println(this.name);
        System.out.println(this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        System.out.println("There are:");
        Cat gav = new Cat();
        gav.eat("kotleta");
        gav.giveNick("Гав");
        gav.show();
        System.out.println("There are:");
        Cat black = new Cat();
        black.eat("fish");
        black.giveNick("Черный");
        black.show();
    }
}
