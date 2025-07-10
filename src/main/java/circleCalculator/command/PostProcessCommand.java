package circleCalculator.command;

import circleCalculator.exception.CalculatorException;
import circleCalculator.exception.CustomRuntimeException;

import java.util.Arrays;

public enum PostProcessCommand implements Command {

    REMOVE("remove", "1", "가장 오래된 연산 결과 삭제"),
    INQUIRY("inquiry", "2", "전체 연산 목록 조회"),
    BIGGER("bigger", "3", "연산 결과 중 보다 큰 값 조회"),
    EXIT("exit", "4", "연산 종료"),
    ;

    private final String command;
    private final String index;
    private final String description;

    PostProcessCommand(String command, String index, String description) {
        this.command = command;
        this.index = index;
        this.description = description;
    }

    public static void print() {
        System.out.println();
        Arrays.stream(values())
                .forEach(c -> System.out.println("[" + c.index + "] " + c.command + " - " + c.description));

        System.out.print("어떤 작업을 실행하시겠습니까? (번호나 명령어 입력) >> ");
    }

    public static PostProcessCommand findByIndexOrCommand(String commandInput) {
        return Arrays.stream(values())
                .filter(e -> e.command.equalsIgnoreCase(commandInput) || e.index.equals(commandInput))
                .findAny()
                .orElseThrow(() -> new CustomRuntimeException(CalculatorException.NOT_SUPPORTED_COMMAND));
    }
}
