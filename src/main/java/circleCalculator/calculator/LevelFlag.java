package circleCalculator.calculator;

public enum LevelFlag {
    MAIN_MENU("[MAIN_MENU]"),
    CALCULATOR_MENU("[CALCULATOR_MENU]"),
    LOG_MENU("[LOG_MENU]"),
    ARITHEMETIC_CALCULATOR_PROCESS("[ARITHEMETIC_CALCULATOR_PROCESS]"),
    ARITHEMETIC_CALCULATOR_POST_PROCESS("[ARITHEMETIC_CALCULATOR_POST_PROCESS]"),
    CIRCLE_CALCULATOR_PROCESS("[CIRCLE_CALCULATOR_PROCESS]"),
    CIRCLE_CALCULATOR_POST_PROCESS("[CIRCLE_CALCULATOR_POST_PROCESS]"),
    EXIT(""),
    ;

    private final String title;

    LevelFlag(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
