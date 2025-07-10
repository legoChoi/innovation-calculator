package circleCalculator.dispatcher;

import circleCalculator.LevelFlag;
import circleCalculator.controller.Controller;
import circleCalculator.exception.CustomRuntimeException;
import circleCalculator.exception.ExceptionLogService;
import circleCalculator.handler.Handler;

public class Dispatcher {

    private final ExceptionLogService exceptionLogService;
    private final Handler mainHandler;

    private LevelFlag levelFlag = LevelFlag.MAIN_MENU;

    public Dispatcher(ExceptionLogService exceptionLogService, Handler mainHandler) {
        this.exceptionLogService = exceptionLogService;
        this.mainHandler = mainHandler;
    }

    /**
     * 각 단계마다 반복과 예외 처리 진행
     */
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
