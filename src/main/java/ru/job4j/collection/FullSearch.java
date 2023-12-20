package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearch {
    public Set<String> extractNumber(List<Task> tasks) {
        Set<String> distacks = new HashSet<>();
        for (Task task : tasks) {
            distacks.add(task.getNumber());
        }
        return distacks;
    }
}
