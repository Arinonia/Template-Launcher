package fr.arinonia.launcher.ui.panels.login;

import com.azuriom.azauth.model.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import fr.arinonia.launcher.ui.UiManager;
import fr.arinonia.launcher.ui.panel.Panel;
import fr.arinonia.launcher.ui.panels.home.HomePanel;
import fr.arinonia.launcher.utils.Constants;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;

import java.io.IOException;

/**
 * @author Arinonia
 * @date 19/09/2021
 **/
public class RightLoginPanel extends Panel {

    public RightLoginPanel(final UiManager uiManager) {
        super(uiManager);
    }

    @Override
    public void initPanel() {
        this.layout.setStyle("-fx-background-color: #2c3e50;");

        final Label title = new Label("Login");
        GridPane.setVgrow(title, Priority.ALWAYS);
        GridPane.setHgrow(title, Priority.ALWAYS);
        GridPane.setHalignment(title, HPos.CENTER);
        GridPane.setValignment(title, VPos.TOP);
        title.setStyle("-fx-text-fill: #e1e1e1;");
        title.setTranslateY(20.0D);
        title.setFont(Constants.getCascadiaMono(24));
        this.layout.getChildren().add(title);

        final JFXTextField usernameField = new JFXTextField();
        GridPane.setVgrow(usernameField, Priority.ALWAYS);
        GridPane.setHgrow(usernameField, Priority.ALWAYS);
        GridPane.setHalignment(usernameField, HPos.CENTER);
        GridPane.setValignment(usernameField, VPos.TOP);
        usernameField.setPromptText("Username");
        usernameField.setTranslateY(100.0D);
        usernameField.setMaxSize(300, 40);
        usernameField.setFont(Constants.getCascadiaMono(18));
        usernameField.setStyle("-fx-accent: #809BD5; -fx-font-size: 18px; -fx-text-fill: #c3c3c3; -fx-prompt-text-fill: #7e7e7e; -fx-background-color: rgba(0, 0, 0, 0.1); -fx-padding: 3px;");
        this.layout.getChildren().add(usernameField);

        final FontAwesomeIconView userIcon = new FontAwesomeIconView(FontAwesomeIcon.USER);
        GridPane.setVgrow(userIcon, Priority.ALWAYS);
        GridPane.setHgrow(userIcon, Priority.ALWAYS);
        GridPane.setHalignment(userIcon, HPos.LEFT);
        GridPane.setValignment(userIcon, VPos.TOP);
        userIcon.setStyle("-fx-font-size: 22px");
        userIcon.setFill(Color.WHITE);
        userIcon.setTranslateY(110.0D);
        userIcon.setTranslateX(50.0D);
        this.layout.getChildren().add(userIcon);

        final JFXPasswordField passwordField = new JFXPasswordField();
        GridPane.setVgrow(passwordField, Priority.ALWAYS);
        GridPane.setHgrow(passwordField, Priority.ALWAYS);
        GridPane.setHalignment(passwordField, HPos.CENTER);
        GridPane.setValignment(passwordField, VPos.TOP);
        passwordField.setText("");
        passwordField.setPromptText("Password");
        passwordField.setTranslateY(180.0D);
        passwordField.setFont(Constants.getCascadiaMono(18));
        passwordField.setMaxSize(300, 40);
        passwordField.setStyle("-fx-accent: #809BD5; -fx-font-size: 16px; -fx-text-fill: #c3c3c3; -fx-prompt-text-fill: #7e7e7e; -fx-background-color: rgba(0, 0, 0, 0.1);  -fx-padding: 3px;");
        this.layout.getChildren().add(passwordField);

        final FontAwesomeIconView passwordIcon = new FontAwesomeIconView(FontAwesomeIcon.LOCK);
        GridPane.setVgrow(passwordIcon, Priority.ALWAYS);
        GridPane.setHgrow(passwordIcon, Priority.ALWAYS);
        GridPane.setHalignment(passwordIcon, HPos.LEFT);
        GridPane.setValignment(passwordIcon, VPos.TOP);
        passwordIcon.setStyle("-fx-font-size: 22px");
        passwordIcon.setFill(Color.WHITE);
        passwordIcon.setTranslateY(190.0D);
        passwordIcon.setTranslateX(50.0D);
        this.layout.getChildren().add(passwordIcon);

        final JFXButton connectButton = new JFXButton("Connexion");
        GridPane.setVgrow(connectButton, Priority.ALWAYS);
        GridPane.setHgrow(connectButton, Priority.ALWAYS);
        GridPane.setHalignment(connectButton, HPos.CENTER);
        GridPane.setValignment(connectButton, VPos.BOTTOM);
        connectButton.setTranslateY(-76.0D);
        connectButton.setMaxSize(200, 50);
        connectButton.setFont(Constants.getCascadiaMono(14));
        connectButton.setStyle("-fx-text-fill: #e1e1e1; -fx-background-color: rgba(32, 31, 30, 0.7); -fx-border-color: rgb(110,172,226); -fx-border-width: 1px;");
        connectButton.setCursor(Cursor.HAND);
        connectButton.setOnMouseClicked(e -> {
            new Thread(() -> {
                final String username = usernameField.getText();
                final String password = passwordField.getText();

                if (this.uiManager.getLauncher().getAuthManager().checkField(username, password, this.uiManager)) {
                    final  User user = this.uiManager.getLauncher().getAuthManager().authenticate(username, password, this.uiManager);
                    if (user != null) {
                        this.uiManager.getLauncher().getLauncherConfiguration().set("accessToken", user.getAccessToken());
                        Platform.runLater(() -> this.uiManager.showPanel((GridPane) this.layout.getParent().getParent(), new HomePanel(this.uiManager, user)));
                    }
                }
            }).start();
        });
        this.layout.getChildren().add(connectButton);

        final Label forgetPassLabel = new Label("Mot de passe oublié ?");
        GridPane.setVgrow(forgetPassLabel, Priority.ALWAYS);
        GridPane.setHgrow(forgetPassLabel, Priority.ALWAYS);
        GridPane.setHalignment(forgetPassLabel, HPos.LEFT);
        GridPane.setValignment(forgetPassLabel, VPos.BOTTOM);
        forgetPassLabel.setStyle("-fx-text-fill: #3eb4f3;");
        forgetPassLabel.setFont(Constants.getCascadiaMono(14));
        forgetPassLabel.setUnderline(true);
        forgetPassLabel.setTranslateY(-5.0D);
        forgetPassLabel.setTranslateX(20.0D);
        forgetPassLabel.setCursor(Cursor.HAND);
        //forgetPassLabel.setOnMouseClicked(e -> Util.openUrl(Constants.FORGOT_PASSWORD_LINK));
        this.layout.getChildren().add(forgetPassLabel);

        final Label createAccountLabel = new Label("Créer un compte !");
        GridPane.setVgrow(createAccountLabel, Priority.ALWAYS);
        GridPane.setHgrow(createAccountLabel, Priority.ALWAYS);
        GridPane.setHalignment(createAccountLabel, HPos.RIGHT);
        GridPane.setValignment(createAccountLabel, VPos.BOTTOM);
        createAccountLabel.setStyle("-fx-text-fill: #3eb4f3;");
        createAccountLabel.setFont(Constants.getCascadiaMono(14));
        createAccountLabel.setUnderline(true);
        createAccountLabel.setTranslateY(-5.0D);
        createAccountLabel.setTranslateX(-20.0D);
        createAccountLabel.setCursor(Cursor.HAND);
        //createAccountLabel.setOnMouseClicked(e -> Util.openUrl(Constants.CREATE_ACCOUNT_LINK));
        this.layout.getChildren().add(createAccountLabel);
    }
}
