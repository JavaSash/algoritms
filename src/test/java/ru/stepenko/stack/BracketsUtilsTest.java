package ru.stepenko.stack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.stepenko.stack.brackets.BracketsUtils;

import static org.junit.jupiter.api.Assertions.*;

class BracketsUtilsTest {

    private final static String SUCCESS = "Success";

    @ParameterizedTest
    @ValueSource(strings = {"([](){([])})", "()[]{}<>", "({[<>]})", "2(fdf)#", "(1-6-(5+3))"})
    void checkBracketsSequence_Success(String data) {
        assertTrue(BracketsUtils.checkBracketsSequence(data));
    }

    @ParameterizedTest
    @ValueSource(strings = {"([](){([])}))", "()[]}", "{{[()]]", "r[e]$}"})
    void checkBracketsSequence_Fail(String data) {
        assertFalse(BracketsUtils.checkBracketsSequence(data));
    }

    @ParameterizedTest
    @ValueSource(strings = {"([](){([])})", "()[]{}<>", "({[<>]})", "2(fdf)#", "(1-6-(5+3))"})
    void checkBrackets_Success(String data) {
        assertEquals(SUCCESS, BracketsUtils.checkBrackets(data));
    }

    @Test
    void checkBrackets_Fail() {
        assertAll(() -> assertEquals("13", BracketsUtils.checkBrackets("([](){([])}))")),
                () -> assertEquals("5", BracketsUtils.checkBrackets("()[]}")),
                () -> assertEquals("7", BracketsUtils.checkBrackets("{{[()]]")),
                () -> assertEquals("6", BracketsUtils.checkBrackets("r[e]$}")),
                () -> assertEquals("1", BracketsUtils.checkBrackets("(")),
                () -> assertEquals("3", BracketsUtils.checkBrackets("{[}")),
                () -> assertEquals("10", BracketsUtils.checkBrackets("foo(bar[i);")),
                () -> assertEquals("3", BracketsUtils.checkBrackets("[]([];")),
                () -> assertEquals("3", BracketsUtils.checkBrackets("{{{[][][]"))
        );
    }
}