package sample;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class Controller {

    @FXML private Text statusIndicator;
    @FXML private Text gearIndicator;
    @FXML private Text engineIndicator;
    @FXML private Label speedIndicator;
    @FXML Line clockArm;
    @FXML private ImageView clutchPedal;
    @FXML private ImageView brakePedal;
    @FXML private ImageView gasPedal;

    private Car car = new Car();

    // METHOD CHECKING IF INDICATOR IS ON
    private Boolean isOn(Text text){
        return (text.getText().equals("ON"));
    }

    // ENGINE
    public void EngineSwitch(){
        if (isOn(engineIndicator)){
            engineIndicator.setText("OFF");
        }
        else
            engineIndicator.setText("ON");
    }

    // BRAKE
    public void Brake(){

        AnimationBrakeDown();

        if(car.gearIndex == 1 && car.getCurrentSpeed().intValue() == 1){
            car.setCurrentSpeed(car.getCurrentSpeed().intValue()-1);
            speedIndicator.setText(String.valueOf(car.getCurrentSpeed().intValue()));
            System.out.println(car.getCurrentSpeed().intValue());
        }
        else if (car.getCurrentSpeed().intValue() == car.gearMaxSpeed[car.gearIndex-1]){
                statusIndicator.setText("ENGINE OVERLOAD");
        }
        else if(car.getCurrentSpeed().intValue() !=0){
            speedIndicator.setText(String.valueOf(car.getCurrentSpeed().intValue()));
            try {
                Thread.sleep(100);
            } catch (Exception e) {}
            car.setCurrentSpeed(car.getCurrentSpeed().intValue()-1);
            System.out.println(car.getCurrentSpeed().intValue());
        }
    }

    // GEARBOX
    public void GearSwitch(int newGear){

        if(!isOn(engineIndicator)){statusIndicator.setText("ENGINE IS OFF");}
        else{
            statusIndicator.setText("GEAR SWITCHED");
            gearIndicator.setText(car.gearArray[newGear]);
            car.gearIndex=newGear;

            switch (newGear){
                case 0:
                    ClockRotate(35);
                    break;
                case 1:
                    ClockRotate(8);
                    break;
                case 2:
                    ClockRotate(35);
                    break;
                case 3:
                    ClockRotate(65);
                    break;
                case 4:
                    ClockRotate(95);
                    break;
                case 5:
                    ClockRotate(125);
                    break;
                case 6:
                    ClockRotate(165);
                    break;
            }
        }

    }


    //ACCELERATION
    void StartAccelerating(){

        AnimationGasDown();

        if(!isOn(engineIndicator)){statusIndicator.setText("ENGINE IS OFF");}
        else {
            Accelerate();
        }
    }

    void StopAccelerating(){

        AnimationGasUp();

        if(car.getCurrentSpeed().intValue() > car.gearMaxSpeed[car.gearIndex-1]){
            ReduceSpeed();
        }
    }

    void Accelerate(){
        try {
            Thread.sleep(100);
        } catch (Exception e) {}
        if (car.getCurrentSpeed().intValue() < car.gearMaxSpeed[car.gearIndex] && car.gearIndex != 1){
                car.setCurrentSpeed(car.getCurrentSpeed().intValue()+1);
                speedIndicator.setText(String.valueOf(car.getCurrentSpeed().intValue()));
        }
        else{
            statusIndicator.setText("ENGINE OVERLOAD");
        }
    }

    void ReduceSpeed(){

        for(int i = car.getCurrentSpeed().intValue(); i > car.gearMaxSpeed[car.gearIndex-1]; i--){
            if(car.gearIndex == 1 && car.getCurrentSpeed().intValue() == 1){
                car.setCurrentSpeed(car.getCurrentSpeed().intValue()-1);
                speedIndicator.setText(String.valueOf(car.getCurrentSpeed().intValue()));
                System.out.println(car.getCurrentSpeed().intValue());
            }
            else{
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
                car.setCurrentSpeed(car.getCurrentSpeed().intValue()-1);
                System.out.println(car.getCurrentSpeed().intValue());
                speedIndicator.setText(String.valueOf(car.getCurrentSpeed().intValue()));
            }

        }

    }


    // ANIMATIONS

    private void AnimationBrakeDown() {
        brakePedal.setFitWidth(63);
        brakePedal.setFitHeight(64);
        brakePedal.setTranslateX(20);
        brakePedal.setTranslateY(-26);
    }

    public void AnimationBrakeUp(){
        brakePedal.setFitWidth(75);
        brakePedal.setFitHeight(77);
        brakePedal.setTranslateX(12);
        brakePedal.setTranslateY(-22);
    }


    private void AnimationGasDown() {
        gasPedal.setFitWidth(60);
        gasPedal.setFitHeight(110);
        gasPedal.setTranslateX(18);
        gasPedal.setTranslateY(-24);
    }

    private void AnimationGasUp(){
        gasPedal.setFitWidth(66);
        gasPedal.setFitHeight(120);
        gasPedal.setTranslateX(15);
        gasPedal.setTranslateY(-18);
    }

    void AnimationClutchDown(){
        clutchPedal.setFitWidth(56);
        clutchPedal.setFitHeight(75);
        clutchPedal.setTranslateX(38);
        clutchPedal.setTranslateY(-20);

    }
    void AnimationClutchUp(){
        clutchPedal.setFitWidth(64);
        clutchPedal.setFitHeight(83);
        clutchPedal.setTranslateX(32);
        clutchPedal.setTranslateY(-17);
    }

    // GEARS CLOCK
    void ClockRotate(double angle){
        RotateTransition rt = new RotateTransition(Duration.millis(500), clockArm);
        rt.setToAngle(angle);
        rt.setCycleCount(1);
        rt.play();
    }

    // MAIN CAR INIT METHOD
    public void carInit(){

        //TODO / TESTS
//        System.out.println("CURRENT GEAR INDEX: " + gearIndex);
//        System.out.println("ANGLE: "+ clockArm.getRotate());

    }


}