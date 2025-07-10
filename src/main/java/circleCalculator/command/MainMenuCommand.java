package circleCalculator.command;

import circleCalculator.LevelFlag;
import circleCalculator.exception.CalculatorException;
import circleCalculator.exception.CustomRuntimeException;

import java.util.Arrays;

public enum MainMenuCommand {

    CALCULATION("calculation", "1", LevelFlag.CALCULATOR_MENU),
    LOG("log", "2", LevelFlag.LOG_MENU),
    EXIT("exit", "3", null),
    ;

    private final String command;
    private final String index;
    private final LevelFlag levelFlag;

    MainMenuCommand(String command, String index, LevelFlag levelFlag) {
        this.command = command;
        this.index = index;
        this.levelFlag = levelFlag;
    }

    public LevelFlag getLevelFlag() {
        return levelFlag;
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
