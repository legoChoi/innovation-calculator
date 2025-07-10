package circleCalculator.controller;

import circleCalculator.LevelFlag;
import circleCalculator.calculator.ArithmeticCalculator;
import circleCalculator.util.Input;

public class ArithmeticCalculatorPostProcessController extends AbstractCalculatorPostProcessController {

    public ArithmeticCalculatorPostProcessController(Input input, ArithmeticCalculator<Double> arithmeticCalculator) {
        super(input, arithmeticCalculator);
    }

    @Override
    protected LevelFlag getCurrentPostProcessLevelFlag() {
        return LevelFlag.ARITHEMETIC_CALCULATOR_POST_PROCESS;
    }

    @Override
    public LevelFlag handle() {
        return run();
    }
}
