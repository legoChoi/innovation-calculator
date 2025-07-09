package circleCalculator.exception;

import java.time.LocalDateTime;

public record ExceptionLog(
        LocalDateTime time,
        String message
) {

    @Override
    public String toString() {
        return " [ " + time + " ] | " + message;
    }
}
