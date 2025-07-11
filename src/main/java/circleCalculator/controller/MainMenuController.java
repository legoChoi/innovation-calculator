package circleCalculator.controller;

import circleCalculator.command.MainMenuCommand;
import circleCalculator.controller.response.ControllerResponse;
import circleCalculator.util.Input;

public class MainMenuController implements Controller {

    private final Input input;

    public MainMenuController(Input input) {
        this.input = input;
    }

    @Override
    public ControllerResponse run() {
        MainMenuCommand.print();
        MainMenuCommand command = MainMenuCommand.findByIndexOrCommand(input.readLine());

        return new ControllerResponse(command.getLevelFlag());
    }

    @Override
    public ControllerResponse handle() {
        return run();
    }
}
