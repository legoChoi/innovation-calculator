package circleCalculator.menu;

import circleCalculator.exception.ExceptionLogService;
import circleCalculator.util.Input;
import circleCalculator.command.LogCommand;

public class LogMenu implements Menu {

    private final Input input;
    private final ExceptionLogService exceptionLogService;

    public LogMenu(Input input, ExceptionLogService exceptionLogService) {
        this.input = input;
        this.exceptionLogService = exceptionLogService;
    }

    @Override
    public void run() {
        LogCommand.print();
        String commandInput = input.readLine();

        LogCommand logCommand = LogCommand.findByIndexOrCommand(commandInput);

        switch (logCommand) {
            case PRINT -> exceptionLogService.printLogList();
            case CLEAR -> exceptionLogService.clearLogList();
        }
    }
}
