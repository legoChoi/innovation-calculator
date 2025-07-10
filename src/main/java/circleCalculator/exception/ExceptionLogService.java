package circleCalculator.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ExceptionLogService {

    private final ExceptionLogRepository exceptionLogRepository;

    public ExceptionLogService(ExceptionLogRepository exceptionLogRepository) {
        this.exceptionLogRepository = exceptionLogRepository;
    }

    /**
     * 로그에 발생 시간을 함께 저장
     * @param level 현재 작업 위치
     * @param message 로그 메세지
     */
    public void saveLog(String level, String message) {
        ExceptionLog log = new ExceptionLog(LocalDateTime.now(), level, message);
        exceptionLogRepository.save(log);
        System.out.println();
        System.out.println("[ERROR] " + log.toString());
    }

    /**
     * 로그 리스트 출력
     */
    public void printLogList() {
        List<ExceptionLog> memory = exceptionLogRepository.getAll();
        System.out.println();

        if (!memory.isEmpty()) {
            memory.forEach(log -> System.out.println(log.toString()));
            return;
        }

        System.out.println("empty");
    }

    /**
     * 로그 리스트 비우기
     */
    public void clearLogList() {
        exceptionLogRepository.deleteAll();
        System.out.println();
        System.out.println("cleared");
    }
}
