package circleCalculator.menu;

import circleCalculator.dispatcher.CalculatorControllerDispatcher;

public class CalculatorMenu implements Menu {

    private final CalculatorControllerDispatcher calculatorControllerDispatcher;

    public CalculatorMenu(
            CalculatorControllerDispatcher calculatorControllerDispatcher
    ) {
        this.calculatorControllerDispatcher = calculatorControllerDispatcher;
    }

    @Override
    public void run() {
        calculatorControllerDispatcher.dispatch();
    }
}
