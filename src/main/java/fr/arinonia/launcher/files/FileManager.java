package fr.arinonia.launcher.files;

import fr.arinonia.launcher.Launcher;
import fr.arinonia.launcher.utils.Constants;

import java.io.File;

/**
 * @author Arinonia
 * @date 20/09/2021
 **/
public class FileManager {



    public FileManager() {

    }

    public File getRootFolder() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win"))
            return new File(System.getProperty("user.home") + "\\AppData\\Roaming\\." + Constants.LAUNCHER_NAME.replace("-", ""));
        else if (os.contains("mac"))
            return new File(System.getProperty("user.home") + "/Library/Application Support/" + Constants.LAUNCHER_NAME.replace("-", ""));
        else
            return new File(System.getProperty("user.home") + "/." + Constants.LAUNCHER_NAME.replace("-", ""));
    }

}
