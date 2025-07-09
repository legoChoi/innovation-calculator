package circleCalculator.handler;

public interface Handler<T, C> {

    T get(C command);
}
