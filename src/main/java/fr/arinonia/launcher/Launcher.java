package fr.arinonia.launcher;

import com.azuriom.azauth.model.User;
import fr.arinonia.launcher.auth.AuthManager;
import fr.arinonia.launcher.files.FileManager;
import fr.arinonia.launcher.files.LauncherConfiguration;
import fr.arinonia.launcher.ui.UiManager;
import fr.arinonia.launcher.ui.panels.RootPanel;
import javafx.stage.Stage;
/**
 * @author Arinonia
 * @date 19/09/2021
 **/
public class Launcher {

    private final UiManager uiManager;
    private final AuthManager authManager = new AuthManager();
    private final FileManager fileManager = new FileManager();
    private LauncherConfiguration launcherConfiguration;

    public Launcher() {
        this.uiManager = new UiManager(this);
    }

    public void init(final Stage stage) {
        try {
            this.setup(stage);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private void setup(final Stage stage) {
        if (!this.fileManager.getRootFolder().exists()) {
            if (!this.fileManager.getRootFolder().mkdirs()) {
                System.out.println("An error as occurred while creating the root folder");
            }
        }
        this.launcherConfiguration = new LauncherConfiguration(this);

        this.uiManager.createFrame(stage);
        this.uiManager.showPanel(uiManager.getLayout(), new RootPanel(this.uiManager, this.tryToAuth()));
    }

    private User tryToAuth() {
        if (launcherConfiguration.get("accessToken") != null && !launcherConfiguration.get("accessToken").equalsIgnoreCase("null")) {
            return this.authManager.verify(launcherConfiguration.get("accessToken"));
        } else {
            return null;
        }
    }

    public AuthManager getAuthManager() {
        return this.authManager;
    }

    public FileManager getFileManager() {
        return this.fileManager;
    }

    public LauncherConfiguration getLauncherConfiguration() {
        return this.launcherConfiguration;
    }
}
