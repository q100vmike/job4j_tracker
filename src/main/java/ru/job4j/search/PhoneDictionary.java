package ru.job4j.search;
import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список пользователей, которые прошли проверку.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> phone = person -> person.getPhone().contains(key);
        Predicate<Person> addr = person -> person.getAddress().contains(key);
        Predicate<Person> name = person -> person.getName().contains(key);
        Predicate<Person> sname = person -> person.getSurname().contains(key);
        Predicate<Person> combine = phone.or(addr).or(addr).or(name).or(sname);

        ArrayList<Person> result = new ArrayList<Person>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
