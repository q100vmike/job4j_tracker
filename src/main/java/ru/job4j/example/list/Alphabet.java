package ru.job4j.example.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Alphabet {
    public static String reformat(String s) {
        List<Character> words = new ArrayList<>();
        StringBuilder out = new StringBuilder();
        char[] strToArray = s.toCharArray();
        for (int i = 0; i < strToArray.length; i++) {
            words.add(strToArray[i]);
        }
        words.sort(Comparator.naturalOrder());
        for (Character i : words) {
            out.append(i);
        }

        return out.toString();
    }
}