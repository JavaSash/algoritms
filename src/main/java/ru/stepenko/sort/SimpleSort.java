package ru.stepenko.sort;

import lombok.experimental.UtilityClass;

import java.util.Objects;

/**
 * Quadratic complexity sorting.
 * It's only for education, not recommended to use in real projects.
 */
@UtilityClass
public class SimpleSort {

    /**
     * Selection sort.
     * Choosing minimal element n-times to sort array.
     */
    public static int[] sortBySelection(int[] input) {
        if (Objects.isNull(input)) return null;
        for (int i = 0; i < input.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[minIndex] > input[j]) {
                    minIndex = j;
                }
            }
            if (input[i] > input[minIndex]) {
                swap(input, i, minIndex);
            }
        }
        return input;
    }

    private void swap(int[] input, int first, int second) {
        int temp = input[first];
        input[first] = input[second];
        input[second] = temp;
    }

    /**
     * Insertion sort
     * Move smaller of two elements to the left, until we pass the cycle without offset
     */
    public static int[] sortByInsertions(int[] input) {
        if (Objects.isNull(input)) return null;
        boolean offset = true;
        do {
            offset = false;
            for (int i = 0; i < input.length - 1; i++) {
                if (input[i] > input[i + 1]) {
                    swap(input, i, i + 1);
                    offset = true;
                }
            }
        } while (offset);
        return input;
    }

    /**
     * Bubble sort
     * Pushing max element to end
     */
    public static int[] sortByBubbles(int[] input) {
        if (Objects.isNull(input)) return null;
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if(input[i] > input[j]) swap(input, i, j);
            }
        }
        return input;
    }
}
