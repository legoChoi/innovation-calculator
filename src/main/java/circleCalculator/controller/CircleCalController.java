package circleCalculator.controller;

import circleCalculator.calculator.CircleCalculator;
import circleCalculator.LevelFlag;
import circleCalculator.util.Input;

public class CircleCalController implements Controller {

    private final Input input;
    private final CircleCalculator<Double> circleCalculator;

    public CircleCalController(Input input, CircleCalculator<Double> circleCalculator) {
        this.input = input;
        this.circleCalculator = circleCalculator;
    }

    @Override
    public LevelFlag run() {
        System.out.println();
        System.out.print("반지름을 입력하세요: ");
        double radius = input.readDouble();

        circleCalculator.setValues(radius);

        double result = circleCalculator.calculate();
        System.out.println(">>" + result);

        circleCalculator.saveResult(result);

        input.readLine();


        return LevelFlag.CIRCLE_CALCULATOR_POST_PROCESS;
    }
}
