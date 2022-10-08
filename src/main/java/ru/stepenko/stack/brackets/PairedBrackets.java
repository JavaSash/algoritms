package ru.stepenko.stack.brackets;

import lombok.Getter;

@Getter
public enum PairedBrackets implements Bracket {

    ROUND("()"),
    CURLY("{}"),
    CORNER("<>"),
    SQUARE("[]");

    final String bracket;

    PairedBrackets(String bracket) {
        this.bracket = bracket;
    }

}
