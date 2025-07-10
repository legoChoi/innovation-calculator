package circleCalculator.handler;

import circleCalculator.menu.CalculatorMenu;
import circleCalculator.menu.Menu;
import circleCalculator.menu.LogMenu;
import circleCalculator.command.MenuCommand;

public class MenuHandler implements Handler<Menu, MenuCommand> {

    private final CalculatorMenu calculatorMenu;
    private final LogMenu logMenu;

    public MenuHandler(CalculatorMenu calculatorMenu, LogMenu logMenu) {
        this.calculatorMenu = calculatorMenu;
        this.logMenu = logMenu;
    }

    @Override
    public Menu get(MenuCommand command) {
        return switch (command) {
            case CALCULATION -> calculatorMenu;
            case LOG -> logMenu;
            case EXIT -> null;
        };
    }
}
