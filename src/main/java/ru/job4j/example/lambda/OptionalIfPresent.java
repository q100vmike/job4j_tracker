package ru.job4j.example.lambda;

import java.lang.reflect.Array;
import java.util.Optional;

public class OptionalIfPresent {

    public static void ifPresent(int[] data) {
        Optional<Integer> max = max(data);
        if (max.isPresent()) {
            System.out.println("Max: " + max.get());
        }
    }

    private static Optional<Integer> max(int[] data) {
        int max = 0;
        if (data.length > 1) {
            max = data[0];
            for (int i = 0; i < data.length - 1; i++) {
                max = max <= data[i + 1] ? data[i + 1] : max;
            }
        } else if (data.length == 0) {
            return Optional.empty();
        } else {
            return Optional.of(data[0]);
        }
        return Optional.of(max);
    }
}