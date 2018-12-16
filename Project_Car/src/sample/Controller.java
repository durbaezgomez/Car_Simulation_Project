package sample;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Controller {

    @FXML private Text statusIndicator;
    @FXML private Text gearIndicator;
    @FXML private Text engineIndicator;
    @FXML private Text brakeIndicator;
    @FXML private Label speedIndicator;
    @FXML Line clockArm;

    private Car car = new Car();

    // METHOD CHECKING IF INDICATOR IS ON
    private Boolean isOn(Text text){
        return (text.getText().equals("ON"));
    }

    // ENGINE
    public void engineSwitch(){
        if (isOn(engineIndicator)){
            engineIndicator.setText("OFF");
        }
        else
            engineIndicator.setText("ON");
    }

    //BRAKE
    public void brakeSwitch(){
        if (isOn(brakeIndicator))
            brakeIndicator.setText("OFF");
        else
            brakeIndicator.setText("ON");
    }

    // GEARBOX
    public void gearSwitch(int newGear){
        if(!isOn(engineIndicator)){statusIndicator.setText("ENGINE IS OFF");}
        else{
                statusIndicator.setText("GEAR SWITCHED");
                gearIndicator.setText(car.gearArray[newGear]);
                car.gearIndex=newGear;

            switch (newGear){
                case 0:
                    clockRotate(35);
                    break;
                case 1:
                    clockRotate(8);
                    break;
                case 2:
                    clockRotate(35);
                    break;
                case 3:
                    clockRotate(65);
                    break;
                case 4:
                    clockRotate(95);
                    break;
                case 5:
                    clockRotate(125);
                    break;
                case 6:
                    clockRotate(165);
                    break;
            }
//                System.out.println("CURRENT GEAR INDEX: " + car.gearIndex);
//                System.out.println("ANGLE: "+ clockArm.getRotate());
//                System.out.println("CURRENT MAX SPEED: " + car.gearMaxSpeed[car.gearIndex]);
            }

    }

    void clockRotate(double angle){
        RotateTransition rt = new RotateTransition(Duration.millis(500), clockArm);
        rt.setToAngle(angle);
        rt.setCycleCount(1);
        rt.play();
    }


    //ACCELERATION
    void StartAccelerating(){

    }

    void StopAccelerating(){
        System.out.println("Stopped Accelerating");
    }


    // MAIN CAR INIT METHOD
    public void carInit(){

        //TODO / TESTS
//        System.out.println("CURRENT GEAR INDEX: " + gearIndex);
//        System.out.println("ANGLE: "+ clockArm.getRotate());

    }


}