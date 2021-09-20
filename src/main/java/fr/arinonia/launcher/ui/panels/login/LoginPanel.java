package fr.arinonia.launcher.ui.panels.login;

import fr.arinonia.launcher.Main;
import fr.arinonia.launcher.ui.UiManager;
import fr.arinonia.launcher.ui.panel.Panel;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;

/**
 * @author Arinonia
 * @date 19/09/2021
 **/
public class LoginPanel extends Panel {

    public LoginPanel(final UiManager uiManager) {
        super(uiManager);
    }

    @Override
    public void initPanel() {
        final RightLoginPanel rightPanel = new RightLoginPanel(uiManager);
        this.layout.setStyle("-fx-background-image: url('"+ Main.class.getResource("/images/background.jpg") + "'); -fx-backgound-repeat: skretch; -fx-backgound-position: center center; -fx-background-size: cover;");

        GridPane mask = new GridPane();
        GridPane.setHgrow(mask, Priority.ALWAYS);
        GridPane.setVgrow(mask, Priority.ALWAYS);
        mask.setStyle("-fx-background-color: linear-gradient(to bottom, #202029AF, #202029FF);");
        this.layout.getChildren().add(mask);

        GridPane background = new GridPane();
        GridPane.setVgrow(background, Priority.ALWAYS);
        GridPane.setHgrow(background, Priority.ALWAYS);
        GridPane.setHalignment(background, HPos.CENTER);
        GridPane.setValignment(background, VPos.CENTER);
        background.setMaxSize(700, 400);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.rgb(21, 21, 21));
        dropShadow.setBlurType(BlurType.THREE_PASS_BOX);
        dropShadow.setWidth(100);
        dropShadow.setHeight(100);
        background.setEffect(dropShadow);
        mask.getChildren().add(background);

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHalignment(HPos.LEFT);
        columnConstraints.setMinWidth(250);
        columnConstraints.setMaxWidth(250);

        background.getColumnConstraints().addAll(columnConstraints, new ColumnConstraints());
        LeftLoginPanel leftPanel = new LeftLoginPanel(this.uiManager);
        background.add(leftPanel.getLayout(),0,  0);

        background.add(rightPanel.getLayout(),1,  0);
        GridPane.setHgrow(rightPanel.getLayout(), Priority.ALWAYS);
        GridPane.setVgrow(rightPanel.getLayout(), Priority.ALWAYS);
    }
}
