package circleCalculator.controller;

import circleCalculator.calculator.ArithmeticCalculator;
import circleCalculator.calculator.LevelFlag;
import circleCalculator.command.PostProcessCommand;
import circleCalculator.util.Input;

public class ArithmeticCalculatorPostProcessController implements Controller {

    private final Input input;
    private final ArithmeticCalculator<Double> arithmeticCalculator;

    public ArithmeticCalculatorPostProcessController(Input input, ArithmeticCalculator<Double> arithmeticCalculator) {
        this.input = input;
        this.arithmeticCalculator = arithmeticCalculator;
    }

    @Override
    public LevelFlag run() {
        PostProcessCommand.print();
        PostProcessCommand postProcessCommand = PostProcessCommand.findByIndexOrCommand(input.readLine());

        switch (postProcessCommand) {
            case REMOVE -> arithmeticCalculator.removeFirst();
            case INQUIRY -> arithmeticCalculator.printList();
            case BIGGER -> {
                System.out.print(">> ");
                arithmeticCalculator.printBiggerListThan(input.readDouble());
                input.readLine();
            }
            case EXIT -> {
                return LevelFlag.CALCULATOR_MENU;
            }
        }

        return LevelFlag.ARITHEMETIC_CALCULATOR_POST_PROCESS;
    }
}
