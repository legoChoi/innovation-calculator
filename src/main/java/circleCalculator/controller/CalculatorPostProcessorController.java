package circleCalculator.controller;

import circleCalculator.calculator.LevelFlag;
import circleCalculator.command.PostProcessCommand;

public class CalculatorPostProcessorController implements Controller {


    public void test() {

    }

    @Override
    public LevelFlag run() {
        PostProcessCommand.print();
        return null;
    }
}
