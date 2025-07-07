package calculator;

import java.util.ArrayList;
import java.util.List;

public class CircleCalculator extends Calculator {

    private double radius;

    private final List<Double> db;

    public CircleCalculator() {
        this.db = new ArrayList<>();
    }

    public void setValues(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculate() {
        return Math.PI * radius * radius;
    }

    @Override
    public void saveResult(double result) {
        db.add(result);
    }

    @Override
    public void removeFirst(String type) {
        db.remove(0);
    }

    @Override
    public void printList() {
        for (double i : db) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
