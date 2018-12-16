package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;

import javafx.event.EventHandler;


public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/stage_1.fxml"));
        GridPane box = loader.load();

        Controller controller = loader.getController();

        primaryStage.setTitle("CAR PROTOTYPE");

        Scene scene = new Scene(box);
        scene.setOnKeyReleased(event -> controller.carInit());
        controller.carInit();

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case E:
                    controller.engineSwitch();
                    break;
                case B:
                    controller.brakeSwitch();
                    break;
                case R:
                    controller.gearSwitch(0);
                    break;
                case DIGIT0:
                    controller.gearSwitch(1);
                    break;
                case DIGIT1:
                    controller.gearSwitch(2);
                    break;
                case DIGIT2:
                    controller.gearSwitch(3);
                    break;
                case DIGIT3:
                    controller.gearSwitch(4);
                    break;
                case DIGIT4:
                    controller.gearSwitch(5);
                    break;
                case DIGIT5:
                    controller.gearSwitch(6);
                    break;
                case G:
                    controller.StartAccelerating();
                    break;
            }
        });


        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }



}



