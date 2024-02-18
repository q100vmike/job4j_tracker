package ru.job4j.example.map;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> lMap = new HashMap<>();
        Map<Character, Integer> rMap = new HashMap<>();

        if (left.equals(right)) {
            return true;
        }
        if (left.length() != right.length()) {
            return false;
        }
        for (int i = 0; i < left.length(); i++) {
            lMap.merge(left.charAt(i), 1, Integer::sum);
        }
        for (int i = 0; i < right.length(); i++) {
            rMap.merge(right.charAt(i), 1, Integer::sum);
        }

        for (Character key : lMap.keySet()) {
            if (rMap.get(key) != lMap.get(key)) {
                return false;
            }
        }
        return true;
    }
}