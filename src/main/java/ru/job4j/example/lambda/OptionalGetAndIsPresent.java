package ru.job4j.example.lambda;

import javax.swing.text.html.Option;
import java.util.Optional;

public class OptionalGetAndIsPresent {

    public static int get(int[] data, int el) {
        Optional<Integer> rsl = indexOf(data, el);
        if (rsl.isEmpty()) {
            return -1;
        } else {
            return rsl.get();
        }
    }

    private static Optional<Integer> indexOf(int[] data, int el) {
        int rsl = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                rsl = i;
                break;
            }
        }
        return rsl < 0 ? Optional.empty() : Optional.of(rsl);
    }
}