package ru.job4j.example.set;

import java.util.HashSet;
import java.util.Set;

public class Jackpot {
    public static boolean checkYourWin(String[] combination) {
        Set<String> win = new HashSet<>();

        for (int i = 0; i <= combination.length - 1; i++) {
            win.add(combination[i]);
        }
        return win.size() == 1 ? true : false;
    }
}
