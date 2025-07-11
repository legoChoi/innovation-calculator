package circleCalculator.controller;

import circleCalculator.calculator.ArithmeticCalculator;
import circleCalculator.State;
import circleCalculator.util.Input;

public class ArithmeticCalculatorController implements Controller {

    private final Input input;
    private final ArithmeticCalculator<Double> arithmeticCalculator;

    public ArithmeticCalculatorController(Input input, ArithmeticCalculator<Double> arithmeticCalculator) {
        this.input = input;
        this.arithmeticCalculator = arithmeticCalculator;
    }

    @Override
    public State run() {
        System.out.println();
        System.out.print("첫 번째 숫자를 입력하세요: ");
        double a = input.readDouble();

        System.out.print("두 번째 숫자를 입력하세요: ");
        double b = input.readDouble();

        System.out.print("사칙연산 기호를 입력하세요: ");
        char op = input.readChar();

        arithmeticCalculator.setValues(a, b, op);

        double result = arithmeticCalculator.calculate();
        System.out.println(">> " + result);

        arithmeticCalculator.saveResult(result);

        input.readLine();

        return State.ARITHEMETIC_CALCULATOR_POST_PROCESS;
    }

    @Override
    public State handle() {
        return run();
    }
}
