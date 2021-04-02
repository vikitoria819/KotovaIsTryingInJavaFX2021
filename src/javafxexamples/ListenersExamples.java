package javafxexamples;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListenersExamples extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Пример про слушателей");

        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui, 640, 480));

        primaryStage.show();
    }

    private Parent createInterface() {
        int k = 1;

        VBox vb = new VBox();
        Button b = new Button("Кнопка");
        //найти как бы центрировать текст...
        Label l = new Label("Привет, сыграем в игру? \n В общем, нажимаешь 1 раз на кнопку и закрываешь это окно!");



        vb.getChildren().addAll(l, b);
        vb.setStyle("-fx-font-size: 1.5em");
        vb.setAlignment(Pos.CENTER);

        //в разработке...
        //b.setOnAction(actionEvent -> {
        //    if (k==1) {
        //        System.out.println("ffffffff");
        //    };
        //});


        return vb;
    }
}