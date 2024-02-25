package ru.job4j.example.lambda;

import java.util.Optional;

public class OptionalOrlElse {
    public static Integer orElse(Optional<Integer> optional) {
        return (Integer) optional.orElse(-1);
    }
}
