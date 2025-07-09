package circleCalculator.handler;

import circleCalculator.calculator.controller.ArithmeticCalculatorController;
import circleCalculator.calculator.controller.CalculatorController;
import circleCalculator.calculator.controller.CircleCalculatorController;
import circleCalculator.command.CalculationCommand;

public class CalculatorHandler implements Handler<CalculatorController, CalculationCommand> {

    private final CircleCalculatorController circleCalculationController;
    private final ArithmeticCalculatorController arithmeticCalculationController;

    public CalculatorHandler(CircleCalculatorController circleCalculationController, ArithmeticCalculatorController arithmeticCalculationController) {
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
