package circleCalculator.command;

import circleCalculator.State;
import circleCalculator.exception.CalculatorException;
import circleCalculator.exception.CustomRuntimeException;

import java.util.Arrays;

public enum MainMenuCommand {

    CALCULATION("calculation", "1", State.CALCULATOR_MENU),
    LOG("log", "2", State.LOG_MENU),
    EXIT("exit", "3", null),
    ;

    private final String command;
    private final String index;
    private final State state;

    MainMenuCommand(String command, String index, State state) {
        this.command = command;
        this.index = index;
        this.state = state;
    }

    public State getLevelFlag() {
        return state;
    }

    public static void print() {
        System.out.println();
        Arrays.stream(values())
                .forEach(c -> System.out.println("[" + c.index + "] " + c.command));

        System.out.print("어떤 작업을 실행하시겠습니까? (번호나 명령어 입력) >> ");
    }

    public static MainMenuCommand findByIndexOrCommand(String commandInput) {
        return Arrays.stream(values())
                .filter(e -> e.command.equalsIgnoreCase(commandInput) || e.index.equals(commandInput))
                .findAny()
                .orElseThrow(() -> new CustomRuntimeException(CalculatorException.NOT_SUPPORTED_COMMAND));
    }
}
