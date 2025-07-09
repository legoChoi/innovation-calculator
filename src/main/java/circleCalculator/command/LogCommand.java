package circleCalculator.command;

import circleCalculator.exception.CalculatorException;
import circleCalculator.exception.CustomRuntimeException;

import java.util.Arrays;

public enum LogCommand {
    PRINT("print", "1"),
    CLEAR("clear", "2");

    private final String command;
    private final String index;

    LogCommand(String command, String index) {
        this.command = command;
        this.index = index;
    }

    public static void print() {
        System.out.println();
        Arrays.stream(values())
                .forEach(c -> System.out.println("[" + c.index + "] " + c.command));

        System.out.print("어떤 작업을 실행하시겠습니까? (번호나 명령어 입력) >> ");
    }

    public static LogCommand findByIndexOrCommand(String commandInput) {
        return Arrays.stream(values())
                .filter(e -> e.command.equalsIgnoreCase(commandInput) || e.index.equals(commandInput))
                .findAny()
                .orElseThrow(() -> new CustomRuntimeException(CalculatorException.NOT_SUPPORTED_COMMAND));
    }
}
