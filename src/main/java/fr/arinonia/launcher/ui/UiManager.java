package fr.arinonia.launcher.ui;

import fr.arinonia.launcher.Launcher;
import fr.arinonia.launcher.Main;
import fr.arinonia.launcher.ui.panel.IPanel;
import fr.arinonia.launcher.utils.Constants;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author Arinonia
 * @date 19/09/2021
 **/
public class UiManager {

    private final Launcher launcher;

    private Stage stage;
    private GridPane layout;

    public UiManager(Launcher launcher) {
        this.launcher = launcher;
    }

    //TODO Create custom stage for resize frame.
    public void createFrame(final Stage stage) {
        this.stage = stage;
        this.stage.setTitle(Constants.LAUNCHER_NAME);
        this.stage.setMinWidth(Constants.LAUNCHER_WIDTH);
        this.stage.setWidth(Constants.LAUNCHER_WIDTH);
        this.stage.setMinHeight(Constants.LAUNCHER_HEIGHT);
        this.stage.setHeight(Constants.LAUNCHER_HEIGHT);

        this.stage.initStyle(StageStyle.UNDECORATED);
        this.stage.getIcons().add(new Image(Main.class.getResource("/images/icon.png").toExternalForm()));
        this.stage.centerOnScreen();
        this.stage.setOnCloseRequest(e -> System.exit(0));
        this.stage.setScene(new Scene(this.layout = new GridPane()));

        this.stage.show();
    }

    public void showPanel(final GridPane layout, final IPanel panel) {
        layout.getChildren().clear();
        layout.getChildren().remove(panel.getLayout());
        layout.getChildren().add(panel.getLayout());
    }

    public GridPane getLayout() {
        return this.layout;
    }

    public Stage getStage() {
        return this.stage;
    }

    public Launcher getLauncher() {
        return this.launcher;
    }
}
