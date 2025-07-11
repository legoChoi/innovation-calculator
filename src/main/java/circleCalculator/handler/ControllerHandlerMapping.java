package circleCalculator.handler;

import circleCalculator.State;
import circleCalculator.controller.Controller;

import java.util.HashMap;
import java.util.Map;

public class ControllerHandlerMapping implements HandlerMapping {

    private final Controller mainMenuController;
    private final Controller calculatorMenuController;
    private final Controller logMenuController;
    private final Controller arithmeticCalculatorController;
    private final Controller arithmeticCalculatorPostProcessController;
    private final Controller circleCalculatorPostProcessController;
    private final Controller circleCalculatorController;

    private final Map<State, Controller> controllerMap = new HashMap<>();

    public ControllerHandlerMapping(Controller mainMenuController, Controller calculatorMenuController, Controller logMenuController, Controller arithmeticCalculatorController, Controller arithmeticCalculatorPostProcessController, Controller circleCalculatorController, Controller circleCalculatorPostProcessController) {
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
        controllerMap.put(State.MAIN_MENU, mainMenuController);
        controllerMap.put(State.CALCULATOR_MENU, calculatorMenuController);
        controllerMap.put(State.LOG_MENU, logMenuController);
        controllerMap.put(State.ARITHEMETIC_CALCULATOR_PROCESS, arithmeticCalculatorController);
        controllerMap.put(State.ARITHEMETIC_CALCULATOR_POST_PROCESS, arithmeticCalculatorPostProcessController);
        controllerMap.put(State.CIRCLE_CALCULATOR_PROCESS, circleCalculatorController);
        controllerMap.put(State.CIRCLE_CALCULATOR_POST_PROCESS, circleCalculatorPostProcessController);
        controllerMap.put(State.EXIT, null);
    }

    @Override
    public Controller getHandler(State state) {
        return controllerMap.get(state);
    }
}
