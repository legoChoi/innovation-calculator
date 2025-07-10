package circleCalculator.dispatcher;

import circleCalculator.LevelFlag;
import circleCalculator.controller.Controller;
import circleCalculator.exception.CustomRuntimeException;
import circleCalculator.exception.ExceptionLogService;
import circleCalculator.handler.Handler;

public class MainDispatcher implements Dispatcher {

    private final ExceptionLogService exceptionLogService;
    private final Handler<Controller, LevelFlag> mainHandler;

    private LevelFlag levelFlag;

    public MainDispatcher(ExceptionLogService exceptionLogService, Handler<Controller, LevelFlag> mainHandler) {
        this.exceptionLogService = exceptionLogService;
        this.mainHandler = mainHandler;
        levelFlag = LevelFlag.MAIN_MENU;
    }

    @Override
    public void dispatch() {
        while (true) {
            try {
                Controller controller = mainHandler.get(levelFlag); // handler로 부터 LevelFlag에 해당하는 controller 반환

                if (controller == null) break; // LevelFlag.EXIT

                levelFlag = controller.run();
            } catch (CustomRuntimeException e) {
                exceptionLogService.saveLog(levelFlag.getTitle(), e.getMessage());
            }
        }
    }
}
