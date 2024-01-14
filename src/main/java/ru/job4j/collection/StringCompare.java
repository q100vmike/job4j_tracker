package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;

        for (int j = 0; j < left.length(); j++) {
            if (Character.isDigit(left.charAt(j)) && Character.isDigit(right.charAt(j))) {
                result = Integer.compare(left.charAt(j), right.charAt(j));
            } else {
                result = Character.compare(left.charAt(j), right.charAt(j));
            }
            if (result != 0) {
                break;
            }
        }
        if (result == 0 && left.length() != right.length()) {
            result = Integer.compare(left.length(), right.length());
        }
        return result;
    }
}