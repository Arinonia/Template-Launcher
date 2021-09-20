package fr.arinonia.launcher;

import fr.arinonia.launcher.ui.UiManager;
import fr.arinonia.launcher.ui.panels.RootPanel;
import javafx.stage.Stage;
/**
 * @author Arinonia
 * @date 19/09/2021
 **/
public class Launcher {

    private final UiManager uiManager;

    public Launcher() {
        this.uiManager = new UiManager(this);
    }

    public void init(final Stage stage) {
        try {
            this.setup(stage);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private void setup(final Stage stage) {
        this.uiManager.createFrame(stage);
        this.uiManager.showPanel(uiManager.getLayout(), new RootPanel(this.uiManager));

    }

}
