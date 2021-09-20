package fr.arinonia.launcher.ui.panel;

import fr.arinonia.launcher.ui.UiManager;
import javafx.scene.layout.GridPane;

/**
 * @author Arinonia
 * @date 19/09/2021
 **/
public interface IPanel {
    GridPane getLayout();
    UiManager getUiManager();
}
