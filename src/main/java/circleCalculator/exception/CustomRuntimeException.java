package circleCalculator.exception;

public class CustomRuntimeException extends RuntimeException {

    public CustomRuntimeException(CalculatorException e) {
        super(e.getMessage());
    }
}
