package ru.job4j.example.stream;

import java.util.List;
import java.util.stream.Collectors;

public class FilterObject {

    public static class User {

        private String name;

        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static List<User> filter(List<User> users) {
        return users.stream().
                filter(u -> u.getName().startsWith("B")).
                filter(u -> u.getAge() > 18).
                collect(Collectors.toList());
    }

}