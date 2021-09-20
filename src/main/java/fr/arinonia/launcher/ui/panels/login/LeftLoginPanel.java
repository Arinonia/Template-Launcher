package fr.arinonia.launcher.ui.panels.login;

import fr.arinonia.launcher.Main;
import fr.arinonia.launcher.ui.UiManager;
import fr.arinonia.launcher.ui.panel.Panel;
import fr.arinonia.launcher.utils.Constants;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * @author Arinonia
 * @date 19/09/2021
 **/
public class LeftLoginPanel extends Panel {

    public LeftLoginPanel(final UiManager uiManager) {
        super(uiManager);
    }

    @Override
    public void initPanel() {
        this.layout.setStyle("-fx-background-color: #2d3436;");
        final Image logo = new Image(Main.class.getResource("/images/icon.png").toExternalForm());
        ImageView logoView = new ImageView(logo);
        GridPane.setVgrow(logoView, Priority.ALWAYS);
        GridPane.setHgrow(logoView, Priority.ALWAYS);
        GridPane.setHalignment(logoView, HPos.CENTER);
        GridPane.setValignment(logoView, VPos.CENTER);
        logoView.setTranslateY(-70.0D);
        logoView.setFitWidth(200);
        logoView.setFitHeight(200);
        this.layout.getChildren().add(logoView);

        final TextFlow textFlowPane = new TextFlow();
        GridPane.setVgrow(textFlowPane, Priority.ALWAYS);
        GridPane.setHgrow(textFlowPane, Priority.ALWAYS);
        GridPane.setHalignment(textFlowPane, HPos.CENTER);
        GridPane.setValignment(textFlowPane, VPos.BOTTOM);
        textFlowPane.setTranslateY(280);
        textFlowPane.setTranslateX(42);

        final Text poweredText = new Text("Powered By ");
        final Text networkName = new Text(Constants.LAUNCHER_NAME);

        poweredText.setFill(Color.rgb(121, 121, 121));
        poweredText.setFont(Constants.getCascadiaMono(18));

        networkName.setFill(Color.rgb(165, 43, 43));
        networkName.setFont(Constants.getCascadiaMono(18));
        networkName.setUnderline(true);
        networkName.setOnMouseEntered(e -> this.layout.setCursor(Cursor.HAND));
        networkName.setOnMouseExited(e -> this.layout.setCursor(Cursor.DEFAULT));
        //networkName.setOnMouseClicked(e -> Util.openUrl(Constants.AUTH_URL));
        textFlowPane.getChildren().addAll(poweredText, networkName);
        this.layout.getChildren().add(textFlowPane);


        final Label devByAri = new Label("Développé par Arinonia");
        GridPane.setVgrow(devByAri, Priority.ALWAYS);
        GridPane.setHgrow(devByAri, Priority.ALWAYS);
        GridPane.setHalignment(devByAri, HPos.CENTER);
        GridPane.setValignment(devByAri, VPos.BOTTOM);
        devByAri.setStyle("-fx-text-fill: #a54545");
        devByAri.setFont(Constants.getCascadiaMono(14));

        devByAri.setTranslateY(-10.0D);
        this.layout.getChildren().add(devByAri);
    }
}
