package circleCalculator.controller;

import circleCalculator.calculator.CircleCalculator;
import circleCalculator.calculator.LevelFlag;
import circleCalculator.command.PostProcessCommand;
import circleCalculator.util.Input;

public class CircleCalculatorPostProcessController implements Controller {

    private final Input input;
    private final CircleCalculator<Double> circleCalculator;

    public CircleCalculatorPostProcessController(Input input, CircleCalculator<Double> circleCalculator) {
        this.input = input;
        this.circleCalculator = circleCalculator;
    }

    @Override
    public LevelFlag run() {
        PostProcessCommand.print();
        PostProcessCommand postProcessCommand = PostProcessCommand.findByIndexOrCommand(input.readLine());

        switch (postProcessCommand) {
            case REMOVE -> circleCalculator.removeFirst();
            case INQUIRY -> circleCalculator.printList();
            case BIGGER -> {
                System.out.print(">> ");
                circleCalculator.printBiggerListThan(input.readDouble());
                input.readLine();
            }
            case EXIT -> {
                return LevelFlag.CALCULATOR_MENU;
            }
        }

        return LevelFlag.CIRCLE_CALCULATOR_POST_PROCESS;
    }
}
