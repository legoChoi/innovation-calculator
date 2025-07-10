package circleCalculator;

import circleCalculator.config.AppConfig;

public class App {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        AppRunner appRunner = appConfig.AppRunner();
        appRunner.run();
        appConfig.exit();
    }
}
