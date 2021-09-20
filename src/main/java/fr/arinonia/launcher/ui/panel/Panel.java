package fr.arinonia.launcher.ui.panel;

import fr.arinonia.launcher.ui.UiManager;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 * @author Arinonia
 * @date 19/09/2021
 **/
public abstract class Panel implements IPanel {

    protected final UiManager uiManager;
    protected final GridPane layout;

    public Panel(final UiManager uiManager) {
        this.uiManager = uiManager;
        this.layout = new GridPane();
        GridPane.setHgrow(this.layout, Priority.ALWAYS);
        GridPane.setVgrow(this.layout, Priority.ALWAYS);

        this.initPanel();
    }

    public abstract void initPanel();

    @Override
    public UiManager getUiManager() {
        return this.uiManager;
    }

    @Override
    public GridPane getLayout() {
        return this.layout;
    }
}
