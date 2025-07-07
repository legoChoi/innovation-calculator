package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final List<Integer> db;
    private final List<Double> circleDb;

    public Calculator() {
        db = new ArrayList<>();
        circleDb = new ArrayList<>();
    }

    public int calculate(int a, int b, char op) {
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

    public double calculateCircleArea(int radius) {
        return Math.PI * radius * radius; // 항성 고정된 정적 변수 값 Math.PI
    }

    public void saveResult(int result) {
        db.add(result);
    }

    public void saveCircleAreaResult(double result) {
        circleDb.add(result);
    }

    public void removeFirst(String type) {
        if (type.equals("normal")) {
            db.remove(0);
        }

        if (type.equals("circle")) {
            circleDb.remove(0);
        }
    }

    public void printList() {
        System.out.print("일반 계산 목록 >> ");
        for (int i : db) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("원 넓이 목록 >> ");
        for (double r : circleDb) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
}
