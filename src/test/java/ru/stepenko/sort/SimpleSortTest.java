package ru.stepenko.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static ru.stepenko.sort.SimpleSort.*;

class SimpleSortTest extends SortTest {

    private int[] evenNumberElements;
    private int[] oddNumberElements;
    private int[] emptyArray;
    private int[] oneElement;

    @BeforeEach
    void setup() {
        evenNumberElements = new int[]{3, 2, 1, 2, 4, 8};
        oddNumberElements = new int[]{3, 2, 1, 5, -100};
        emptyArray = new int[3];
        oneElement = new int[]{1};
    }

    @Test
    void sortBySelection_evenNumberElements() {
        int[] sorted = Arrays.copyOf(evenNumberElements, evenNumberElements.length);
        Arrays.sort(sorted);

        final int[] result = sortBySelection(evenNumberElements);

        assertAll(
                () -> assertTrue(isSorted(result)),
                () -> assertArrayEquals(sorted, result)
        );
    }

    @Test
    void sortBySelection_oddNumberElements() {
        int[] sorted = Arrays.copyOf(oddNumberElements, oddNumberElements.length);
        Arrays.sort(sorted);

        final int[] result = sortBySelection(oddNumberElements);

        assertAll(
                () -> assertTrue(isSorted(result)),
                () -> assertArrayEquals(sorted, result)
        );
    }

    @Test
    void sortBySelection_emptyArray() {
        int[] sorted = Arrays.copyOf(emptyArray, emptyArray.length);
        Arrays.sort(sorted);

        final int[] result = sortBySelection(emptyArray);

        assertAll(
                () -> assertTrue(isSorted(result)),
                () -> assertArrayEquals(sorted, result)
        );
    }

    @Test
    void sortBySelection_oneElement() {
        int[] sorted = Arrays.copyOf(oneElement, oneElement.length);
        Arrays.sort(sorted);

        final int[] result = sortBySelection(oneElement);

        assertAll(
                () -> assertTrue(isSorted(result)),
                () -> assertArrayEquals(sorted, result)
        );
    }

    @Test
    void sortBySelection_nullInput() {
        assertAll(
                () -> assertTrue(isSorted(sortBySelection(null))),
                () -> assertNull(sortBySelection(null))
        );
    }

    @Test
    void sortByInsertions_evenNumberElements() {
        int[] sorted = Arrays.copyOf(evenNumberElements, evenNumberElements.length);
        Arrays.sort(sorted);

        final int[] result = sortByInsertions(evenNumberElements);

        assertAll(
                () -> assertTrue(isSorted(result)),
                () -> assertArrayEquals(sorted, result)
        );
    }

    @Test
    void sortByInsertions_oddNumberElements() {
        int[] sorted = Arrays.copyOf(oddNumberElements, oddNumberElements.length);
        Arrays.sort(sorted);

        final int[] result = sortByInsertions(oddNumberElements);

        assertAll(
                () -> assertTrue(isSorted(result)),
                () -> assertArrayEquals(sorted, result)
        );
    }

    @Test
    void sortByInsertions_emptyArray() {
        int[] sorted = Arrays.copyOf(emptyArray, emptyArray.length);
        Arrays.sort(sorted);

        final int[] result = sortByInsertions(emptyArray);

        assertAll(
                () -> assertTrue(isSorted(result)),
                () -> assertArrayEquals(sorted, result)
        );
    }

    @Test
    void sortByInsertions_oneElement() {
        int[] sorted = Arrays.copyOf(oneElement, oneElement.length);
        Arrays.sort(sorted);

        final int[] result = sortByInsertions(oneElement);

        assertAll(
                () -> assertTrue(isSorted(result)),
                () -> assertArrayEquals(sorted, result)
        );
    }

    @Test
    void sortByInsertions_nullInput() {
        assertAll(
                () -> assertTrue(isSorted(sortByInsertions(null))),
                () -> assertNull(sortByInsertions(null))
        );
    }

    @Test
    void sortByBubbles_evenNumberElements() {
        int[] sorted = Arrays.copyOf(evenNumberElements, evenNumberElements.length);
        Arrays.sort(sorted);

        final int[] result = sortByBubbles(evenNumberElements);

        assertAll(
                () -> assertTrue(isSorted(result)),
                () -> assertArrayEquals(sorted, result)
        );
    }

    @Test
    void sortByBubbles_oddNumberElements() {
        int[] sorted = Arrays.copyOf(oddNumberElements, oddNumberElements.length);
        Arrays.sort(sorted);

        final int[] result = sortByBubbles(oddNumberElements);

        assertAll(
                () -> assertTrue(isSorted(result)),
                () -> assertArrayEquals(sorted, result)
        );
    }

    @Test
    void sortByBubbles_emptyArray() {
        int[] sorted = Arrays.copyOf(emptyArray, emptyArray.length);
        Arrays.sort(sorted);

        final int[] result = sortByBubbles(emptyArray);

        assertAll(
                () -> assertTrue(isSorted(result)),
                () -> assertArrayEquals(sorted, result)
        );
    }

    @Test
    void sortByBubbles_oneElement() {
        int[] sorted = Arrays.copyOf(oneElement, oneElement.length);
        Arrays.sort(sorted);

        final int[] result = sortByBubbles(oneElement);

        assertAll(
                () -> assertTrue(isSorted(result)),
                () -> assertArrayEquals(sorted, result)
        );
    }

    @Test
    void sortByBubbles_nullInput() {
        assertAll(
                () -> assertTrue(isSorted(sortByBubbles(null))),
                () -> assertNull(sortByBubbles(null))
        );
    }
}