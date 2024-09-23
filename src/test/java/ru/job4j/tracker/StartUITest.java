package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new MockInput(
                new String[] {"33", "0"}
        );
        Store tracker = new SqlTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Exit(out));

        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Завершить программу" + ln
                        + "Неверный ввод, вы можете выбрать: 0 .. 0" + ln
                        + "Меню:" + ln
                        + "0. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenExit() {
        Output out = new StubOutput();
        Input in = new MockInput(
                new String[] {"0"}
        );
        Store tracker = new SqlTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Exit(out));

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new MockInput(
                new String[]{"0", "Item name", "1"}
        );
        Store tracker = new SqlTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Create(out));
        actions.add(new Exit(out));

        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findByName("Item name").get(0).getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new MockInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Replace(out));
        actions.add(new Exit(out));

        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    void whenDeleteItem() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new MockInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Delete(out));
        actions.add(new Exit(out));

        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findByName("Deleted item").size() == 0);
    }

    @Test
    void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new MockInput(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Replace(out));
        actions.add(new Exit(out));

        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Изменить заявку" + ln
                        + "1. Завершить программу" + ln
                        + "=== Редактирование заявки ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Меню:" + ln
                        + "0. Изменить заявку" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindAllActionTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker();
        tracker.clear();
        Item item1 = tracker.add(new Item("test1"));
        Item item2 = tracker.add(new Item("test2"));
        Input in = new MockInput(
                new String[] {"0", "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindAll(out));
        actions.add(new Exit(out));

        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + item1 + ln
                        + item2 + ln
                        + "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByNameActionTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker();
        tracker.clear();
        tracker.add(new Item("test1"));
        Item item2 = tracker.add(new Item("test2"));
        tracker.add(new Item("test3"));
        Input in = new MockInput(
                new String[] {"0", "test2", "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByName(out));
        actions.add(new Exit(out));

        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявок по имени ===" + ln
                        + item2 + ln
                        + "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByIdActionTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker();
        tracker.add(new Item("test1"));
        Item item = tracker.add(new Item("test2"));
        tracker.add(new Item("test3"));
        Input in = new MockInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindById(out));
        actions.add(new Exit(out));

        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявки по id ===" + ln
                        + item + ln
                        + "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }
}