package circleCalculator.handler;

import circleCalculator.calculator.CalculatorController;
import circleCalculator.command.CalculationCommand;

public class CalculatorHandler implements Handler<CalculatorController, CalculationCommand> {

    private final CalculatorController circleCalculationController;
    private final CalculatorController arithmeticCalculationController;

    public CalculatorHandler(CalculatorController circleCalculationController, CalculatorController arithmeticCalculationController) {
        this.circleCalculationController = circleCalculationController;
        this.arithmeticCalculationController = arithmeticCalculationController;
    }

    @Override
    public CalculatorController get(CalculationCommand command) {
        return switch (command) {
            case NORMAL -> arithmeticCalculationController;
            case CIRCLE -> circleCalculationController;
            case BACK -> null;
        };
    }
}
