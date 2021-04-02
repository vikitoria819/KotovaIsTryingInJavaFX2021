package javafxexamples;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Massenger extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Пример про панельски и элементы управления");
        Parent ui = createInterface();
        primaryStage.setScene( new Scene(ui, 640, 480));
        primaryStage.show();

    }

    private Parent createInterface() {
        GridPane mainGridPain = new GridPane();

        //тут будет текст эриа, текст филд и баттон
        HBox h1 = new HBox();
        //а тут лэйбл и лист вью...
        HBox h2 = new HBox();


        mainGridPain.add(h1, 0,0);
        mainGridPain.add(h2, 1,0);


        return mainGridPain;
    }
}
