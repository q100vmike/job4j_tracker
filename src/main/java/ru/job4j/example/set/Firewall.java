package ru.job4j.example.set;

import java.util.Set;

public class Firewall {
    public static String checkName(String s, Set<String> words) {
        String[] word = s.toLowerCase().split(" ");
        String rsl = "Вы сделали правильный выбор!";

        for (int i = 0; i <= word.length - 1; i++) {
            if (words.contains(word[i])) {
                rsl = "Выберите другую статью...";
                break;
            }
        }
        return rsl;
    }
}