package circleCalculator.controller;

import circleCalculator.calculator.ArithmeticCalculator;
import circleCalculator.LevelFlag;
import circleCalculator.util.Input;

public class ArithmeticCalController implements Controller {

    private final Input input;
    private final ArithmeticCalculator<Double> arithmeticCalculator;

    public ArithmeticCalController(Input input, ArithmeticCalculator<Double> arithmeticCalculator) {
        this.input = input;
        this.arithmeticCalculator = arithmeticCalculator;
    }

    @Override
    public LevelFlag run() {
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

        return LevelFlag.ARITHEMETIC_CALCULATOR_POST_PROCESS;
    }
}
