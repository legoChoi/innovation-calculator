package circleCalculator.controller;

import circleCalculator.LevelFlag;
import circleCalculator.calculator.Calculator;
import circleCalculator.command.PostProcessCommand;
import circleCalculator.util.Input;

public abstract class AbstractCalculatorPostProcessController implements Controller {

    protected final Input input;
    protected final Calculator<Double> calculator;

    protected AbstractCalculatorPostProcessController(Input input, Calculator<Double> calculator) {
        this.input = input;
        this.calculator = calculator;
    }

    protected abstract LevelFlag getCurrentPostProcessLevelFlag();

    @Override
    public LevelFlag run() {
        PostProcessCommand.print();
        PostProcessCommand postProcessCommand = PostProcessCommand.findByIndexOrCommand(input.readLine());

        switch (postProcessCommand) {
            case REMOVE -> calculator.removeFirst();
            case INQUIRY -> calculator.printList();
            case BIGGER -> {
                System.out.print(">> ");
                calculator.printBiggerListThan(input.readDouble());
                input.readLine();
            }
            case EXIT -> {
                return LevelFlag.CALCULATOR_MENU;
            }
        }

        return getCurrentPostProcessLevelFlag();
    }
}
