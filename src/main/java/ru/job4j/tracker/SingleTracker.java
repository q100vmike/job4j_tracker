package ru.job4j.tracker;

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

    public Item[] findByName(String name) {
        return tracker.findByName(name);
    }

    public void delete(int id) {
       tracker.delete(id);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }
}
