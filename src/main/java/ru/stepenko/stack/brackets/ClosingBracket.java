package ru.stepenko.stack.brackets;

import lombok.Getter;

@Getter
public enum ClosingBracket implements Bracket {

    ROUND(')'),
    CURLY('}'),
    CORNER('>'),
    SQUARE(']');

    final char bracket;

    ClosingBracket(char bracket) {
        this.bracket = bracket;
    }

    ClosingBracket getBraceType(char bracket) throws NoSuchBracketException {
        for (ClosingBracket type : ClosingBracket.values()) {
            if (bracket == type.getBracket()) {
                return type;
            }
        }
        throw new NoSuchBracketException();
    }
}
