package ru.job4j.example.set;

import java.util.HashSet;
import java.util.Set;

public class Isogram {
    public static boolean checkString(String s) {
        Set<Character> letter = new HashSet<>();
        boolean rsl = true;

        for (int i = 0; i < s.length(); i++) {
            rsl = letter.add(s.charAt(i));
            if (!rsl) {
                break;
            }
        }
        return rsl;
    }
}
