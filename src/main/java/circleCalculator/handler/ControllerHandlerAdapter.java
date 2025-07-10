package circleCalculator.handler;

import circleCalculator.LevelFlag;
import circleCalculator.controller.Controller;

public class ControllerHandlerAdapter implements HandlerAdapter {

    @Override
    public LevelFlag handle(Controller controller) {
        return controller.handle();
    }
}
