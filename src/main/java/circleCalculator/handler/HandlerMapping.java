package circleCalculator.handler;

import circleCalculator.State;
import circleCalculator.controller.Controller;

public interface HandlerMapping {

    /**
     * levelFlag를 입력받아 해당하는 Controller 반환
     *
     * @param state
     * @return
     */
    Controller getHandler(State state);
}
