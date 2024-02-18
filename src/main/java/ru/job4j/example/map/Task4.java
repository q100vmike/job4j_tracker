package ru.job4j.example.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task4 {
    public static List<Integer> extractUnique(List<Integer> left, List<Integer> right) {
        List<Integer> rList = new ArrayList<Integer>(right);
        List<Integer> lList = new ArrayList<Integer>(left);
        List<Integer> result = new ArrayList<Integer>();
        lList.removeAll(right);
        rList.removeAll(left);
        result.addAll(rList);
        result.addAll(lList);
        return result;
    }
}