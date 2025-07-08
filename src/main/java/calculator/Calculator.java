package calculator;

public abstract class Calculator<T extends Number> {

    public abstract T calculate();

    public abstract void saveResult(T result);

    public abstract void removeFirst(String type);

    public abstract void printList();

    public abstract void printBiggerListThan(T target);
}
