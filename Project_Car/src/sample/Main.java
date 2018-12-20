package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/stage_1.fxml"));
        GridPane box = loader.load();

        Controller controller = loader.getController();

        primaryStage.setTitle("CAR PROTOTYPE");

        Scene scene = new Scene(box);

        controller.carInit();

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case E:
                    controller.EngineSwitch();
                    break;
                case B:
                    controller.Brake();
                    break;
                case SHIFT:
                    controller.AnimationClutchDown();
                    break;
                case R:
                    controller.GearSwitch(0);
                    break;
                case DIGIT0:
                    controller.GearSwitch(1);
                    break;
                case DIGIT1:
                    controller.GearSwitch(2);
                    break;
                case DIGIT2:
                    controller.GearSwitch(3);
                    break;
                case DIGIT3:
                    controller.GearSwitch(4);
                    break;
                case DIGIT4:
                    controller.GearSwitch(5);
                    break;
                case DIGIT5:
                    controller.GearSwitch(6);
                    break;
                case G:
                    controller.StartAccelerating();
                    break;
            }
        });

        primaryStage.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
            switch(event.getCode()){
                case G:
                    controller.StopAccelerating();
                    break;
                case B:
                    controller.AnimationBrakeUp();
                    break;
                case SHIFT:
                    controller.AnimationClutchUp();
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



