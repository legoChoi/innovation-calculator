package circleCalculator.dispatcher;

import circleCalculator.LevelFlag;
import circleCalculator.controller.Controller;
import circleCalculator.exception.CustomRuntimeException;
import circleCalculator.exception.ExceptionLogService;
import circleCalculator.handler.HandlerAdapter;
import circleCalculator.handler.HandlerMapping;

public class Dispatcher {

    private final ExceptionLogService exceptionLogService;
    private final HandlerMapping handlerMapping;
    private final HandlerAdapter handlerAdapter;

    private LevelFlag levelFlag = LevelFlag.MAIN_MENU;

    public Dispatcher(ExceptionLogService exceptionLogService, HandlerMapping handlerMapping, HandlerAdapter handlerAdapter) {
        this.exceptionLogService = exceptionLogService;
        this.handlerMapping = handlerMapping;
        this.handlerAdapter = handlerAdapter;
    }

    /**
     * 각 단계마다 반복과 예외 처리 진행
     */
    public void dispatch() {
        while (true) {
            try {
                Controller controller = handlerMapping.getHandler(levelFlag); // handler로 부터 LevelFlag에 해당하는 controller 반환

                if (controller == null) break; // LevelFlag.EXIT

                levelFlag = handlerAdapter.handle(controller); // 작업 실행
            } catch (CustomRuntimeException e) {
                exceptionLogService.saveLog(levelFlag.getTitle(), e.getMessage());
            }
        }
    }
}
