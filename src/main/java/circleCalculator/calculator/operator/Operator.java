package circleCalculator.calculator.operator;

public interface Operator<T extends Number> {

    T operate(T a, T b);
}
