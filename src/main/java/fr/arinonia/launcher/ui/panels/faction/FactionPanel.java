package fr.arinonia.launcher.ui.panels.faction;

import fr.arinonia.launcher.Main;
import fr.arinonia.launcher.ui.UiManager;
import fr.arinonia.launcher.ui.controls.PanelList;
import fr.arinonia.launcher.ui.panel.Panel;
import fr.arinonia.launcher.ui.panels.home.LeftHomePanel;
import javafx.geometry.VPos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;

/**
 * @author Arinonia
 * @date 20/09/2021
 **/
public class FactionPanel extends Panel {

    public FactionPanel(UiManager uiManager) {
        super(uiManager);
    }

    @Override
    public void initPanel() {
        PanelList panelList = new PanelList();

        GridPane.setHgrow(panelList, Priority.ALWAYS);
        GridPane.setVgrow(panelList, Priority.ALWAYS);
        GridPane.setValignment(panelList, VPos.TOP);
        this.layout.getChildren().add(panelList);

        GridPane topPanel = new GridPane();
        topPanel.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
        topPanel.setPrefHeight(350.0D);

        topPanel.setStyle("-fx-background-image: url('"+ Main.class.getResource("/images/faction_background.jpg") + "'); -fx-backgound-repeat: skretch; -fx-backgound-position: center center; -fx-background-size: cover;");

        GridPane topPanelMask = new GridPane();
        topPanelMask.setStyle("-fx-background-color: linear-gradient(to bottom, #2020299A, #202029FF);");

        GridPane.setHgrow(topPanelMask, Priority.ALWAYS);
        GridPane.setVgrow(topPanelMask, Priority.ALWAYS);
        topPanel.getChildren().add(topPanelMask);
        panelList.add(topPanel);
    }
}
