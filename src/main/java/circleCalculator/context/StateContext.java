package circleCalculator.context;

import circleCalculator.State;

public class StateContext {

    private State state = State.MAIN_MENU;

    public State getCurrentState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
