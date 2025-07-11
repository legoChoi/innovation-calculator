package circleCalculator.handler;

import circleCalculator.controller.Controller;
import circleCalculator.controller.response.ControllerResponse;

public interface HandlerAdapter {

    /**
     * 전달받은 Handler 실행
     * @param controller 현재는 단일 핸들러(Controller)만 존재
     * @return ControllerResponse
     */
    ControllerResponse handle(Controller controller);
}
