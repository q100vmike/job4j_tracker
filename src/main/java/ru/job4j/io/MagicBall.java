package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int answer = new Random().nextInt(3);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String out = scanner.nextLine();
            switch (answer) {
                case 0 -> System.out.print("Да");
                case 1 -> System.out.print("Нет");
                default -> System.out.print("Может быть");
            }
    }
}
