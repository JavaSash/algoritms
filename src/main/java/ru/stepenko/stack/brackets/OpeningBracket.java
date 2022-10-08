package ru.stepenko.stack.brackets;

import lombok.Getter;

@Getter
public enum OpeningBracket implements Bracket {

    ROUND('('),
    CURLY('{'),
    CORNER('<'),
    SQUARE('[');

    final char bracket;

    OpeningBracket(char bracket) {
        this.bracket = bracket;
    }

    OpeningBracket getBraceType(char bracket) throws NoSuchBracketException {
        for (OpeningBracket type : OpeningBracket.values()) {
            if (bracket == type.getBracket()) {
                return type;
            }
        }
        throw new NoSuchBracketException();
    }
}
