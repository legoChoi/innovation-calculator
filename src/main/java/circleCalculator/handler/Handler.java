package circleCalculator.handler;

import circleCalculator.LevelFlag;

public interface Handler {

    /**
     * Handler 실행
     *
     * @return 다음 진행 LevelFlag 값
     */
    LevelFlag handle();
}
