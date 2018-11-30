package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application{

    Button accelerateButton;
    Button breakButton;

    int acceleration = 0;
//    List <String> gear = new ArrayList<>();


    void Accelerate(){
        acceleration++;
        System.out.println(acceleration);
    }

    void Break(){
        acceleration--;
        System.out.println(acceleration);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("gui_looks.fxml"));

        primaryStage.setTitle("CAR PROTOTYPE");

        Scene scene = new Scene(root);
        scene.setFill(Color.BROWN);

        primaryStage.setScene(scene);
        primaryStage.show();


    ///////////////////// BUTTON LOGIC:
        accelerateButton = (Button) scene.lookup("#accelerateButton");
        accelerateButton.setOnAction(e -> Accelerate());

        breakButton = (Button) scene.lookup("#breakButton");
        breakButton.setOnAction(e -> Break());


    }



}


