package circleCalculator.controller;

import circleCalculator.LevelFlag;

public interface Controller {

    /**
     * 각 단계별 해당하는 작업 진행
     * @return 다음 단계의 Controller 반환을 위한 LevelFlag 반환
     */
    LevelFlag run();
}
