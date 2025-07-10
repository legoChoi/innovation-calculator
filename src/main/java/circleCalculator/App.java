package circleCalculator;

import circleCalculator.config.AppConfig;

public class App {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        appConfig.mainDispatcher().dispatch();

        appConfig.exit();
    }
}
