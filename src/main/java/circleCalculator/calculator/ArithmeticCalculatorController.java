package circleCalculator.calculator;

import circleCalculator.exception.CustomRuntimeException;
import circleCalculator.exception.ExceptionLogService;
import circleCalculator.util.Input;

public class ArithmeticCalculatorController implements CalculatorController {

    private final Input input;
    private final ExceptionLogService exceptionLogService;
    private final ArithmeticCalculator<Double> arithmeticCalculator;
    private final CalculatorPostProcessor calculatorPostProcessor;

    public ArithmeticCalculatorController(
            Input input,
            ExceptionLogService exceptionLogService,
            ArithmeticCalculator<Double> arithmeticCalculator,
            CalculatorPostProcessor calculatorPostProcessor
    ) {
        this.input = input;
        this.exceptionLogService = exceptionLogService;
        this.arithmeticCalculator = arithmeticCalculator;
        this.calculatorPostProcessor = calculatorPostProcessor;
    }

    @Override
    public void run() {
        Double result;

        while (true) {
            try {
                System.out.println();
                System.out.print("첫 번째 숫자를 입력하세요: ");
                double a = input.readDouble();

                System.out.print("두 번째 숫자를 입력하세요: ");
                double b = input.readDouble();

                System.out.print("사칙연산 기호를 입력하세요: ");
                char op = input.readChar();

                arithmeticCalculator.setValues(a, b, op);

                result = arithmeticCalculator.calculate();
                System.out.println(">> " + result);

                arithmeticCalculator.saveResult(result);

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
            if (calculatorPostProcessor.run(arithmeticCalculator)) {
                return;
            }
        }
    }
}
