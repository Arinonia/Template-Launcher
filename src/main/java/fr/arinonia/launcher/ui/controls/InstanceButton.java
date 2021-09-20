package fr.arinonia.launcher.ui.controls;

import fr.arinonia.launcher.ui.panel.IPanel;
import fr.arinonia.launcher.ui.panels.home.HomePanel;
import fr.arinonia.launcher.utils.Constants;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.List;

/**
 * @author Arinonia
 * @date 20/09/2021
 **/
public class InstanceButton extends GridPane {

    private final Rectangle rectangle = new Rectangle();
    private boolean enable = true;

    public InstanceButton(final String text, final String version, final Image icon, boolean isCurrent) {
        GridPane.setVgrow(this, Priority.ALWAYS);
        GridPane.setHgrow(this, Priority.ALWAYS);
        this.setMinSize(320, 45);
        this.setMaxSize(320, 45);
        this.setCursor(Cursor.HAND);
        this.setup(text, version, icon);

        if (isCurrent) {
            this.setStyle("-fx-background-color: #31313D");
            this.rectangle.setFill(Color.web("#09ABF4"));
        } else {
            this.rectangle.setFill(Color.web("#00000000"));
        }
    }

    public InstanceButton(final String text, final String version, final Image icon) {
        this(text, version, icon,false);
    }


    private void setup(String text, String version, Image icon) {
        final Label label = new Label(text);
        GridPane.setVgrow(label, Priority.ALWAYS);
        GridPane.setHgrow(label, Priority.ALWAYS);
        GridPane.setValignment(label, VPos.CENTER);
        GridPane.setHalignment(label, HPos.LEFT);
        label.setTranslateY(-10.0D);
        label.setTranslateX(55.0D);
        label.setFont(Constants.getCascadiaMono(16));
        label.setStyle("-fx-text-fill: #fff;");
        this.getChildren().add(label);

        final Label versionLabel = new Label(version);
        GridPane.setVgrow(versionLabel, Priority.ALWAYS);
        GridPane.setHgrow(versionLabel, Priority.ALWAYS);
        GridPane.setValignment(versionLabel, VPos.CENTER);
        GridPane.setHalignment(versionLabel, HPos.LEFT);
        versionLabel.setTranslateY(10.0D);
        versionLabel.setTranslateX(55.0D);
        versionLabel.setFont(Constants.getCascadiaMono(16));
        versionLabel.setStyle("-fx-text-fill: #fff;");
        this.getChildren().add(versionLabel);


        final Circle circle = new Circle(20, 20, 20);
        GridPane.setVgrow(circle, Priority.ALWAYS);
        GridPane.setHgrow(circle, Priority.ALWAYS);
        GridPane.setHalignment(circle, HPos.LEFT);
        GridPane.setValignment(circle, VPos.CENTER);
        circle.setFill(new ImagePattern(icon));
        circle.setTranslateX(10.0D);
        this.getChildren().add(circle);

        GridPane.setVgrow(this.rectangle, Priority.ALWAYS);
        GridPane.setHgrow(this.rectangle, Priority.ALWAYS);
        GridPane.setHalignment(this.rectangle, HPos.LEFT);
        GridPane.setValignment(this.rectangle, VPos.CENTER);
        this.rectangle.setHeight(45.0D);
        this.rectangle.setWidth(3.0D);
        this.getChildren().add(this.rectangle);
    }

    public void setOnClick(IPanel iPanel, List<InstanceButton> buttons, HomePanel homePanel) {
        this.setOnMouseClicked(e -> {
            if (this.enable) {
                for (InstanceButton instanceButton : buttons) {
                    instanceButton.setStyle("-fx-background-color: rgba(255, 255, 255, 0.00);");
                    instanceButton.rectangle.setFill(Color.web("#00000000"));
                    this.setStyle("-fx-background-color: #31313D");
                    this.rectangle.setFill(Color.web("#09ABF4"));
                    homePanel.getUiManager().showPanel(homePanel.getCenterPanel(), iPanel);
                }
            }
        });
    }


}
