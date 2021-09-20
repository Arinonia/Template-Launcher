package fr.arinonia.launcher;

import javafx.application.Application;

import javax.swing.*;
/**
 * @author Arinonia
 * @date 19/09/2021
 **/
public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("javafx.application.Application");
            Application.launch(FxApplication.class, args);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "JavaFX not found !", "Erreur JavaFX", JOptionPane.ERROR_MESSAGE);
        }
    }

}
