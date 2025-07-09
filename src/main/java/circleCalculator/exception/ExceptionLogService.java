package circleCalculator.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ExceptionLogService {

    private final ExceptionLogRepository exceptionLogRepository;

    public ExceptionLogService(ExceptionLogRepository exceptionLogRepository) {
        this.exceptionLogRepository = exceptionLogRepository;
    }

    public void saveLog(String message) {
        exceptionLogRepository.save(new ExceptionLog(LocalDateTime.now(), message));
        System.out.println();
        System.out.println("[ERROR] " + message);
    }

    public void printLogList() {
        List<ExceptionLog> memory = exceptionLogRepository.getAll();
        System.out.println();

        if (!memory.isEmpty()) {
            memory.forEach(log -> System.out.println("[" + log.time() + "] " + log.message()));
            return;
        }

        System.out.println("empty");
    }

    public void clearLogList() {
        exceptionLogRepository.deleteAll();
        System.out.println();
        System.out.println("cleared");
    }
}
