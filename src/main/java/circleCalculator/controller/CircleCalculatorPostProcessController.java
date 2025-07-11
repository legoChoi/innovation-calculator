package circleCalculator.controller;

import circleCalculator.State;
import circleCalculator.calculator.CircleCalculator;
import circleCalculator.controller.response.ControllerResponse;
import circleCalculator.util.Input;

public class CircleCalculatorPostProcessController extends AbstractCalculatorPostProcessController {

    public CircleCalculatorPostProcessController(Input input, CircleCalculator<Double> circleCalculator) {
        super(input, circleCalculator);
    }

    @Override
    protected State getCurrentPostProcessState() {
        return State.CIRCLE_CALCULATOR_POST_PROCESS;
    }

    @Override
    public ControllerResponse handle() {
        return run();
    }
}
