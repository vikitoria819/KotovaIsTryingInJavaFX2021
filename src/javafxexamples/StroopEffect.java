package javafxexamples;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;

public class StroopEffect extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Как же хочется четвёрочку");
        Parent parent = initInterface();
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }

    private Parent initInterface() {
        GridPane mainGridPain = new GridPane();
        Button addSmth = new Button("Добавить");
        VBox words = new VBox();
        words.setMinSize(300,400);
        VBox containButton = new VBox();
        containButton.setMinSize(150,400);
        containButton.setStyle("-fx-border: 2px solid black");


        Label label1 = new Label("Синий");
        label1.setStyle("-fx-text-fill: blue;");
        Label label2 = new Label("Жёлтый");
        label2.setStyle("-fx-text-fill: green;");
        Label label3 = new Label("Фиолетовый");
        label3.setStyle("-fx-text-fill: orange;");
        Rectangle rec1 = new Rectangle();
        rec1.setX(20);
        rec1.setY(50);
        rec1.setWidth(80);
        rec1.setHeight(25);
        rec1.setFill(Color.BLUE);

        Label label4 = new Label("Чёрный");
        label4.setStyle("-fx-text-fill: red;");

        Rectangle rec2 = new Rectangle();
        rec2.setX(20);
        rec2.setY(50);
        rec2.setWidth(80);
        rec2.setHeight(25);
        rec2.setFill(Color.PURPLE);

        words.setStyle("-fx-font-weight: 900; -fx-font-size: 2em");
        words.setAlignment(Pos.TOP_CENTER);
        HBox.setHgrow(words, Priority.ALWAYS);

        words.getChildren().addAll(label1,label2,label3,rec1, label4, rec2);
        containButton.getChildren().addAll(addSmth);
        mainGridPain.add(words, 0, 0);
        mainGridPain.add(containButton,1,0);

        addSmth.setOnAction(new EventHandler<>() {
            String[] obj = new String[]{"Чёрный", "Красный", "Оранжевый", "Жёлтый", "Зелёный", "Синий", "Голубой", "Фиолетовый"};
            String[] numbColor = new String[]{"#000000", "#ff2525", "#ff8125", "#fcff25", "#25e3ff", "#2555ff", "#b525ff"};
            Random random = new Random();
            @Override
            public void handle(ActionEvent event) {
                if (words.getChildren().size() == 10) {
                    words.getChildren().remove(0);
                }

                if (random.nextBoolean()) {
                    int o = random.nextInt(obj.length);
                    int c = random.nextInt(numbColor.length);
                    Label lab = new Label(obj[o]);
                    lab.setStyle("-fx-text-fill:" + numbColor[c] + ";");
                    words.getChildren().add(lab);
                }
                else {
                    int c = random.nextInt(numbColor.length);
                    Rectangle rec = new Rectangle();
                    rec.setX(20);
                    rec.setY(50);
                    rec.setWidth(80);
                    rec.setHeight(25);
                    rec.setFill(Paint.valueOf(numbColor[c]));
                    words.getChildren().add(rec);
                }

            }
        });

        return mainGridPain;

    }
}
