package ru.job4j.cast;

public class Go {
    public static void main(String[] args) {
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle airplane = new Airplane();
        Vehicle[] vehicles = new Vehicle[] {train, bus, airplane};

        for (Vehicle v : vehicles) {
            v.move();
            System.out.println("На " + v.wheel() + " колесах");
        }
    }
}
