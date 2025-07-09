package circleCalculator.config;

import circleCalculator.calculator.controller.ArithmeticCalculatorController;
import circleCalculator.calculator.ArithmeticCalculator;
import circleCalculator.calculator.controller.CircleCalculatorController;
import circleCalculator.calculator.CircleCalculator;
import circleCalculator.calculator.operator.*;
import circleCalculator.dispatcher.CalculatorControllerDispatcher;
import circleCalculator.dispatcher.MenuDispatcher;
import circleCalculator.exception.ExceptionLogRepository;
import circleCalculator.exception.ExceptionLogService;
import circleCalculator.menu.ExceptionLogMenu;
import circleCalculator.handler.CalculatorHandler;
import circleCalculator.handler.MenuHandler;
import circleCalculator.menu.CalculatorMenu;
import circleCalculator.util.Input;

import java.util.Scanner;

public class AppConfig {

    private final Scanner scanner = new Scanner(System.in);
    private final Input input = new Input(scanner);

    private final ExceptionLogRepository exceptionLogRepository = new ExceptionLogRepository();
    private final ExceptionLogService exceptionLogService = new ExceptionLogService(
            exceptionLogRepository
    );
    private final ExceptionLogMenu exceptionLogController = new ExceptionLogMenu(
            input,
            exceptionLogService
    );

    private final AddOperator<Double> addOperator = new AddOperator<>(Double.class);
    private final SubtractOperator<Double> subtractOperator = new SubtractOperator<>(Double.class);
    private final MultiplyOperator<Double> multiplyOperator = new MultiplyOperator<>(Double.class);
    private final DivideOperator<Double> divideOperator = new DivideOperator<>(Double.class);
    private final ModOperator<Double> modOperator = new ModOperator<>(Double.class);
    private final ArithmeticCalculator<Double> arithmeticCalculator = new ArithmeticCalculator<>(
            addOperator,
            subtractOperator,
            multiplyOperator,
            divideOperator,
            modOperator,
            Double.class
    );
    private final CircleCalculator<Double> circleCalculator = new CircleCalculator<>(Double.class);

    private final ArithmeticCalculatorController arithmeticCalculationController = new ArithmeticCalculatorController(
            input,
            exceptionLogService,
            arithmeticCalculator
    );
    private final CircleCalculatorController circleCalculationController = new CircleCalculatorController(
            input,
            exceptionLogService,
            circleCalculator
    );
    private final CalculatorHandler calculatorHandler = new CalculatorHandler(
            circleCalculationController,
            arithmeticCalculationController
    );
    private final CalculatorControllerDispatcher calculatorControllerDispatcher = new CalculatorControllerDispatcher(
            exceptionLogService,
            calculatorHandler,
            input
    );

    private final CalculatorMenu calculatorController = new CalculatorMenu(
            calculatorControllerDispatcher
    );
    private final MenuHandler menuHandler = new MenuHandler(calculatorController, exceptionLogController);
    private final MenuDispatcher menuDispatcher = new MenuDispatcher(
            input,
            exceptionLogService,
            menuHandler
    );

    public MenuDispatcher controllerDispatcher() {
        return menuDispatcher;
    }

    public void exit() {
        scanner.close();
    }
}
