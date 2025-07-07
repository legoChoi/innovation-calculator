package calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithemeticCalculator extends Calculator {

    private double a;
    private double b;
    private char op;

    private final List<Double> db;

    public ArithemeticCalculator() {
        this.db = new ArrayList<>();
    }

    public void setValues(double a, double b, char op) {
        this.a = a;
        this.b = b;
        this.op = op;
    }

    @Override
    public double calculate() {
        switch (op) {
            case '+':
                return a + b;

            case '-':
                return a - b;

            case '*':
                return a * b;

            case '/':
                if (b == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }

                return a / b;

            default:
                throw new ArithmeticException("유효하지 않은 연산자입니다.");
        }
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
