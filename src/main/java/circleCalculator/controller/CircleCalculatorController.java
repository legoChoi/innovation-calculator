package circleCalculator.controller;

import circleCalculator.State;
import circleCalculator.calculator.CircleCalculator;
import circleCalculator.controller.response.ControllerResponse;
import circleCalculator.util.Input;

public class CircleCalculatorController implements Controller {

    private final Input input;
    private final CircleCalculator<Double> circleCalculator;

    public CircleCalculatorController(Input input, CircleCalculator<Double> circleCalculator) {
        this.input = input;
        this.circleCalculator = circleCalculator;
    }

    @Override
    public ControllerResponse run() {
        System.out.println();
        System.out.print("반지름을 입력하세요: ");
        double radius = input.readDouble();

        circleCalculator.setValues(radius);

        double result = circleCalculator.calculate();
        System.out.println(">>" + result);

        circleCalculator.saveResult(result);

        input.readLine();

        return new ControllerResponse(State.CIRCLE_CALCULATOR_POST_PROCESS);
    }

    @Override
    public ControllerResponse handle() {
        return run();
    }
}
