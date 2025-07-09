package circleCalculator.calculator.operator;

import circleCalculator.util.NumberTypeConverter;
import circleCalculator.exception.CalculatorException;
import circleCalculator.exception.CustomRuntimeException;

public class DivideOperator<T extends Number> implements Operator<T> {

    private final Class<T> type;

    public DivideOperator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T operate(T a, T b) {
        if (b.doubleValue() == 0) {
            throw new CustomRuntimeException(CalculatorException.DIVIDE_BY_ZERO);
        }

        double result = a.doubleValue() / b.doubleValue();

        return NumberTypeConverter.convertTo(result, this.type);
    }
}
