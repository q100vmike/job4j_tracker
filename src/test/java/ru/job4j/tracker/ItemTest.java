package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {
    @Test
    public void whenItemsSortedByNameAsc() {

        List<Item> items = (
                Arrays.asList(
                        new Item(4,
                                "Ariel"
                        ),
                        new Item(7,
                                "Petrov"
                        ),
                        new Item(1,
                                "Cidorov"
                        ),
                        new Item(2,
                                "Sidorov"
                        )
                )
        );
        List<Item> expected = (
                Arrays.asList(
                        new Item(4,
                                "Ariel"
                        ),
                        new Item(1,
                                "Cidorov"
                        ),
                        new Item(7,
                                "Petrov"
                        ),
                        new Item(2,
                                "Sidorov"
                        )
                )
        );
        Collections.sort(items, new ItemAscByName());
        assertThat(items).containsExactlyElementsOf(expected);
    }

    @Test
    public void whenItemsSortedByNameDesc() {
        List<Item> items = (
                Arrays.asList(
                        new Item(4,
                                "Ariel"
                        ),
                        new Item(7,
                                "Petrov"
                        ),
                        new Item(1,
                                "Cidorov"
                        ),
                        new Item(10,
                                "Zotov"
                        )
                )
        );
        List<Item> expected = (
                Arrays.asList(
                        new Item(10,
                                "Zotov"
                        ),
                        new Item(7,
                                "Petrov"
                        ),
                        new Item(1,
                                "Cidorov"
                        ),
                        new Item(10,
                                "Ariel"
                        )
                )
        );

        Collections.sort(items, new ItemDescByName());
        assertThat(items).containsExactlyElementsOf(expected);
    }

}