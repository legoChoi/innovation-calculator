package circleCalculator.calculator;

import circleCalculator.util.NumberTypeConverter;

import java.util.ArrayList;
import java.util.List;

public class CircleCalculator<T extends Number> extends Calculator<T> {

    private T radius;

    private final Class<T> type;
    private final List<T> memory;

    public CircleCalculator(Class<T> type) {
        this.type = type;
        this.memory = new ArrayList<>();
    }

    public void setValues(T radius) {
        this.radius = radius;
    }

    @Override
    public T calculate() {
        double target = Math.PI * this.radius.doubleValue() * this.radius.doubleValue();
        return NumberTypeConverter.convertTo(target, this.type);
    }

    @Override
    public void saveResult(Number result) {
        T target = NumberTypeConverter.convertTo(result, this.type);
        this.memory.add(target);
    }

    @Override
    public void removeFirst() {
        if (!this.memory.isEmpty()) {
            this.memory.remove(0);
        }
    }

    @Override
    public void printList() {
        System.out.print(">> ");

        this.memory.forEach(num -> System.out.print(num + " "));

        System.out.println();
    }

    @Override
    public void printBiggerListThan(Number target) {
        System.out.print(">> ");

        this.memory.stream()
                .filter(num -> num.doubleValue() > target.doubleValue())
                .forEach(num -> System.out.print(num + " "));

        System.out.println();
    }
}
