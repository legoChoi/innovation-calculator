package circleCalculator.calculator.operator;

import circleCalculator.exception.CalculatorException;
import circleCalculator.exception.CustomRuntimeException;

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
                .orElseThrow(() -> new CustomRuntimeException(CalculatorException.NOT_SUPPORTED_OPERATOR));
    }

    private char getSymbol() {
        return this.symbol;
    }
}
