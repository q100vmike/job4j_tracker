package ru.job4j.example.set;

import java.util.HashSet;
import java.util.Set;

public class Pangram {
    public static boolean checkString(String s) {
        Set<Character> letter = new HashSet<>();
        s = s.toLowerCase().replaceAll(" ", "");

        for (int i = 0; i < s.length(); i++) {
            letter.add(s.charAt(i));
        }
        return (letter.size() == 26) ? true : false;
    }
}
