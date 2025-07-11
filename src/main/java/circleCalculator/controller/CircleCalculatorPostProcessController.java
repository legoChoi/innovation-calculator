package circleCalculator.controller;

import circleCalculator.State;
import circleCalculator.calculator.CircleCalculator;
import circleCalculator.util.Input;

public class CircleCalculatorPostProcessController extends AbstractCalculatorPostProcessController {

    public CircleCalculatorPostProcessController(Input input, CircleCalculator<Double> circleCalculator) {
        super(input, circleCalculator);
    }

    @Override
    protected State getCurrentPostProcessLevelFlag() {
        return State.CIRCLE_CALCULATOR_POST_PROCESS;
    }

    @Override
    public State handle() {
        return run();
    }
}
