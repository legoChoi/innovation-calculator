package circleCalculator.calculator.controller;

import circleCalculator.calculator.CircleCalculator;
import circleCalculator.exception.CalculatorException;
import circleCalculator.exception.CustomRuntimeException;
import circleCalculator.exception.ExceptionLogService;
import circleCalculator.util.Input;

import java.util.InputMismatchException;

public class CircleCalculatorController implements CalculatorController {

    private final Input input;
    private final ExceptionLogService exceptionLogService;
    private final CircleCalculator<Double> circleCalculator;

    public CircleCalculatorController(Input input, ExceptionLogService exceptionLogService, CircleCalculator<Double> circleCalculator) {
        this.input = input;
        this.exceptionLogService = exceptionLogService;
        this.circleCalculator = circleCalculator;
    }

    @Override
    public void run() {
        Double result;

        while (true) {
            try {
                System.out.print("반지름을 입력하세요: ");
                double radius = input.readDouble();

                circleCalculator.setValues(radius);

                result = circleCalculator.calculate();
                System.out.println(">>" + result);

                circleCalculator.saveResult(result);

                input.readLine();

                break;
            } catch (CustomRuntimeException | InputMismatchException e) {
                input.readLine();
                throw new CustomRuntimeException(CalculatorException.INVALID_INPUT);
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
            circleCalculator.removeFirst();
        }

        System.out.print("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회) ");

        if (input.readLine().equalsIgnoreCase("inquiry")) {
            circleCalculator.printList();
        }

        System.out.print("저장된 연산결과 중 보다 큰 값을 조회하시겠습니까? (bigger 입력 시 조회) ");

        if (input.readLine().equalsIgnoreCase("bigger")) {
            System.out.print(">> ");
            circleCalculator.printBiggerListThan(input.readDouble());
            input.readLine();
        }

        System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) ");

        return input.readLine().equals("exit");
    }
}
