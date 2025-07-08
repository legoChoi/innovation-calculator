package calculator;

public class DivideOperator<T extends Number> implements Operator<T> {

    private final Class<T> type;

    public DivideOperator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T operate(T a, T b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }

        double result = a.doubleValue() / b.doubleValue();

        return NumberTypeConverter.convertTo(result, this.type);
    }
}
