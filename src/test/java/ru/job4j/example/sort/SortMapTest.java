package ru.job4j.example.sort;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;

public class SortMapTest {

    @Test
    public void test() {
        Map<Integer, String> input = Map.of(
                1, "1",
                2, "2",
                3, "3"
        );
        Map<Integer, String> expected = Map.of(
                3, "3",
                2, "2",
                1, "1"
        );
        Map<Integer, String> result = SortMap.sort(input);
        Assert.assertEquals(expected, result);
    }

}