package calculator;

public class ModOperator<T extends Number> implements Operator<T> {

    private final Class<T> type;

    public ModOperator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T operate(T a, T b) {
        double result = a.doubleValue() % b.doubleValue();
        
        return NumberTypeConverter.convertTo(result, this.type);
    }
}
