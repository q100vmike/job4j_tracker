package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.map(p -> p.subjects().stream()
                .mapToDouble(s -> (double) s.score())
                .average()
                .getAsDouble())
                .mapToDouble(a -> a)
                .average()
                .getAsDouble();
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.map(p -> new Tuple(p.name(), p.subjects()
                .stream()
                .mapToDouble(s -> (double) s.score())
                .average()
                .getAsDouble()))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(pup -> pup.subjects())
                .flatMap(s -> s.stream())
                .collect(Collectors.groupingBy(Subject::name, LinkedHashMap::new, Collectors.averagingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(t -> new Tuple(t.getKey(), t.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(s -> new Tuple(s.name(), s.subjects().stream()
                .mapToDouble(sc -> (double) sc.score())
                .sum()))
                .max(Comparator.comparingDouble(Tuple::score))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.map(pup -> pup.subjects())
                .flatMap(s -> s.stream())
                .collect(Collectors.groupingBy(Subject::name, Collectors.summingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(t -> new Tuple(t.getKey(), t.getValue()))
                .max(Comparator.comparingDouble(Tuple::score))
                .orElse(null);
    }
}