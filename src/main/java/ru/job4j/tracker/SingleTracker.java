package ru.job4j.tracker;

import java.util.List;

public class SingleTracker {
    private Tracker tracker = new Tracker();

    private static SingleTracker instance = null;

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public List<Item> findByName(String name) {
        return tracker.findByName(name);
    }

    public void delete(int id) {
       tracker.delete(id);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }
}
