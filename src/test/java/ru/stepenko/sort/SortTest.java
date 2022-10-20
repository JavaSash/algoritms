package ru.stepenko.sort;

import java.util.Objects;

public class SortTest {

    protected static boolean isSorted(int[] input) {
        if (Objects.isNull(input)) return true;
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] > input[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
