package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;

        for (int j = 0; j < Math.min(left.length(), right.length()); j++) {
            if (left.charAt(j) != right.charAt(j)) {
                return Character.compare(left.charAt(j), right.charAt(j));
            }
        }
            return Integer.compare(left.length(), right.length());
    }
}