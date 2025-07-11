package circleCalculator.controller;

import circleCalculator.State;
import circleCalculator.calculator.ArithmeticCalculator;
import circleCalculator.controller.response.ControllerResponse;
import circleCalculator.util.Input;

public class ArithmeticCalculatorPostProcessController extends AbstractCalculatorPostProcessController {

    public ArithmeticCalculatorPostProcessController(Input input, ArithmeticCalculator<Double> arithmeticCalculator) {
        super(input, arithmeticCalculator);
    }

    @Override
    protected State getCurrentPostProcessState() {
        return State.ARITHEMETIC_CALCULATOR_POST_PROCESS;
    }

    @Override
    public ControllerResponse handle() {
        return run();
    }
}
