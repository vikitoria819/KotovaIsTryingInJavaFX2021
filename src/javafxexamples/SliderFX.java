package javafxexamples;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class SliderFX extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Кнопка");
        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui));
        primaryStage.show();
    }

    private Parent createInterface(){
        HBox hb = new HBox();
        VBox change = new VBox();
        VBox pane = new VBox();

        Circle circle = new Circle();
        circle.setCenterX(100.0f);
        circle.setCenterY(100.0f);
        circle.setRadius(50.0f);

        Slider slide = new Slider();
        ColorPicker colorOfCircle = new ColorPicker();
        ColorPicker colorOfBg = new ColorPicker();

        change.setMinWidth(200);
        pane.setMinSize(300, 300);

        pane.setAlignment(Pos.CENTER);
        VBox.setVgrow(pane, Priority.ALWAYS);
        HBox.setHgrow(pane, Priority.ALWAYS);

        change.getChildren().addAll(slide,colorOfCircle,colorOfBg);
        pane.getChildren().addAll(circle);
        hb.getChildren().addAll(change,pane);

        return hb;
    }
}
