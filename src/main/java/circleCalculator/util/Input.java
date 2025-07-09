package circleCalculator.util;

import circleCalculator.exception.CalculatorException;
import circleCalculator.exception.CustomRuntimeException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    private final Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public double readDouble() {
        try {
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw new CustomRuntimeException(CalculatorException.INVALID_INPUT);
        }
    }

    public char readChar() {
        return scanner.next().charAt(0);
    }
}
