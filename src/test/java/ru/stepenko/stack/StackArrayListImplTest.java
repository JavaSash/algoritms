package ru.stepenko.stack;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackArrayListImplTest {

    private static Stack<Integer> stack;
    private final static int INPUT = 10;
    @BeforeEach
    void setUp() {
        stack = new StackArrayListImpl<>();
    }

    @Test
    void push_Success() {
        int sizeBeforePush = stack.size();

        stack.push(INPUT);

        assertAll(
                () -> assertEquals(sizeBeforePush + 1, stack.size()),
                () -> assertFalse(stack.isEmpty()),
                () -> assertEquals(INPUT, stack.peek())
        );
    }

    @SneakyThrows
    @Test
    void pop_Success() {
        stack.push(100);
        int sizeBeforePop = stack.size();

        stack.pop();

        assertAll(
                () -> assertEquals(sizeBeforePop - 1, stack.size()),
                () -> assertTrue(stack.isEmpty())
        );

    }

    @Test
    void popException_Fail() {
        int sizeBeforePop = stack.size();

        assertAll(
                () -> assertThrows(StackIsEmptyException.class, () -> stack.pop()),
                () -> assertEquals(sizeBeforePop, stack.size()),
                () -> assertTrue(stack.isEmpty())
        );

    }

    @Test
    void top() {
        stack.push(100);
        stack.push(INPUT);

        assertAll(
                () -> assertFalse(stack.isEmpty()),
                () -> assertEquals(INPUT, stack.peek())
        );
    }
}