package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void go() {
        System.out.println("Поехали!");
    }

    @Override
    public void passangers(int passanger) {
        System.out.println("Село " + passanger + " пассажиров");
    }

    @Override
    public double fill(double litter) {
        return litter * 55.9;
    }
}
