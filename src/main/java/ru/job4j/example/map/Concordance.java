package ru.job4j.example.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Concordance {
    public static Map<Character, List<Integer>> collectCharacters(String s) {
        Map<Character, List<Integer>> rsl = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character key = s.charAt(i);
            if (key != ' ') {
                if (rsl.containsKey(key)) {
                    List<Integer> val = rsl.get(key);
                    val.add(i);
                    rsl.put(key, val);
                } else {
                    List<Integer> val = new ArrayList<>();
                    val.add(i);
                    rsl.put(key,  val);
                }
            }
        }

        return rsl;
    }
}