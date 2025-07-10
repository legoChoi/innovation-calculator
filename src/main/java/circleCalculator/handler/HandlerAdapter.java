package circleCalculator.handler;

import circleCalculator.LevelFlag;
import circleCalculator.controller.Controller;

public interface HandlerAdapter {

    /**
     * 전달받은 Handler 실행
     *
     * @param controller 현재는 단일 핸들러(Controller)만 존재
     * @return 다음 진행 LevelFlag 값
     */
    LevelFlag handle(Controller controller);
}
