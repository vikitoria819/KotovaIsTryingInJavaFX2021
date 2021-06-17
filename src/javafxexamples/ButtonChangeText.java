package javafxexamples;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ButtonChangeText extends Application {
    @Override
    public void start(Stage primaryStage) throws MalformedURLException {
        primaryStage.setTitle("Кнопка");
        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui, 640, 480));
        primaryStage.show();
    }

    private Parent createInterface() throws MalformedURLException {
        String[] answer = new String[]{
                "Я пропросил, не нажимай больше на эту кнопку",
                "Сколько раз тебе повторять?",
                "Это было последнее предупрждение!"
        };

        Button button = new Button("Кнопка");

        Label label = new Label("Не нажимай больше на эту кнопку");
        label.setGraphic(button);

        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().add(label);


        button.setOnAction(new EventHandler<>() {
            Path boomPath = Paths.get("images", "vikajava2021/boom.gif");
            String boomUrl = boomPath.toUri().toURL().toString();
            Image boom = new Image(boomUrl, 300, 400, true, true);
            ImageView boomView = new ImageView(boom);
            int i = 0;
            int k = answer.length;

            @Override
            public void handle(ActionEvent event) {
                if (i != k) {
                    label.setText(answer[i++]);
                } else {
                    vb.getChildren().clear();
                    vb.getChildren().add(boomView);
                }
            }
        });

        return vb;
    }
}

