package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class MatrixIteratorTest  {

    @Test
    void when4El() {
        int[][] input = {
                {1}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThat(iterator.next()).isEqualTo(1);
    }

    @Test
    void whenFirstEmptyThenNext() {
        int[][] input = {
                {}, {1}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThat(iterator.next()).isEqualTo(1);
    }

    @Test
    void whenFirstEmptyThenHasNext() {
        int[][] input = {
                {}, {1}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThat(iterator.hasNext()).isTrue();
    }

    @Test
    void whenRowHasDiffSize() {
        int[][] input = {
                {1}, {2, 3}, {}, {}, {4}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.next()).isEqualTo(3);
        assertThat(iterator.next()).isEqualTo(4);
        assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    void whenFewEmpty() {
        int[][] input = {
                {1}, {}, {}, {}, {2}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    void whenEmpty() {
        int[][] input = {
                {}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    void whenEmptyThenNext() {
        int[][] input = {
                {}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThatThrownBy(iterator::next)
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void whenMultiHasNext() {
        int[][] input = {
                {}, {1}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.hasNext()).isTrue();
    }

    @Test
    void whenNoElements() {
        int[][] input = {
                {}, {}, {}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThat(iterator.hasNext()).isFalse();
    }
/*
    @Test
    void testferst() {
        int[][] input = {
                {11, 22, 33}, {}, {44}
        };
        List<Integer> list = new ArrayList<>();
        MatrixIterator iterator = new MatrixIterator(input);
        iterator.hasNext();
        int one = iterator.next();
        iterator.hasNext();
        iterator.hasNext();
       // int one = iterator.next();
        list.add(one);
        int two = iterator.next();
        list.add(two);
        iterator.hasNext();
        iterator.hasNext();
        int three = iterator.next();
        list.add(three);
        int four = iterator.next();
        list.add(four);
        int five = iterator.next();
        assertThat(iterator.hasNext()).isFalse();
    }*/
}