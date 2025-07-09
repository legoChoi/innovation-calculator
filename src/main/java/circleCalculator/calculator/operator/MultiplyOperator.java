package circleCalculator.calculator.operator;

import circleCalculator.util.NumberTypeConverter;

public class MultiplyOperator<T extends Number> implements Operator<T> {

    private final Class<T> type;

    public MultiplyOperator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T operate(T a, T b) {
        double result = a.doubleValue() * b.doubleValue();

        return NumberTypeConverter.convertTo(result, this.type);
    }
}
