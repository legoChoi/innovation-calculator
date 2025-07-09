package circleCalculator.exception;

import java.util.ArrayList;
import java.util.List;

public class ExceptionLogRepository {

    private final List<ExceptionLog> memory;

    public ExceptionLogRepository() {
        this.memory = new ArrayList<>();
    }

    public void save(ExceptionLog log) {
        memory.add(log);
    }

    public List<ExceptionLog> getAll() {
        return memory;
    }

    public void deleteAll() {
        memory.clear();
    }
}
