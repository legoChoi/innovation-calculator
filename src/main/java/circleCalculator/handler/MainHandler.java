package circleCalculator.handler;

import circleCalculator.calculator.LevelFlag;
import circleCalculator.controller.Controller;

import java.util.HashMap;
import java.util.Map;

public class MainHandler implements Handler<Controller, LevelFlag> {

    private final Controller mainMenuController;
    private final Controller calculatorMenuController;
    private final Controller logMenuController;
    private final Controller arithmeticCalculatorController;
    private final Controller arithmeticCalculatorPostProcessController;
    private final Controller circleCalculatorPostProcessController;
    private final Controller circleCalculatorController;

    private final Map<LevelFlag, Controller> controllerMap = new HashMap<>();

    public MainHandler(Controller mainMenuController, Controller calculatorMenuController, Controller logMenuController, Controller arithmeticCalculatorController, Controller arithmeticCalculatorPostProcessController, Controller circleCalculatorController, Controller circleCalculatorPostProcessController) {
        this.mainMenuController = mainMenuController;
        this.calculatorMenuController = calculatorMenuController;
        this.logMenuController = logMenuController;
        this.arithmeticCalculatorController = arithmeticCalculatorController;
        this.arithmeticCalculatorPostProcessController = arithmeticCalculatorPostProcessController;
        this.circleCalculatorController = circleCalculatorController;
        this.circleCalculatorPostProcessController = circleCalculatorPostProcessController;

        init();
    }

    private void init() {
        controllerMap.put(LevelFlag.MAIN_MENU, mainMenuController);
        controllerMap.put(LevelFlag.CALCULATOR_MENU, calculatorMenuController);
        controllerMap.put(LevelFlag.LOG_MENU, logMenuController);
        controllerMap.put(LevelFlag.ARITHEMETIC_CALCULATOR_PROCESS, arithmeticCalculatorController);
        controllerMap.put(LevelFlag.ARITHEMETIC_CALCULATOR_POST_PROCESS, arithmeticCalculatorPostProcessController);
        controllerMap.put(LevelFlag.CIRCLE_CALCULATOR_PROCESS, circleCalculatorController);
        controllerMap.put(LevelFlag.CIRCLE_CALCULATOR_POST_PROCESS, circleCalculatorPostProcessController);
        controllerMap.put(LevelFlag.EXIT, null);
    }

    @Override
    public Controller get(LevelFlag command) {
        return controllerMap.get(command);
    }
}
