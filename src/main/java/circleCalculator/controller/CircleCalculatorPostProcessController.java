package circleCalculator.controller;

import circleCalculator.LevelFlag;
import circleCalculator.calculator.CircleCalculator;
import circleCalculator.util.Input;

public class CircleCalculatorPostProcessController extends AbstractCalculatorPostProcessController {

    public CircleCalculatorPostProcessController(Input input, CircleCalculator<Double> circleCalculator) {
        super(input, circleCalculator);
    }

    @Override
    protected LevelFlag getCurrentPostProcessLevelFlag() {
        return LevelFlag.CIRCLE_CALCULATOR_POST_PROCESS;
    }
}
