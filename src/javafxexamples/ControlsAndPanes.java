package javafxexamples;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;

public class ControlsAndPanes extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Пример про панельски и элементы управления");
        Parent ui = createInterface();
        primaryStage.setScene( new Scene(ui, 640, 480));
        primaryStage.show();

    }

    private Parent createInterface() {
        GridPane mainGridPain = new GridPane();
        VBox vb1 = new VBox();
        VBox vb2 = new VBox();
        HBox hb = new HBox();
        BorderPane bp = new BorderPane();

        mainGridPain.add(vb1,0,0);
        mainGridPain.add(vb2,1,1);
        mainGridPain.add(hb,0,1);
        mainGridPain.add(bp,1,0);
        mainGridPain.setStyle("-fx-font-size: 3em");

        vb1.setStyle("-fx-background-color: red");
        vb2.setBackground(new Background(new BackgroundFill(
                Color.GREEN,
                new CornerRadii(0),
                null
        )));
        hb.setStyle("-fx-background-color: blue");
        bp.setStyle("-fx-background-color: #800069");

        vb1.getChildren() //получаем доступ к списку детей. Это почти как List
                .add(new Button("Первая кнопка"));
        vb1.getChildren().addAll(
                new Button("Вторая кнопка"),
                new Button("?!"),
                new Label("Это метка с текстом")
        );

        final Button smallButton = new Button("?!");
        vb2.getChildren().addAll(
                new Button("Первая кнопка"),
                new ColorPicker(),
                smallButton,
                new Label("Это метка с текстом")
        );

        hb.getChildren().addAll(
                new Button("Кн 1"),
                new Label("к. текст"),
                new Button("Кнопка 2")
        );

        ColumnConstraints col1 = new ColumnConstraints(); // можно сразу указать
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints(); // можно сразу указать
        col2.setPercentWidth(50);
        //получаем список всех ограничений на столбцы и добавляем
        mainGridPain.getColumnConstraints().addAll(col1, col2);

        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        row2.setVgrow(Priority.ALWAYS); //указываем для второй строки растягиваемость по вертикали
        //ALWAYS - растягивай всегда
        mainGridPain.getRowConstraints().addAll(row1, row2);

        vb2.setAlignment(Pos.BOTTOM_RIGHT);
        VBox.setVgrow(smallButton, Priority.ALWAYS);

        VBox.setMargin(vb2.getChildren().get(2),
                new Insets(8)
        );


        final Button bottom = new Button("снизу");
        final Button left = new Button("слева");
        final Button right = new Button("справа");
        final Button top = new Button("сверху");
        final Button center = new Button("в центре");

        BorderPane.setAlignment(bottom, Pos.CENTER);
        bp.setBottom(bottom);
        bp.setLeft(left);
        bp.setRight(right);
        bp.setTop(top);
        bp.setCenter(center);

        for (Button b : List.of(bottom, left, right, top, center)) {
            b.setMaxWidth(Double.MAX_VALUE);
            b.setMaxHeight(Double.MAX_VALUE);
        }

        return mainGridPain;

    }
}
