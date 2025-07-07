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
        return switch (op) {
            case '+' -> addOperator.operate(a, b);
            case '-' -> subtractOperator.operate(a, b);
            case '*' -> multiplyOperator.operate(a, b);
            case '/' -> divideOperator.operate(a, b);
            case '%' -> op == '%' ? '%' : '+';
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
