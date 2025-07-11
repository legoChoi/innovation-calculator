package circleCalculator.controller;

import circleCalculator.command.LogMenuCommand;
import circleCalculator.controller.response.ControllerResponse;
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
    public ControllerResponse run() {
        LogMenuCommand.print();
        LogMenuCommand command = LogMenuCommand.findByIndexOrCommand(input.readLine());

        switch (command) {
            case PRINT -> exceptionLogService.printLogList();
            case CLEAR -> exceptionLogService.clearLogList();
        }

        return new ControllerResponse(command.getState());
    }

    @Override
    public ControllerResponse handle() {
        return run();
    }
}
