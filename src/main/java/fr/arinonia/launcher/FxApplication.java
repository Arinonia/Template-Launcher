package fr.arinonia.launcher;

import javafx.application.Application;
import javafx.stage.Stage;
/**
 * @author Arinonia
 * @date 19/09/2021
 **/
public class FxApplication extends Application {
    @Override
    public void start(Stage stage) {
        new Launcher().init(stage);
    }
}
