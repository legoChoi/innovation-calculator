package calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithemeticCalculator extends Calculator {

    private final Operator addOperator;
    private final Operator subtractOperator;
    private final Operator multiplyOperator;
    private final Operator divideOperator;
    private final Operator modOperator;

    private double a;
    private double b;
    private char op;

    private final List<Double> db;

    public ArithemeticCalculator(AddOperator addOperator, SubtractOperator subtractOperator, MultiplyOperator multiplyOperator, DivideOperator divideOperator, ModOperator modOperator) {
        this.addOperator = addOperator;
        this.subtractOperator = subtractOperator;
        this.multiplyOperator = multiplyOperator;
        this.divideOperator = divideOperator;
        this.modOperator = modOperator;
        this.db = new ArrayList<>();
    }

    public void setValues(double a, double b, char op) {
        this.a = a;
        this.b = b;
        this.op = op;
    }

    @Override
    public double calculate() {
        OperatorType operatorType = OperatorType.of(op);

        return switch (operatorType) {
            case PLUS -> addOperator.operate(a, b);
            case SUBTRACT -> subtractOperator.operate(a, b);
            case MULTIPLY -> multiplyOperator.operate(a, b);
            case DIVIDE -> divideOperator.operate(a, b);
            case MODULAR -> modOperator.operate(a, b);
        };
    }

    @Override
    public void saveResult(double result) {
        db.add(result);
    }

    @Override
    public void removeFirst(String type) {
        db.remove(0);
    }

    @Override
    public void printList() {
        for (double i : db) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
