package circleCalculator.calculator;

import circleCalculator.command.PostProcessCommand;
import circleCalculator.exception.CustomRuntimeException;
import circleCalculator.exception.ExceptionLogService;
import circleCalculator.util.Input;

public class CalculatorPostProcessor {

    private final Input input;
    private final ExceptionLogService exceptionLogService;

    public CalculatorPostProcessor(Input input, ExceptionLogService exceptionLogService) {
        this.input = input;
        this.exceptionLogService = exceptionLogService;
    }

    public boolean run(Calculator<Double> calculator) {
        try {
            PostProcessCommand.print();

            String command = input.readLine();
            PostProcessCommand postProcessCommand = PostProcessCommand.findByIndexOrCommand(command);

            switch (postProcessCommand) {
                case REMOVE -> calculator.removeFirst();
                case INQUIRY -> calculator.printList();
                case BIGGER -> {
                    System.out.print(">> ");
                    calculator.printBiggerListThan(input.readDouble());
                    input.readLine();
                }
                case EXIT -> {
                    return true;
                }
            }

        } catch (CustomRuntimeException e) {
            exceptionLogService.saveLog(e.getMessage());
        }

        return false;
    }
}
