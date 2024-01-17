package ru.job4j.example.map;

import java.util.HashMap;
import java.util.Map;

public class NonUniqueString {
    public static Map<String, Boolean> checkData(String[] strings) {
        Map<String, Boolean> ustr = new HashMap<>();
         for (String str : strings) {
             ustr.merge(str, false, (oldV, newV) -> true);
         }
        return ustr;
    }
}
