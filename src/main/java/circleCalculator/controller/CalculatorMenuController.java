package circleCalculator.controller;

import circleCalculator.LevelFlag;
import circleCalculator.command.CalculationCommand;
import circleCalculator.util.Input;

public class CalculatorMenuController implements Controller {

    private final Input input;

    public CalculatorMenuController(Input input) {
        this.input = input;
    }

    @Override
    public LevelFlag run() {
        CalculationCommand.print();
        CalculationCommand command = CalculationCommand.findByIndexOrCommand(input.readLine());

        return command.getLevelFlag();
    }
}
