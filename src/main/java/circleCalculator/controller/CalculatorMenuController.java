package circleCalculator.controller;

import circleCalculator.command.CalculatorMenuCommand;
import circleCalculator.controller.response.ControllerResponse;
import circleCalculator.util.Input;

public class CalculatorMenuController implements Controller {

    private final Input input;

    public CalculatorMenuController(Input input) {
        this.input = input;
    }

    @Override
    public ControllerResponse run() {
        CalculatorMenuCommand.print();
        CalculatorMenuCommand command = CalculatorMenuCommand.findByIndexOrCommand(input.readLine());

        return new ControllerResponse(command.getLevelFlag());
    }

    @Override
    public ControllerResponse handle() {
        return run();
    }
}
