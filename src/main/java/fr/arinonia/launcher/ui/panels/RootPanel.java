package fr.arinonia.launcher.ui.panels;

import com.azuriom.azauth.model.User;
import fr.arinonia.launcher.ui.UiManager;
import fr.arinonia.launcher.ui.include.TopPanel;
import fr.arinonia.launcher.ui.panel.Panel;
import fr.arinonia.launcher.ui.panels.home.HomePanel;
import fr.arinonia.launcher.ui.panels.login.LoginPanel;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

/**
 * @author Arinonia
 * @date 20/09/2021
 **/
public class RootPanel extends Panel {

    private final User user;

    public RootPanel(UiManager uiManager, User user) {
        super(uiManager);
        this.user = user;
        this.postInit();
    }

    @Override
    public void initPanel() {
        final RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setValignment(VPos.TOP);
        rowConstraints.setMinHeight(30.0D);
        rowConstraints.setMaxHeight(30.0D);

        this.layout.getRowConstraints().addAll(rowConstraints, new RowConstraints());
        final TopPanel topPanel = new TopPanel(uiManager);
        this.layout.add(topPanel.getLayout(), 0, 0);
    }

    public void postInit() {
        if (this.user == null) {
            final LoginPanel loginPanel = new LoginPanel(uiManager);
            this.layout.add(loginPanel.getLayout(), 0, 1);
            GridPane.setHgrow(loginPanel.getLayout(), Priority.ALWAYS);
            GridPane.setVgrow(loginPanel.getLayout(), Priority.ALWAYS);
        } else {
            final HomePanel homePanel = new HomePanel(uiManager, user);
            this.layout.add(homePanel.getLayout(), 0, 1);
            GridPane.setHgrow(homePanel.getLayout(), Priority.ALWAYS);
            GridPane.setVgrow(homePanel.getLayout(), Priority.ALWAYS);
        }
    }
}
