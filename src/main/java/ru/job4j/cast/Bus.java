package ru.job4j.cast;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println("По дороге дыр дыр");
    }

    @Override
    public int wheel() {
        return 4;
    }
}
