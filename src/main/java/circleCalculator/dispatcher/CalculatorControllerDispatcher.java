package circleCalculator.dispatcher;

import circleCalculator.util.Input;
import circleCalculator.calculator.controller.CalculatorController;
import circleCalculator.exception.CustomRuntimeException;
import circleCalculator.exception.ExceptionLogService;
import circleCalculator.handler.CalculatorHandler;
import circleCalculator.command.CalculationCommand;
import circleCalculator.handler.Handler;

public class CalculatorControllerDispatcher implements Dispatcher {

    private final ExceptionLogService exceptionLogService;
    private final Handler<CalculatorController, CalculationCommand> calculatorHandler;
    private final Input input;

    public CalculatorControllerDispatcher(ExceptionLogService exceptionLogService, CalculatorHandler calculatorHandler, Input input) {
        this.exceptionLogService = exceptionLogService;
        this.calculatorHandler = calculatorHandler;
        this.input = input;
    }

    @Override
    public void dispatch() {
        while (true) {
            CalculationCommand.print();
            String commandInput = input.readLine();

            try {
                CalculationCommand command = CalculationCommand.findByIndexOrCommand(commandInput);
                CalculatorController calculatorController = calculatorHandler.get(command);

                if (calculatorController == null) {
                    break;
                }

                calculatorController.run();
            } catch (CustomRuntimeException e) {
                exceptionLogService.saveLog(e.getMessage());
            }
        }
    }
}
