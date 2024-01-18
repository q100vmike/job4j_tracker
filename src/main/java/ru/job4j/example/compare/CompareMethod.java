package ru.job4j.example.compare;
public class CompareMethod {

    public static int ascendingCompare(int first, int second) {

        if (first < second) {
            return -1;
        } else if (first == second) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int descendingCompare(int first, int second) {
        if (first < second) {
            return 1;
        } else if (first == second) {
            return 0;
        } else {
            return -1;
        }
    }

}
