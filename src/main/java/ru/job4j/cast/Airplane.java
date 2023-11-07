package ru.job4j.cast;

public class Airplane implements Vehicle {

    @Override
    public void move() {
        System.out.println("По небу жжжж");
    }

    @Override
    public int wheel() {
        return 0;
    }
}
