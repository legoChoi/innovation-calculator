package circleCalculator.command;

import circleCalculator.State;
import circleCalculator.exception.CalculatorException;
import circleCalculator.exception.CustomRuntimeException;

import java.util.Arrays;

public enum CalculatorMenuCommand {

    NORMAL("normal", "1", State.ARITHEMETIC_CALCULATOR_PROCESS),
    CIRCLE("circle", "2", State.CIRCLE_CALCULATOR_PROCESS),
    BACK("back", "3", State.MAIN_MENU),
    ;

    private final String command;
    private final String index;
    private final State state;

    CalculatorMenuCommand(String command, String index, State state) {
        this.command = command;
        this.index = index;
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public static void print() {
        System.out.println();
        Arrays.stream(values())
                .forEach(c -> System.out.println("[" + c.index + "] " + c.command));

        System.out.print("어떤 작업을 실행하시겠습니까? (번호나 명령어 입력) >> ");
    }

    public static CalculatorMenuCommand findByIndexOrCommand(String commandInput) {
        return Arrays.stream(values())
                .filter(e -> e.command.equalsIgnoreCase(commandInput) || e.index.equals(commandInput))
                .findAny()
                .orElseThrow(() -> new CustomRuntimeException(CalculatorException.NOT_SUPPORTED_COMMAND));
    }
}
