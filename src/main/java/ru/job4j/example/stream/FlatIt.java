package ru.job4j.example.stream;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlatIt {

    public static List<Integer> flatten(Iterator<Iterator<Integer>> it) {
        List<Integer> allIntegers = new ArrayList<>();
        StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0), false)
                .flatMap(iter -> StreamSupport.stream(Spliterators.spliteratorUnknownSize(iter, 0), false))
                .iterator().forEachRemaining(allIntegers::add);
        return allIntegers;
    }

    private static <T> Stream<T> iteratorToStream(Iterator<T> it) {
        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(it, Spliterator.ORDERED),
                false);
    }
}