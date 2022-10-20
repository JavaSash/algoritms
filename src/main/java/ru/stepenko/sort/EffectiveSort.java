package ru.stepenko.sort;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Objects;

/**
 * Contains utility methods of sorting with optimal complexity to use it in real projects
 */
@UtilityClass
public class EffectiveSort {

    /**
     * MergeSort
     * <p>
     * Dividing array in half.
     * Sorting halves.
     * Merge by choosing min element from two arrays.
     * Use recursion until array length > 1.
     * <p>
     * On each stage doing O(n) operations.
     * Levels of recursion is log(n), cause each time dividing array in half.
     * Complexity is O(nlogn).
     */
    public static int[] sortByMerge(int[] input) {
        if (Objects.isNull(input)) return null;

        int middle = input.length / 2;
        int[] left = new int[middle];
        int[] right = new int[input.length - middle];
        System.arraycopy(input, 0, left, 0, middle);
        System.arraycopy(input, middle, right, 0, right.length);
        Arrays.sort(left);
        Arrays.sort(right);
        int left_pointer = 0;
        int right_pointer = 0;
        boolean isLeftEnd = false;
        boolean isRightEnd = false;

        if (left.length < 2) {
            return input;
        }

        for (int i = 0; i < input.length; i++) {
            if ((left[left_pointer] <= right[right_pointer] && !isLeftEnd) || isRightEnd) {
                input[i] = left[left_pointer];
                if (left_pointer == left.length - 1) isLeftEnd = true;
                if (left_pointer < left.length - 1) left_pointer++;
            } else if ((left[left_pointer] > right[right_pointer] && !isRightEnd) || isLeftEnd) {
                input[i] = right[right_pointer];
                if (right_pointer == right.length - 1) isRightEnd = true;
                if (right_pointer < right.length - 1) right_pointer++;
            }
        }
        return input;
    }
}
