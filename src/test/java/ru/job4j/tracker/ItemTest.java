package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemTest {

    @Test
    public void equalsComparatorAscByName() {
        List<Item> items = Arrays.asList(
                new Item("Second"),
                new Item("First"),
                new Item("Third")
        );
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("First"),
                new Item("Second"),
                new Item("Third")
        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void equalsComparatorDescByName() {
        List<Item> items = Arrays.asList(
                new Item("Second"),
                new Item("First"),
                new Item("Third")
        );
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("Third"),
                new Item("Second"),
                new Item("First")
        );
        assertThat(items).isEqualTo(expected);
    }
}