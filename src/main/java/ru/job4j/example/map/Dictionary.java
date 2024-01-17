package ru.job4j.example.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    public static Map<String, List<String>> collectData(String[] strings) {
        Map<String, List<String>> rsl = new HashMap<>();
        for (String str : strings) {
            String chr = String.valueOf(str.charAt(0));
            List<String> val = rsl.get(chr);
            if (val == null || val.isEmpty()) {
                val = new ArrayList<>();
            }
            val.add(str);
            rsl.put(chr, val);
        }
        return rsl;
    }
}