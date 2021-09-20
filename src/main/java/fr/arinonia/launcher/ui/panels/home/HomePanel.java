package fr.arinonia.launcher.ui.panels.home;

import com.azuriom.azauth.model.User;
import fr.arinonia.launcher.Main;
import fr.arinonia.launcher.ui.UiManager;
import fr.arinonia.launcher.ui.panel.Panel;
import fr.arinonia.launcher.ui.panels.faction.FactionPanel;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * @author Arinonia
 * @date 20/09/2021
 **/
public class HomePanel extends Panel {

    private final GridPane centerPanel;


    public HomePanel(final UiManager uiManager, final User user) {
        super(uiManager);
        this.centerPanel = new GridPane();
        GridPane.setHgrow(this.centerPanel, Priority.ALWAYS);
        GridPane.setVgrow(this.centerPanel, Priority.ALWAYS);

        final LeftHomePanel leftPanel =  new LeftHomePanel(this, user);
        leftPanel.getLayout().setBackground(new Background(new BackgroundFill(Color.web("#20202c"), null, null)));

        final GridPane separatorPanel = new GridPane();
        separatorPanel.setBackground(new Background(new BackgroundFill(Color.web("#373742"), null, null)));

        final ColumnConstraints col1 = new ColumnConstraints();
        col1.setPrefWidth(320);
        final ColumnConstraints col2 = new ColumnConstraints();
        col2.setPrefWidth(1);
        final ColumnConstraints col3 = new ColumnConstraints();

        this.layout.getColumnConstraints().addAll(col1, col2, col3);

        this.layout.add(leftPanel.getLayout(), 0, 0);
        this.layout.add(separatorPanel, 1, 0);
        this.layout.add(this.centerPanel, 2, 0);
        uiManager.showPanel(this.centerPanel, new FactionPanel(this.uiManager));
    }

    @Override
    public void initPanel() {

    }

    public GridPane getCenterPanel() {
        return this.centerPanel;
    }
}
