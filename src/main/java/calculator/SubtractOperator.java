package calculator;

public class SubtractOperator implements Operator {

    @Override
    public double operate(double a, double b) {
        return a - b;
    }
}
