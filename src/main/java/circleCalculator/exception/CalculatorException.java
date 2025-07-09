package circleCalculator.exception;

public enum CalculatorException {

    INVALID_INPUT("잘못된 입력입니다."),
    DIVIDE_BY_ZERO("0으로 나눌 수 없습니다."),
    NOT_SUPPORTED_OPERATOR("지원하지않는 연산자입니다."),
    NOT_SUPPORTED_TYPE("지원하지않는 숫자 타입입니다."),
    NOT_SUPPORTED_COMMAND("지원하지 않는 명령어입니다."),
    ;

    private final String message;

    CalculatorException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
