package ru.job4j.example.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MinMethod {
    public static String min(List<String> list) {
       return list.stream().min((n1, n2) -> Integer.compare(n1.length(), n2.length())).get();
    }
}
