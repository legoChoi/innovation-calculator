package circleCalculator.dispatcher;

import circleCalculator.State;
import circleCalculator.context.StateContext;
import circleCalculator.controller.Controller;
import circleCalculator.exception.CustomRuntimeException;
import circleCalculator.exception.ExceptionLogService;
import circleCalculator.handler.HandlerAdapter;
import circleCalculator.handler.HandlerMapping;

public class Dispatcher {

    private final StateContext stateContext;
    private final HandlerMapping handlerMapping;
    private final HandlerAdapter handlerAdapter;
    private final ExceptionLogService exceptionLogService;

    public Dispatcher(
            StateContext stateContext,
            HandlerMapping handlerMapping,
            HandlerAdapter handlerAdapter,
            ExceptionLogService exceptionLogService
    ) {
        this.stateContext = stateContext;
        this.handlerMapping = handlerMapping;
        this.handlerAdapter = handlerAdapter;
        this.exceptionLogService = exceptionLogService;
    }

    /**
     * 각 단계마다 반복과 예외 처리 진행
     */
    public void dispatch() {
        while (true) {
            try {
                Controller controller = handlerMapping.getHandler(stateContext.getCurrentState()); // handler로 부터 state에 해당하는 controller 반환

                if (controller == null) break; // State.EXIT

                State state = handlerAdapter.handle(controller).state(); // 작업 실행
                stateContext.setState(state);
            } catch (CustomRuntimeException e) {
                exceptionLogService.saveLog(stateContext.getCurrentState().getTitle(), e.getMessage());
            }
        }
    }
}
