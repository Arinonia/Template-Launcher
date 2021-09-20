package fr.arinonia.launcher.files;

import fr.arinonia.launcher.Launcher;
import fr.arinonia.launcher.utils.Constants;

import java.io.*;
import java.util.Properties;

/**
 * @author Arinonia
 * @date 20/09/2021
 **/
public class LauncherConfiguration {

    private final Properties properties;
    private final File configFile;

    public LauncherConfiguration(final Launcher launcher) {
        this.properties = new Properties();
        this.configFile = new File(launcher.getFileManager().getRootFolder(), "settings.properties");

        if (this.configFile.exists()) {
            try {
                this.properties.load(new FileInputStream(this.configFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            this.set("accessToken", "null");
        }
    }

    public void set(final String key, final String value) {
        this.properties.setProperty(key, value);
        this.save();
    }
    public String get(final String key) {
        return this.properties.getProperty(key);
    }

    public void save() {
        try {
            this.properties.store(new BufferedWriter(new FileWriter(this.configFile)), "#Generate by " + Constants.LAUNCHER_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
