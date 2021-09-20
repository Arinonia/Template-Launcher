package fr.arinonia.launcher.auth;

import com.azuriom.azauth.AuthenticationException;
import com.azuriom.azauth.AzAuthenticator;
import com.azuriom.azauth.model.User;
import fr.arinonia.launcher.ui.UiManager;
import fr.arinonia.launcher.ui.controls.Alert;
import fr.arinonia.launcher.utils.Constants;
import javafx.application.Platform;

import java.io.IOException;

/**
 * @author Arinonia
 * @date 20/09/2021
 **/
public class AuthManager {

    private final AzAuthenticator authenticator = new AzAuthenticator(Constants.AUTH_URL);
    private User user;

    public boolean checkField(final String username, final String password, final UiManager uiManager) {
        if (username.isEmpty()) {
            this.displayAlert(uiManager, "Vous n'avez pas rentré de nom d'utilisateur", "Fermer");
            return false;
        }
        if (password.isEmpty()) {
            this.displayAlert(uiManager, "Vous n'avez pas rentré de mot de passe", "Fermer");
            return false;
        }
        return true;
    }

    public User authenticate(final String username, final String password, final UiManager uiManager) {
        try {
            this.user =  authenticator.authenticate(username, password);
            return this.user;
        } catch (AuthenticationException | IOException authenticationException) {
            this.displayAlert(uiManager, authenticationException.getMessage(), "Fermer");
            System.out.println(authenticationException.getMessage());
            return null;
        }
    }

    public User verify(final String accessToken) {
        try {
            this.user = authenticator.verify(accessToken);
            return this.user;
        } catch (AuthenticationException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void displayAlert(final UiManager uiManager, final String error, final String buttonText) {
        System.out.println(Thread.currentThread().getName());
        if (!Thread.currentThread().getName().equalsIgnoreCase("JavaFX Application Thread")) {

            Platform.runLater(() -> {
                final Alert ariAlert = new Alert(uiManager, error);
                ariAlert.addButton(buttonText, ariAlert::close);
                ariAlert.show();
            });
        } else {
            final Alert ariAlert = new Alert(uiManager, error);
            ariAlert.addButton(buttonText, ariAlert::close);
            ariAlert.show();
        }
    }
}
