package ru.job4j.example.map;

import java.util.HashMap;
public class Article {
    public static boolean generateBy(String origin, String line) {
        HashMap<String, Integer> horig = new HashMap<>();
        HashMap<String, Integer> hline = new HashMap<>();
        String[] aorigin = origin.replaceAll("[^A-Za-zА-Яа-я0-9 ]", "").split(" ");
        String[] aline = line.replaceAll("[^A-Za-zА-Яа-я0-9 ]", "").split(" ");

        for (int i = 0; i < aorigin.length; i++) {
            horig.merge(aorigin[i], 1, (a, b) -> b + 1);
        }
        for (int i = 0; i < aline.length; i++) {
            hline.merge(aline[i], 1, (a, b) -> b + 1);
        }
        for (String key : hline.keySet()) {
            if (horig.get(key) != hline.get(key)) {
                return false;
            }
        }
        return true;
    }
}