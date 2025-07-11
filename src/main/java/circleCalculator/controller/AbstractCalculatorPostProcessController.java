package circleCalculator.controller;

import circleCalculator.State;
import circleCalculator.calculator.Calculator;
import circleCalculator.command.PostProcessMenuCommand;
import circleCalculator.util.Input;

public abstract class AbstractCalculatorPostProcessController implements Controller {

    protected final Input input;
    protected final Calculator<Double> calculator;

    protected AbstractCalculatorPostProcessController(Input input, Calculator<Double> calculator) {
        this.input = input;
        this.calculator = calculator;
    }

    /**
     * 루프 중 예외가 발생 할 경우 현재 작업 다시 시작하기 위한 메소드
     * @return 현재 작업 위치에 해당하는 LevelFlag 값 반환
     */
    protected abstract State getCurrentPostProcessLevelFlag();

    @Override
    public State run() {
        PostProcessMenuCommand.print();
        PostProcessMenuCommand command = PostProcessMenuCommand.findByIndexOrCommand(input.readLine());

        switch (command) {
            case REMOVE -> calculator.removeFirst();
            case INQUIRY -> calculator.printList();
            case BIGGER -> {
                System.out.print(">> ");
                calculator.printBiggerListThan(input.readDouble());
                input.readLine();
            }
            case EXIT -> {
                return State.CALCULATOR_MENU;
            }
        }

        return getCurrentPostProcessLevelFlag();
    }
}
