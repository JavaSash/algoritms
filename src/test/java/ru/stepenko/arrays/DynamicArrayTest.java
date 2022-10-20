package ru.stepenko.arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DynamicArrayTest {

    private DynamicArray<Integer> data = new DynamicArray<>();

    @BeforeEach
    void setup() {
        data.add(1);
        data.add(2);
        data.add(3);
    }

    @AfterEach
    void tearDown() {
        data.clear();
    }

    @Test
    void add() {
        assertAll(
                () -> assertEquals(3, data.size())
        );
    }

    @Test
    void remove() {
        data.remove(0);

        assertAll(
                () -> assertEquals(2, data.size())
        );
    }

    @Test
    void clear() {
        data.clear();
        assertEquals(0, data.size());
    }

    @Test
    void get() {
        assertEquals(1, data.get(0));
        assertEquals(2, data.get(1));
        assertEquals(3, data.get(2));
    }
}