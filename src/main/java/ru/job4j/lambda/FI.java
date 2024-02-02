package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    @SuppressWarnings("checkstyle:NoWhitespaceBefore")
    public static void main(String[] args) {
        Attachment[] attachments = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return Integer.compare(left.getSize(), right.getSize());
            }
        };
        Comparator<String> comparatorText = (left, right) -> left.compareTo(right);
        Comparator<String> comparatorDescSize = (left, right) -> Integer.compare(right.length(), left.length());

        Arrays.sort(attachments, comparator);
    }

}
