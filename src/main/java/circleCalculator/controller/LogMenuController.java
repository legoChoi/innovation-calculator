package circleCalculator.controller;

import circleCalculator.State;
import circleCalculator.command.LogMenuCommand;
import circleCalculator.exception.ExceptionLogService;
import circleCalculator.util.Input;

public class LogMenuController implements Controller {

    private final Input input;
    private final ExceptionLogService exceptionLogService;

    public LogMenuController(Input input, ExceptionLogService exceptionLogService) {
        this.input = input;
        this.exceptionLogService = exceptionLogService;
    }

    @Override
    public State run() {
        LogMenuCommand.print();
        LogMenuCommand command = LogMenuCommand.findByIndexOrCommand(input.readLine());

        switch (command) {
            case PRINT -> exceptionLogService.printLogList();
            case CLEAR -> exceptionLogService.clearLogList();
        }

        return command.getLevelFlag();
    }

    @Override
    public State handle() {
        return run();
    }
}
