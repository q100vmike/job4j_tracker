package ru.job4j.example.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task5 {
    public static List<Integer> multiAssign(List<Task> tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Task task : tasks) {
            map.merge(task.assignId(), 1, (oldVal, newVal) -> oldVal + 1);
        }
        map.entrySet().removeIf(entry -> entry.getValue() < 2);

        List<Integer> result = new ArrayList<>(map.keySet());
        return result;
    }

    public record Task(Integer taskId, Integer assignId) {
    }
}