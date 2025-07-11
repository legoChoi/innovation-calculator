package circleCalculator.controller;

import circleCalculator.State;
import circleCalculator.controller.response.ControllerResponse;
import circleCalculator.handler.Handler;

public interface Controller extends Handler {

    /**
     * 각 단계별 해당하는 작업 진행
     * @return 다음 단계의 Controller 반환을 위한 State 반환
     */
    ControllerResponse run();
}
