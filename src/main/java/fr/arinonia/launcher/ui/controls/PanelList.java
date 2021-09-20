package fr.arinonia.launcher.ui.controls;

import fr.arinonia.launcher.Main;
import fr.arinonia.launcher.ui.controls.transition.SmoothishTransition;
import javafx.animation.Interpolator;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * @author Arinonia
 * @date 20/09/2021
 **/
public class PanelList extends ScrollPane {

    private final VBox layout = new VBox();
    private final static double BASE_MODIFIER = 1;

    public PanelList() {
        this.setHbarPolicy(ScrollBarPolicy.NEVER);
        this.setBackground(Background.EMPTY);
        this.setStyle("-fx-padding: 0; -fx-background-insets: 0; -fx-border-width:0; -fx-border-insets:0; -fx-background-color: #3c3c3c");
        this.layout.setOnScroll(new EventHandler<ScrollEvent>() {

            private SmoothishTransition transition;

            @Override
            public void handle(ScrollEvent event) {
                double deltaY = BASE_MODIFIER * event.getDeltaY();
                double width = getContent().getBoundsInLocal().getWidth();
                double vvalue = getVvalue();
                Interpolator interp = Interpolator.LINEAR;
                this.transition = new SmoothishTransition(this.transition, deltaY) {
                    @Override
                    protected void interpolate(double frac) {
                        double x = interp.interpolate(vvalue, vvalue + -deltaY * getMod() / width, frac);
                        setVvalue(x);
                    }
                };
                this.transition.play();
            }
        });
        this.setFitToWidth(true);
        this.setFocusTraversable(false);

        GridPane.setHgrow(this.layout, Priority.ALWAYS);
        GridPane.setVgrow(this.layout, Priority.ALWAYS);

        this.setContent(this.layout);
        this.getStylesheets().add(Main.class.getResource("/css/bar.css").toExternalForm());
    }

    public void add(GridPane panel) {
        this.layout.getChildren().add(panel);
    }

    public VBox getLayout() {
        return this.layout;
    }
}
