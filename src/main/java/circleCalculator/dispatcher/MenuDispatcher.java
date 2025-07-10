package circleCalculator.dispatcher;

import circleCalculator.command.MenuCommand;
import circleCalculator.exception.CustomRuntimeException;
import circleCalculator.exception.ExceptionLogService;
import circleCalculator.handler.Handler;
import circleCalculator.handler.MenuHandler;
import circleCalculator.menu.Menu;
import circleCalculator.util.Input;

public class MenuDispatcher implements Dispatcher {

    private final Input input;
    private final ExceptionLogService exceptionLogService;
    private final Handler<Menu, MenuCommand> menuHandler;

    public MenuDispatcher(Input input, ExceptionLogService exceptionLogService, MenuHandler handler) {
        this.input = input;
        this.exceptionLogService = exceptionLogService;
        this.menuHandler = handler;
    }

    @Override
    public void dispatch() {
        while (true) {
            MenuCommand.print();
            String commandInput = input.readLine();

            try {
                MenuCommand command = MenuCommand.findByIndexOrCommand(commandInput);
                Menu menu = menuHandler.get(command);

                if (menu == null) {
                    break;
                }

                menu.run();
            } catch (CustomRuntimeException e) {
                exceptionLogService.saveLog(e.getMessage());
            }
        }
    }
}
