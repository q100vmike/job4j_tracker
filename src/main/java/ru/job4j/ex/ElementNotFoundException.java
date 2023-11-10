package ru.job4j.ex;

import java.util.Objects;

public class ElementNotFoundException extends Exception {
    public class FindEl {
        public static int indexOf(String[] value, String key) throws ElementNotFoundException {
            int rsl = -1;
            for (int i = 0; i < value.length; i++) {
                if (Objects.equals(value[i], key)) {
                    rsl = i;
                   break;
                }
            }
            if (rsl == -1) {
                throw new ElementNotFoundException();
            }
            return rsl;
        }
    }

    public static void main(String[] args) {
        try {
            String[] array = new String[] {"one", "two", "three", "four"};
            FindEl.indexOf(array, "kod");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
