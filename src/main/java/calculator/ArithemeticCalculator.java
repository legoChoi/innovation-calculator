package calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithemeticCalculator<T extends Number> extends Calculator {

    private final Operator addOperator;
    private final Operator subtractOperator;
    private final Operator multiplyOperator;
    private final Operator divideOperator;
    private final Operator modOperator;

    private T a;
    private T b;
    private OperatorType operatorType;

    private final Class<T> type;
    private final List<T> db;

    public ArithemeticCalculator(AddOperator<T> addOperator, SubtractOperator subtractOperator, MultiplyOperator multiplyOperator, DivideOperator divideOperator, ModOperator modOperator, Class<T> type) {
        this.addOperator = addOperator;
        this.subtractOperator = subtractOperator;
        this.multiplyOperator = multiplyOperator;
        this.divideOperator = divideOperator;
        this.modOperator = modOperator;
        this.type = type;
        this.db = new ArrayList<>();
    }

    public void setValues(T a, T b, char op) {
        this.a = a;
        this.b = b;
        operatorType = OperatorType.of(op);
    }

    @Override
    public T calculate() {
        return switch (operatorType) {
            case PLUS -> (T) addOperator.operate(a, b);
            case SUBTRACT -> (T) subtractOperator.operate(a, b);
            case MULTIPLY -> (T) multiplyOperator.operate(a, b);
            case DIVIDE -> (T) divideOperator.operate(a, b);
            case MODULAR -> (T) modOperator.operate(a, b);
        };
    }

    @Override
    public void saveResult(Number result) {
        T target = NumberTypeConverter.convertTo(result, type);
        this.db.add(target);
    }

    @Override
    public void removeFirst(String type) {
        db.remove(0);
    }

    @Override
    public void printList() {
        db.forEach(n -> {
            System.out.print(n + " ");
        });

        System.out.println();
    }


    @Override
    public void printBiggerListThan(Number target) {
        db.forEach(num -> {
            if (num.doubleValue() > target.doubleValue()) {
                System.out.print(num + " ");
            }
        });

        System.out.println();
    }
}
