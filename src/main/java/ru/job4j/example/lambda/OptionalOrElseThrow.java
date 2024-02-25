package ru.job4j.example.lambda;

import java.util.List;
import java.util.Optional;

public class OptionalOrElseThrow {

    public static class User {

        private String login;

        public User(String login) {
            this.login = login;
        }

        public String getLogin() {
            return login;
        }
    }

    public static class UserNotFoundException extends RuntimeException { }

    public static User orElseThrow(List<User> list, String login) {
        Optional<User> user = search(list, login);
        return user.orElseThrow(UserNotFoundException ::new);
    }

    private static Optional<User> search(List<User> list, String login) {
        Optional<User> user = Optional.empty();
        for (User usr : list) {
            if (usr.getLogin() == login) {
                user = Optional.of(usr);
                break;
            }
        }
        return user;
    }
}
