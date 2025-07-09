package circleCalculator.handler;

import circleCalculator.menu.CalculatorMenu;
import circleCalculator.menu.Menu;
import circleCalculator.menu.ExceptionLogMenu;
import circleCalculator.command.MenuCommand;

public class MenuHandler implements Handler<Menu, MenuCommand> {

    private final CalculatorMenu calculatorMenu;
    private final ExceptionLogMenu exceptionLogMenu;

    public MenuHandler(CalculatorMenu calculatorMenu, ExceptionLogMenu exceptionLogMenu) {
        this.calculatorMenu = calculatorMenu;
        this.exceptionLogMenu = exceptionLogMenu;
    }

    @Override
    public Menu get(MenuCommand command) {
        return switch (command) {
            case CALCULATION -> calculatorMenu;
            case LOG -> exceptionLogMenu;
            case EXIT -> null;
        };
    }
}
