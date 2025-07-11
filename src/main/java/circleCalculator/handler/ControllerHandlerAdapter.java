package circleCalculator.handler;

import circleCalculator.State;
import circleCalculator.controller.Controller;

public class ControllerHandlerAdapter implements HandlerAdapter {

    @Override
    public State handle(Controller controller) {
        return controller.handle();
    }
}
