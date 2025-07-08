package calculator;

import java.util.Arrays;

public enum OperatorType {

    PLUS('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/'),
    MODULAR('%');

    private final char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public static OperatorType of(char operator) {
        return Arrays.stream(OperatorType.values())
                .filter(operatorType -> operatorType.getSymbol() == operator)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 연산자입니다."));
    }

    private char getSymbol() {
        return this.symbol;
    }
}
