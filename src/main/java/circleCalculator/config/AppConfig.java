package circleCalculator.config;

import circleCalculator.AppRunner;
import circleCalculator.calculator.ArithmeticCalculator;
import circleCalculator.calculator.CircleCalculator;
import circleCalculator.calculator.operator.*;
import circleCalculator.controller.*;
import circleCalculator.dispatcher.Dispatcher;
import circleCalculator.exception.ExceptionLogRepository;
import circleCalculator.exception.ExceptionLogService;
import circleCalculator.handler.ControllerHandlerAdapter;
import circleCalculator.handler.ControllerHandlerMapping;
import circleCalculator.handler.HandlerAdapter;
import circleCalculator.handler.HandlerMapping;
import circleCalculator.util.Input;

import java.util.Scanner;

public class AppConfig {

    private final Scanner scanner = new Scanner(System.in);
    private final Input input = new Input(scanner);
    private final ExceptionLogRepository exceptionLogRepository = new ExceptionLogRepository();
    private final ExceptionLogService exceptionLogService = new ExceptionLogService(
            exceptionLogRepository
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

    private final Controller mainMenuController = new MainMenuController(input);
    private final Controller calculatorMenuController = new CalculatorMenuController(input);
    private final Controller logMenuController = new LogMenuController(input, exceptionLogService);
    private final Controller arithmeticCalController = new ArithmeticCalculatorController(input, arithmeticCalculator);
    private final Controller arithmeticCalculatorPostProcessController = new ArithmeticCalculatorPostProcessController(input, arithmeticCalculator);
    private final Controller circleCalculatorPostProcessController = new CircleCalculatorPostProcessController(input, circleCalculator);
    private final Controller circleCalController = new CircleCalculatorController(input, circleCalculator);

    private final HandlerMapping handlerMapping = new ControllerHandlerMapping(
            mainMenuController,
            calculatorMenuController,
            logMenuController,
            arithmeticCalController,
            arithmeticCalculatorPostProcessController,
            circleCalController,
            circleCalculatorPostProcessController
    );

    private final HandlerAdapter handlerAdapter = new ControllerHandlerAdapter() {};

    private final Dispatcher dispatcher = new Dispatcher(
            exceptionLogService,
            handlerMapping,
            handlerAdapter
    );

    private final AppRunner appRunner = new AppRunner(dispatcher);

    public AppRunner AppRunner() {
        return appRunner;
    }

    public void exit() {
        scanner.close();
    }
}
