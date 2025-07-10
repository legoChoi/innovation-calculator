package circleCalculator;

import circleCalculator.dispatcher.Dispatcher;

public class AppRunner {

    private final Dispatcher dispatcher;

    public AppRunner(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void run() {
        dispatcher.dispatch();
    }
}
