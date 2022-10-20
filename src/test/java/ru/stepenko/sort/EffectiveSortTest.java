package ru.stepenko.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static ru.stepenko.sort.EffectiveSort.sortByMerge;

class EffectiveSortTest extends SortTest {

    @Test
    void sortByMerge_evenNumberElements() {
        int[] evenNumberElements = new int[]{3, 2, 1, 2, 4, 8};
        int[] evenNumberElementsSorted = Arrays.copyOf(evenNumberElements, evenNumberElements.length);
        Arrays.sort(evenNumberElementsSorted);

        final int[] result = sortByMerge(evenNumberElements);
        assertAll(
                () -> assertTrue(isSorted(result)),
                () -> assertArrayEquals(evenNumberElementsSorted, result)
        );
    }

    @Test
    void sortByMerge_oddNumberElements() {
        int[] oddNumberElements = new int[]{0, 2, 7, 1, 2, -6, 4};
        int[] oddNumberElementsSorted = Arrays.copyOf(oddNumberElements, oddNumberElements.length);
        Arrays.sort(oddNumberElementsSorted);

        final int[] result = sortByMerge(oddNumberElements);

        assertAll(
                () -> assertTrue(isSorted(result)),
                () -> assertArrayEquals(oddNumberElementsSorted, result)
        );
    }

    @Test
    void sortByMerge_emptyArray() {
        int[] emptyArray = new int[5];
        int[] emptyArraySorted = Arrays.copyOf(emptyArray, emptyArray.length);
        Arrays.sort(emptyArraySorted);

        final int[] result = sortByMerge(emptyArray);

        assertAll(
                () -> assertTrue(isSorted(result)),
                () -> assertArrayEquals(emptyArraySorted, result)
        );
    }

    @Test
    void sortByMerge_oneElement() {
        int[] oneElement = new int[]{1};
        int[] oneElementSorted = Arrays.copyOf(oneElement, oneElement.length);
        Arrays.sort(oneElementSorted);

        final int[] result = sortByMerge(oneElement);

        assertAll(
                () -> assertTrue(isSorted(result)),
                () -> assertArrayEquals(oneElementSorted, result)
        );
    }

    @Test
    void sortByMerge_nullInput() {
        assertAll(
                () -> assertTrue(isSorted(sortByMerge(null))),
                () -> assertNull(sortByMerge(null))
        );
    }

}