package circleCalculator;

import circleCalculator.config.AppConfig;
import circleCalculator.dispatcher.MenuDispatcher;

public class App {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

//        MenuDispatcher menuDispatcher = appConfig.controllerDispatcher();
//        menuDispatcher.dispatch();
        appConfig.mainDispatcher().dispatch();

        appConfig.exit();
    }
}
