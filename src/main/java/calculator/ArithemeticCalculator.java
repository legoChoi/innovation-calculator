package calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithemeticCalculator extends Calculator {

    private final AddOperator addOperator;
    private final SubtractOperator subtractOperator;
    private final MultiplyOperator multiplyOperator;
    private final DivideOperator divideOperator;

    private double a;
    private double b;
    private char op;

    private final List<Double> db;

    public ArithemeticCalculator(AddOperator addOperator, SubtractOperator subtractOperator, MultiplyOperator multiplyOperator, DivideOperator divideOperator) {
        this.addOperator = addOperator;
        this.subtractOperator = subtractOperator;
        this.multiplyOperator = multiplyOperator;
        this.divideOperator = divideOperator;
        this.db = new ArrayList<>();
    }

    public void setValues(double a, double b, char op) {
        this.a = a;
        this.b = b;
        this.op = op;
    }

    @Override
    public double calculate() {
        return switch (op) {
            case '+' -> addOperator.operate(a, b);
            case '-' -> subtractOperator.operate(a, b);
            case '*' -> multiplyOperator.operate(a, b);
            case '/' -> divideOperator.operate(a, b);
            default -> throw new ArithmeticException("유효하지 않은 연산자입니다.");
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
