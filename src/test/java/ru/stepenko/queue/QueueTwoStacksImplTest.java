package ru.stepenko.queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTwoStacksImplTest {

    private Queue<Integer> q = new QueueTwoStacksImpl();
    private final static int ONE = 1;
    private final static int TWO = 2;

    @BeforeEach
    void setup() {
        q.add(ONE);
        q.add(TWO);
    }

    @AfterEach
    void tearDown () {
        q.clear();
    }

    @Test
    void size() {
        q.poll();
        q.add(3);

        assertAll(
                () -> assertEquals(2, q.size()),
                () -> assertFalse(q.isEmpty())
        );
    }

    @Test
    void isEmpty() {
        q.poll();
        q.poll();

        assertAll(
                () -> assertTrue(q.isEmpty()),
                () -> assertEquals(0, q.size())
        );
    }

    @Test
    void add() {
        assertAll(
                () -> assertEquals(ONE, q.peek()),
                () -> assertEquals(2, q.size())
        );
    }

    @Test
    void clear() {
        q.clear();

        assertAll(
                () -> assertTrue(q.isEmpty()),
                () -> assertEquals(0, q.size())
        );
    }

    @Test
    void poll() {
        q.poll();

        assertAll(
                () -> assertFalse(q.isEmpty()),
                () -> assertEquals(1, q.size()),
                () -> assertEquals(TWO, q.peek())
        );
    }

    @Test
    void peek() {
        int result = q.peek();
        assertAll(
                () -> assertEquals(ONE, result),
                () -> assertEquals(ONE, q.peek()),
                () -> assertEquals(2, q.size())
        );
    }
}