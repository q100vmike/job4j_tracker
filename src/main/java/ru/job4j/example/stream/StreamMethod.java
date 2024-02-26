package ru.job4j.example.stream;

import java.util.Collection;
import java.util.stream.Stream;

public class StreamMethod {
    public static Stream<Integer> createStream(Collection<Integer> data) {
         return data.stream();
    }
}