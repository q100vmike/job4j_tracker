package ru.job4j.example.set;

import java.util.HashSet;
import java.util.Set;

public class Jackpot {
    @SuppressWarnings("checkstyle:SimplifyBooleanExpression")
    public static boolean checkYourWin(String[] combination) {
        Set<String> win = new HashSet<>();

        for (int i = 0; i <= combination.length - 1; i++) {
            win.add(combination[i]);
        }
        if (win.size() != 1) {
            return false;
        }
        return true;
    }
}
