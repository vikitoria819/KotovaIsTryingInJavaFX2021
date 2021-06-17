package javafxexamples;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Messenger extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Кнопка");
        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui));
        primaryStage.show();
    }

    private Parent createInterface() {

        TextArea textArea = new TextArea();
        TextField textField = new TextField("Введите ваше сообщение");
        Label labelContact = new Label("Контакты");
        Button buttonSend = new Button("Отправить");
        ListView<String> listView = new ListView<>();

        HBox hb1 = new HBox();
        VBox vb1 = new VBox();
        VBox vb2 = new VBox();

        hb1.getChildren().addAll(textField, buttonSend);
        vb1.getChildren().addAll(textArea, hb1);
        vb2.getChildren().addAll(labelContact, listView);

        HBox mainGridPain = new HBox(vb1, vb2);
        labelContact.setStyle("-fx-font-size: 200%");
        labelContact.setAlignment(Pos.CENTER);


        buttonSend.setMinWidth(150);
        labelContact.setMinSize(200, 50);
        listView.setMinWidth(200);

        VBox.setVgrow(textArea, Priority.ALWAYS);
        HBox.setHgrow(textField, Priority.ALWAYS);
        HBox.setHgrow(textField, Priority.ALWAYS);

        buttonSend.addEventHandler(ActionEvent.ACTION, e -> {
            String textFromUser = textField.getText();
            textArea.setText(textFromUser);
            textField.clear();
        });




        return mainGridPain;
    }
}
