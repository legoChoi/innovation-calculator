package circleCalculator.calculator.controller;

import circleCalculator.calculator.ArithmeticCalculator;
import circleCalculator.exception.CalculatorException;
import circleCalculator.exception.CustomRuntimeException;
import circleCalculator.util.Input;
import circleCalculator.exception.ExceptionLogService;

import java.util.InputMismatchException;

public class ArithmeticCalculatorController implements CalculatorController {

    private final Input input;
    private final ExceptionLogService exceptionLogService;
    private final ArithmeticCalculator<Double> arithmeticCalculator;

    public ArithmeticCalculatorController(Input input, ExceptionLogService exceptionLogService, ArithmeticCalculator<Double> arithmeticCalculator) {
        this.input = input;
        this.exceptionLogService = exceptionLogService;
        this.arithmeticCalculator = arithmeticCalculator;
    }

    @Override
    public void run() {
        Double result;

        while (true) {
            try {
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
            try {
                if (postProcess()) {
                    return;
                }
            } catch (CustomRuntimeException e) {
                exceptionLogService.saveLog(e.getMessage());
            }
        }
    }

    private boolean postProcess() {
        System.out.println();
        System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제) ");

        if (input.readLine().equalsIgnoreCase("remove")) {
            arithmeticCalculator.removeFirst();
        }

        System.out.print("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회) ");

        if (input.readLine().equalsIgnoreCase("inquiry")) {
            arithmeticCalculator.printList();
        }

        System.out.print("저장된 연산결과 중 보다 큰 값을 조회하시겠습니까? (bigger 입력 시 조회) ");

        if (input.readLine().equalsIgnoreCase("bigger")) {
            System.out.print(">> ");
            arithmeticCalculator.printBiggerListThan(input.readDouble());
            input.readLine();
        }

        System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) ");

        return input.readLine().equals("exit");
    }
}
