package calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithemeticCalculator<T extends Number> extends Calculator {

    private final Operator<T> addOperator;
    private final Operator<T> subtractOperator;
    private final Operator<T> multiplyOperator;
    private final Operator<T> divideOperator;
    private final Operator<T> modOperator;

    private T a;
    private T b;
    private OperatorType operatorType;

    private final Class<T> type;
    private final List<T> db;

    public ArithemeticCalculator(AddOperator<T> addOperator, SubtractOperator<T> subtractOperator, MultiplyOperator<T> multiplyOperator, DivideOperator<T> divideOperator, ModOperator<T> modOperator, Class<T> type) {
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
            case PLUS -> addOperator.operate(a, b);
            case SUBTRACT -> subtractOperator.operate(a, b);
            case MULTIPLY -> multiplyOperator.operate(a, b);
            case DIVIDE -> divideOperator.operate(a, b);
            case MODULAR -> modOperator.operate(a, b);
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
