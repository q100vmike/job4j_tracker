package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = right.substring(0, 2).compareTo(left.substring(0, 2));
        if (result == 0) {
            result = left.compareTo(right);
        }
        return result;
    }
}