package ru.stepenko.stack.brackets;

import java.util.Stack;

/**
 * Class to check correct sequence of brackets
 * Works with strings of any symbols, not only with brackets. Not bracket symbol will be ignored.
 * Processed types of brackets are located in enums:
 * {@link ru.stepenko.stack.brackets.OpeningBracket}
 * {@link ru.stepenko.stack.brackets.ClosingBracket}
 * {@link ru.stepenko.stack.brackets.PairedBrackets}
 */
public class BracketsUtils {

    private final static String SUCCESS = "Success";

    /**
     * Checks whether the sequence of brackets is correct
     * The correct sequence of brackets when there are the same number
     * of opening and closing brackets of the same type
     *
     * @param txt input data
     * @return true if input data contains correct sequence of brackets
     */
    public static boolean checkBracketsSequence(String txt) {
        Stack<Character> stack = new Stack<>();
        for (char c : txt.toCharArray()) {
            if (isOpenBracket(c)) {
                stack.push(c);
                continue;
            }
            if (isClosedBracket(c)) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (isPair(stack.peek(), c)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * Checks whether the sequence of brackets is correct
     * Difference with method checkBracketsSequence() is in return value
     *
     * @param txt input data
     * @return String eq "Success" when input data has correct sequence of brackets OR
     * String with index of first error in input data (for first unpaired closing bracket) OR
     * String with index for unpaired opening bracket
     */
    public static String checkBrackets(String txt) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> openIndexes = new Stack<>();
        int index = 0;

        for (char c : txt.toCharArray()) {
            index++;
            if (isOpenBracket(c)) {
                openIndexes.push(index);
                stack.push(c);
                continue;
            }
            if (isClosedBracket(c)) {
                if (stack.isEmpty()) {
                    return String.valueOf(index);
                } {
                    if (isPair(stack.peek(), c)) {
                        openIndexes.pop();
                        stack.pop();
                    } else {
                        return String.valueOf(index);
                    }
                }
            }
        }
        if (stack.isEmpty()) return SUCCESS;
        if (isOpenBracket(stack.peek())) return String.valueOf(openIndexes.peek());
        return String.valueOf(index);
    }

    private static boolean isOpenBracket(char bracket) {
        return bracket == OpeningBracket.ROUND.getBracket()
                || bracket == OpeningBracket.CURLY.getBracket()
                || bracket == OpeningBracket.CORNER.getBracket()
                || bracket == OpeningBracket.SQUARE.getBracket();
    }

    private static boolean isClosedBracket(char bracket) {
        return bracket == ClosingBracket.ROUND.getBracket()
                || bracket == ClosingBracket.CURLY.getBracket()
                || bracket == ClosingBracket.CORNER.getBracket()
                || bracket == ClosingBracket.SQUARE.getBracket();
    }

    private static boolean isPair(char open, char close) {
        if (PairedBrackets.ROUND.getBracket().equals("" + open + close)) return true;
        if (PairedBrackets.CURLY.getBracket().equals("" + open + close)) return true;
        if (PairedBrackets.CORNER.getBracket().equals("" + open + close)) return true;
        if (PairedBrackets.SQUARE.getBracket().equals("" + open + close)) return true;
        return false;
    }
}
