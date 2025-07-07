package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final List<Integer> db = new ArrayList<>();

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
}
