package circleCalculator.controller;

import circleCalculator.LevelFlag;
import circleCalculator.command.PostProcessCommand;

public class CalculatorPostProcessorController implements Controller {

    @Override
    public LevelFlag run() {
        PostProcessCommand.print();
        return null;
    }
}
