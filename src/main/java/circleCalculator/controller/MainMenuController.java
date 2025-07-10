package circleCalculator.controller;

import circleCalculator.LevelFlag;
import circleCalculator.command.MenuCommand;
import circleCalculator.util.Input;

public class MainMenuController implements Controller {

    private final Input input;

    public MainMenuController(Input input) {
        this.input = input;
    }

    @Override
    public LevelFlag run() {
        MenuCommand.print();
        MenuCommand command = MenuCommand.findByIndexOrCommand(input.readLine());

        return command.getLevelFlag();
    }
}
