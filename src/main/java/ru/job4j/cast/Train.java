package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("По рельсам чух чух");
    }

    @Override
    public int wheel() {
        return 48;
    }
}
