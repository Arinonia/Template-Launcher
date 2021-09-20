package fr.arinonia.launcher.utils;

import fr.arinonia.launcher.Main;
import javafx.scene.text.Font;

/**
 * @author Arinonia
 * @date 19/09/2021
 **/
public class Constants {
    public static final String LAUNCHER_NAME = "Template-Launcher";
    public static final String LAUNCHER_VERSION = "0.0.1";
    public static final double LAUNCHER_WIDTH = 1280;
    public static final double LAUNCHER_HEIGHT = 720;

    public static final String AUTH_URL = "https://arinonia.athena-heberg.fr";
    public static final String SKIN_API = AUTH_URL + "/api/skins/";
    public static final String CREATE_ACCOUNT_LINK = AUTH_URL + "/user/register";
    public static final String FORGOT_PASSWORD_LINK = AUTH_URL + "/user/password/reset";

    public static Font getCascadiaMono(final double fontSize) {
        return Font.loadFont(Main.class.getResource("/fonts/CascadiaMono.ttf").toString(), fontSize);
    }
}
