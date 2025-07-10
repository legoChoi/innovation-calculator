package circleCalculator.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ExceptionLogService {

    private final ExceptionLogRepository exceptionLogRepository;

    public ExceptionLogService(ExceptionLogRepository exceptionLogRepository) {
        this.exceptionLogRepository = exceptionLogRepository;
    }

    public void saveLog(String level, String message) {
        ExceptionLog log = new ExceptionLog(LocalDateTime.now(), level, message);
        exceptionLogRepository.save(log);
        System.out.println();
        System.out.println("[ERROR] " + log.toString());
    }

    public void printLogList() {
        List<ExceptionLog> memory = exceptionLogRepository.getAll();
        System.out.println();

        if (!memory.isEmpty()) {
            memory.forEach(log -> System.out.println(log.toString()));
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
