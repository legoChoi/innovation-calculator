package circleCalculator.handler;

import circleCalculator.controller.Controller;
import circleCalculator.controller.response.ControllerResponse;

public class ControllerHandlerAdapter implements HandlerAdapter {

    @Override
    public ControllerResponse handle(Controller controller) {
        return controller.handle();
    }
}
