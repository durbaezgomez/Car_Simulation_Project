package sample;

import javafx.beans.InvalidationListener;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.shape.Line;
import javafx.animation.RotateTransition;
import javafx.util.Duration;

public class Controller {

    @FXML
    private Button engineStart;

    @FXML
    private Button gearUp;

    @FXML
    private Button gearDown;

    @FXML
    private Text gearIndicator;

    @FXML
    private Text engineIndicator;

    @FXML
    private Text brakeIndicator;

    @FXML
    private Button brakeTrigger;

    @FXML
    private Button accelerateTrigger;

    @FXML
    private Label speedIndicator;

    int currentSpeed = 0;
    private StringProperty currentSpeedProperty = new StringProperty() {
        @Override
        public void bind(ObservableValue<? extends String> observable) {

        }

        @Override
        public void unbind() {

        }

        @Override
        public boolean isBound() {
            return false;
        }

        @Override
        public Object getBean() {
            return null;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public String get() {
            return null;
        }

        @Override
        public void addListener(ChangeListener<? super String> listener) {

        }

        @Override
        public void removeListener(ChangeListener<? super String> listener) {

        }

        @Override
        public void addListener(InvalidationListener listener) {

        }

        @Override
        public void removeListener(InvalidationListener listener) {

        }

        @Override
        public void set(String value) {

        }
    };


    @FXML
    private Line clockArm;

    private String[] gearArray = {"R","0","1","2","3","4","5"};
    private int[] gearMaxSpeed = {10,0,10,30,40,60,100};

    private int gearIndex = 1;

    // METHOD CHECKING IF INDICATOR IS ON
    Boolean isOn(Text text){
        return (text.getText()=="ON");
    }

    // ENGINE
    void handleEngine(){
        engineStart.setOnAction(e -> engineSwitch());
    }
    void engineSwitch(){
        if (isOn(engineIndicator)){
            engineIndicator.setText("OFF");
            engineStart.setText("ENGINE START");
        }
        else
            engineIndicator.setText("ON");
        engineStart.setText("ENGINE STOP");
    }

    //BRAKE
    void handleBrake(){
        brakeTrigger.setOnAction(e -> brakeSwitch());
    }
    void brakeSwitch(){
        if (isOn(brakeIndicator))
            brakeIndicator.setText("OFF");
        else
            brakeIndicator.setText("ON");
    }

    // GEARBOX
    void handleGearBox(){
        gearUp.setOnAction(e -> gearSwitch(1));
        gearDown.setOnAction(e -> gearSwitch(-1));
    }
    void gearSwitch(int difference){
        if((gearIndex+difference)<0 || (gearIndex+difference)>6){}
        else{
            gearIndicator.setText(gearArray[gearIndex+difference]);
            gearIndex=gearIndex+difference;

            // TODO ADD CONSTRAINTS FOR REVERSE AND 0 GEAR
            if(difference>0){
                clockRotate((gearIndex*170/6)-((gearIndex-1)*(170/6)));
            }
            else{
                clockRotate(((gearIndex-1)*(170/6)) - (gearIndex*170/6));
            }

            System.out.println("CURRENT GEAR INDEX: " + gearIndex);
            System.out.println("ANGLE: "+ clockArm.getRotate());
//            System.out.println("CURRENT MAX SPEED: " + gearMaxSpeed[gearIndex]);
        }
    }

    //ACCELERATION
    void handleAccelerator(){
        accelerateTrigger.setOnMousePressed(e -> StartAccelerating());
        accelerateTrigger.setOnMouseReleased(e -> StopAccelerating());
    }
    void StartAccelerating(){

        currentSpeed++;
        System.out.println(currentSpeed);
        speedIndicator.setText(String.valueOf(currentSpeed));


//        currentSpeedProperty.setValue(String.valueOf(currentSpeed));

//        speedIndicator.textProperty().bind(currentSpeedProperty);
//        currentSpeed = Integer.parseInt(speedIndicator.getText());

//        while(){
//            if(currentSpeed<gearMaxSpeed[gearIndex]){
//
//                System.out.println(currentSpeed);
////            currentSpeedProperty.setValue(String.valueOf(currentSpeed));
//                try{
//                    Thread.sleep(500);
//                }catch (Exception e){};
//
//                currentSpeed++;
//            }
//        }


    }
    void StopAccelerating(){
        System.out.println("Stopped Accelerating");
//        for (int i=0; i<(gearMaxSpeed[gearIndex]-currentSpeed); i++){
//            currentSpeed--;
//            speedIndicator.setText(String.valueOf(currentSpeed));
//            try{
//                wait(300);
//            }catch (Exception e){};
//        }
    }


    // TODO TEST CLOCK ROTATING METHOD
    void clockRotate(int angle){
        RotateTransition rt = new RotateTransition(Duration.millis(1000), clockArm);
        rt.setByAngle(angle);
        rt.setCycleCount(1);
//        rt.setAutoReverse(true);

        rt.play();
    }

    // MAIN CAR INIT METHOD
    public void carInit(){
        gearIndicator.setText("0");

        System.out.println("CURRENT GEAR INDEX: " + gearIndex);
        System.out.println("ANGLE: "+ clockArm.getRotate());

        handleBrake();
        handleEngine();
        handleGearBox();
        handleAccelerator();
    }


}