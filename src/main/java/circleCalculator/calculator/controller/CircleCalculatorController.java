package circleCalculator.calculator.controller;

import circleCalculator.calculator.CalculatorPostProcessor;
import circleCalculator.calculator.CircleCalculator;
import circleCalculator.command.PostProcessCommand;
import circleCalculator.exception.CustomRuntimeException;
import circleCalculator.exception.ExceptionLogService;
import circleCalculator.util.Input;

public class CircleCalculatorController implements CalculatorController {

    private final Input input;
    private final ExceptionLogService exceptionLogService;
    private final CircleCalculator<Double> circleCalculator;
    private final CalculatorPostProcessor calculatorPostProcessor;

    public CircleCalculatorController(
            Input input,
            ExceptionLogService exceptionLogService,
            CircleCalculator<Double> circleCalculator,
            CalculatorPostProcessor calculatorPostProcessor
    ) {
        this.input = input;
        this.exceptionLogService = exceptionLogService;
        this.circleCalculator = circleCalculator;
        this.calculatorPostProcessor = calculatorPostProcessor;
    }

    @Override
    public void run() {
        Double result;

        while (true) {
            try {
                System.out.println();
                System.out.print("반지름을 입력하세요: ");
                double radius = input.readDouble();

                circleCalculator.setValues(radius);

                result = circleCalculator.calculate();
                System.out.println(">>" + result);

                circleCalculator.saveResult(result);

                input.readLine();

                break;
            } catch (CustomRuntimeException e) {
                exceptionLogService.saveLog(e.getMessage());
            }
        }

        if (result == null) {
            return;
        }

        while (true) {
            if (calculatorPostProcessor.run(circleCalculator)) {
                return;
            }
        }
    }
}
