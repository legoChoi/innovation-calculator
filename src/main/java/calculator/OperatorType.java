package calculator;

import java.util.Arrays;

public enum OperatorType {

    PLUS('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/'),
    MODULAR('%');

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    private final char symbol;

    public static OperatorType of(char op) {
        return Arrays.stream(OperatorType.values())
                .filter(operatorType -> operatorType.getSymbol() == op)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 연산자입니다."));
    }

    private char getSymbol() {
        return symbol;
    }
}
