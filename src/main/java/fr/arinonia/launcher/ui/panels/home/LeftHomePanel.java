package fr.arinonia.launcher.ui.panels.home;

import com.azuriom.azauth.model.User;
import fr.arinonia.launcher.ui.UiManager;
import fr.arinonia.launcher.ui.controls.InstanceButton;
import fr.arinonia.launcher.ui.panel.IPanel;
import fr.arinonia.launcher.ui.panel.Panel;
import fr.arinonia.launcher.ui.panels.login.LoginPanel;
import fr.arinonia.launcher.utils.Constants;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arinonia
 * @date 20/09/2021
 **/
public class LeftHomePanel implements IPanel {

    private final GridPane layout;
    private final UiManager uiManager;
    private final List<InstanceButton> buttons = new ArrayList<>();
    private final User user;

    public LeftHomePanel(final HomePanel homePanel, User user) {
        this.layout = new GridPane();
        this.uiManager = homePanel.getUiManager();
        this.user = user;
        postInit(homePanel);
    }



    public void postInit(HomePanel homePanel) {
        final GridPane headerPanel = new GridPane();
        //this.user = user;
        headerPanel.setPrefSize(240, 52);
        headerPanel.setMaxSize(240, 52);
        headerPanel.setTranslateY(20);
        headerPanel.setOnMouseClicked(e -> {
            //TODO disconnect user and reset profile.
            homePanel.getUiManager().showPanel((GridPane) homePanel.getLayout(), new LoginPanel(homePanel.getUiManager()));
        });

        final Rectangle headerBackground = new Rectangle();
        headerBackground.setFill(Color.web("#1a1a23"));
        headerBackground.setArcWidth(52);
        headerBackground.setArcHeight(52);
        headerBackground.setWidth(240);
        headerBackground.setHeight(52);
        headerBackground.setCursor(Cursor.HAND);
        headerPanel.getChildren().add(headerBackground);

        GridPane.setVgrow(headerPanel, Priority.ALWAYS);
        GridPane.setHgrow(headerPanel, Priority.ALWAYS);
        GridPane.setValignment(headerPanel, VPos.TOP);
        GridPane.setHalignment(headerPanel, HPos.CENTER);
        this.layout.getChildren().add(headerPanel);

        final Image userIcon = new Image(Constants.SKIN_API + user.getId());
        System.out.println(Constants.SKIN_API + user.getId());
        final DoubleProperty zoomProperty = new SimpleDoubleProperty(256 / userIcon.getWidth());
        final double startX = userIcon.getWidth() / 8;
        final double startY = userIcon.getHeight() / 8;

        final PixelReader reader = userIcon.getPixelReader();
        final WritableImage imageScale = new WritableImage(reader, (int)startX, (int)startY, (int)startX, (int)startY);
        final ImageView userIconView = new ImageView(imageScale);
        userIconView.scaleXProperty().bind(zoomProperty);
        userIconView.scaleYProperty().bind(zoomProperty);

        GridPane.setHalignment(userIconView, HPos.CENTER);
        GridPane.setValignment(userIconView, VPos.CENTER);

        final Circle userCircle = new Circle(20, 20, 18);
        GridPane.setVgrow(userCircle, Priority.ALWAYS);
        GridPane.setHgrow(userCircle, Priority.ALWAYS);
        GridPane.setHalignment(userCircle, HPos.LEFT);
        GridPane.setValignment(userCircle, VPos.CENTER);
        userCircle.setFill(new ImagePattern(userIconView.getImage()));
        userCircle.setTranslateX(26.0D);
        headerPanel.getChildren().add(userCircle);

        final Label usernameLabel = new Label(user.getUsername());
        GridPane.setVgrow(usernameLabel, Priority.ALWAYS);
        GridPane.setHgrow(usernameLabel, Priority.ALWAYS);
        GridPane.setHalignment(usernameLabel, HPos.LEFT);
        GridPane.setValignment(usernameLabel, VPos.CENTER);
        usernameLabel.setTranslateX(75.0D);
        usernameLabel.setTranslateY(-7.0D);
        usernameLabel.setStyle("-fx-text-fill: #FFF;");
        usernameLabel.setFont(Constants.getCascadiaMono(14));
        headerPanel.getChildren().add(usernameLabel);

        Label disconnectLabel = new Label("Déconnexion");
        GridPane.setVgrow(disconnectLabel, Priority.ALWAYS);
        GridPane.setHgrow(disconnectLabel, Priority.ALWAYS);
        GridPane.setHalignment(disconnectLabel, HPos.LEFT);
        GridPane.setValignment(disconnectLabel, VPos.CENTER);
        disconnectLabel.setTranslateX(75.0D);
        disconnectLabel.setTranslateY(10.0D);
        disconnectLabel.setStyle("-fx-text-fill: #FFF; -fx-font-size: 12px");
        headerPanel.getChildren().add(disconnectLabel);
    }

    @Override
    public GridPane getLayout() {
        return this.layout;
    }

    @Override
    public UiManager getUiManager() {
        return this.uiManager;
    }
}
