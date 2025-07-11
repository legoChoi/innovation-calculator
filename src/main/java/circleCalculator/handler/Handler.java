package circleCalculator.handler;

import circleCalculator.State;

public interface Handler {

    /**
     * Handler 실행
     *
     * @return 다음 진행 LevelFlag 값
     */
    State handle();
}
