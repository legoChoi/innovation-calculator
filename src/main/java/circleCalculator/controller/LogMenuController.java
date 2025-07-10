package circleCalculator.controller;

import circleCalculator.LevelFlag;
import circleCalculator.command.LogCommand;
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
    public LevelFlag run() {
        LogCommand.print();
        LogCommand command = LogCommand.findByIndexOrCommand(input.readLine());

        switch (command) {
            case PRINT -> exceptionLogService.printLogList();
            case CLEAR -> exceptionLogService.clearLogList();
        }

        return command.getLevelFlag();
    }
}
