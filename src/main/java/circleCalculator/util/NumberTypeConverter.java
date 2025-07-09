package circleCalculator.util;

import circleCalculator.exception.CalculatorException;
import circleCalculator.exception.CustomRuntimeException;

public class NumberTypeConverter {

    public static <T extends Number> T convertTo(Number target, Class<T> type) {
        if (type.equals(Integer.class)) {
            return (T) Integer.valueOf(target.intValue());
        }

        if (type.equals(Double.class)) {
            return (T) Double.valueOf(target.doubleValue());
        }

        throw new CustomRuntimeException(CalculatorException.NOT_SUPPORTED_TYPE);
    }
}
