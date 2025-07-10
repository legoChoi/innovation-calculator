package circleCalculator.controller;

import circleCalculator.LevelFlag;
import circleCalculator.command.CalculatorMenuCommand;
import circleCalculator.util.Input;

public class CalculatorMenuController implements Controller {

    private final Input input;

    public CalculatorMenuController(Input input) {
        this.input = input;
    }

    @Override
    public LevelFlag run() {
        CalculatorMenuCommand.print();
        CalculatorMenuCommand command = CalculatorMenuCommand.findByIndexOrCommand(input.readLine());

        return command.getLevelFlag();
    }
}
