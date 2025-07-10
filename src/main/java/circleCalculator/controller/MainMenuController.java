package circleCalculator.controller;

import circleCalculator.LevelFlag;
import circleCalculator.command.MainMenuCommand;
import circleCalculator.util.Input;

public class MainMenuController implements Controller {

    private final Input input;

    public MainMenuController(Input input) {
        this.input = input;
    }

    @Override
    public LevelFlag run() {
        MainMenuCommand.print();
        MainMenuCommand command = MainMenuCommand.findByIndexOrCommand(input.readLine());

        return command.getLevelFlag();
    }

    @Override
    public LevelFlag handle() {
        return run();
    }
}
