package circleCalculator.exception;

import java.time.LocalDateTime;

public record ExceptionLog(
        LocalDateTime time,
        String level,
        String message
) {

    @Override
    public String toString() {
        return "[" + time + "]" + level + " " + message;
    }
}
