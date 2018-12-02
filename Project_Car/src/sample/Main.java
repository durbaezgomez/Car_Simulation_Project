package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/stage_1.fxml"));
        GridPane box = loader.load();

        primaryStage.setTitle("CAR PROTOTYPE");
        Controller controller = loader.getController();

        Scene scene = new Scene(box);

        controller.carInit();

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}



