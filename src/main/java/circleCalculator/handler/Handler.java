package circleCalculator.handler;

import circleCalculator.controller.response.ControllerResponse;

public interface Handler {

    /**
     * Handler 실행
     * @return ControllerResponse
     */
    ControllerResponse handle();
}
