package ru.job4j.example.map;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static List<Integer> extractDuplicates(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>(left);
        result.retainAll(right);
        return result;
    }
}