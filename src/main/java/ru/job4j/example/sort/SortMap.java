package ru.job4j.example.sort;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class SortMap {
    public static Map<Integer, String> sort(Map<Integer, String> map) {
        Map<Integer, String> smap = new TreeMap<>(Comparator.reverseOrder());
        smap.putAll(map);
        return smap;
    }
}