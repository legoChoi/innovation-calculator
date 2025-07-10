package circleCalculator.handler;

import circleCalculator.LevelFlag;
import circleCalculator.controller.Controller;

public interface Handler {

    Controller get(LevelFlag levelFlag);
}
