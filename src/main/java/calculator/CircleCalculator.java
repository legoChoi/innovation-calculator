package calculator;

import java.util.ArrayList;
import java.util.List;

public class CircleCalculator<T extends Number> extends Calculator {

    private T radius;

    private final Class<T> type;
    private final List<T> db;

    public CircleCalculator(Class<T> type) {
        this.type = type;
        this.db = new ArrayList<>();
    }

    public void setValues(T radius) {
        this.radius = radius;
    }

    @Override
    public T calculate() {
        double target = Math.PI * radius.doubleValue() * radius.doubleValue();
        return NumberTypeConverter.convertTo(target, type);
    }

    @Override
    public void saveResult(Number result) {
        T target = NumberTypeConverter.convertTo(result, type);
        this.db.add(target);
    }


    @Override
    public void removeFirst(String type) {
        db.remove(0);
    }

    @Override
    public void printList() {
        db.forEach(num -> {
            System.out.print(num + " ");
        });

        System.out.println();
    }

    @Override
    public void printBiggerListThan(Number target) {
        db.forEach(num -> {
            if (num.doubleValue() > target.doubleValue()) {
                System.out.print(num + " ");
            }
        });

        System.out.println();
    }
}
