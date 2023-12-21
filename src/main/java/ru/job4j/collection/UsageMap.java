package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("q100v@ya.ru", "Ivanov II");
        map.put("q1000v@ya.ru", "Petrov II");
        map.put("q10000v@ya.ru", "Sidorov II");
        map.put("q100v@ya.ru", "Ivanov II");

        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
