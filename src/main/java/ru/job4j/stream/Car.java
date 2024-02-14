package ru.job4j.stream;

import java.time.LocalDate;

public class Car {
    private String brand;

    private String model;

    private LocalDate created;

    private double volume;

    private String color;

    static class Builder {
        private String brand;
        private String model;
        private LocalDate created;
        private double volume;
        private String color;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildCreated(LocalDate created) {
            this.created = created;
            return this;

        }

        Builder buildVolume(double volume) {
            this.volume = volume;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.volume = volume;
            car.color = color;
            car.created = created;
            car.model = model;
            return car;
        }
    }

    @Override
    public String toString() {
        return "Builder{"
                + "brand='" + brand + '\''
                + ", model='" + model + '\''
                + ", color='" + color + '\''
                + '}';
    }

    public static void main(String[] args) {
        Car car = new Builder()
                .buildBrand("Toyota")
                .buildModel("Camry")
                .buildCreated(LocalDate.of(2021, 6, 1))
                .buildVolume(2.5)
                .buildColor("Red")
                .build();
        System.out.println(car);

        Car carX = new Builder()
                .buildBrand("Tesla")
                .buildModel("Model X")
                .build();
        System.out.println(carX);
    }
}
