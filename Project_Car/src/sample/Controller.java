package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private Text currentGear;

    @FXML
    private Text engineIndicator;

    @FXML
    private Text breakIndicator;

    @FXML
    private Button breakTrigger;

    @FXML
    private Line timer;

    private String[] gearArray = {"R","0","1","2","3","4","5","6"};
    private int gearIndex = 1;

    Boolean isOn(Text text){
        if(text.getText()=="ON")
            return true;
        else
            return false;
    }

    void handleEngine(){
        engineStart.setOnAction(e -> engineSwitch());
    }

    void handleBreak(){
        breakTrigger.setOnAction(e -> breakSwitch());
    }

    void handleGearBox(){
        gearUp.setOnAction(e -> gearSwitch(1));
        gearDown.setOnAction(e -> gearSwitch(-1));
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

    void breakSwitch(){
        if (isOn(breakIndicator))
            breakIndicator.setText("OFF");
        else
            breakIndicator.setText("ON");
    }

    void gearSwitch(int difference){
        if((gearIndex+difference)<0 || (gearIndex+difference)>7){}
        else{
            currentGear.setText(gearArray[gearIndex+difference]);
            gearIndex=gearIndex+difference;
        }
    }


    void lineRotate(){
        RotateTransition rt = new RotateTransition(Duration.millis(3000), timer);
        rt.setByAngle(170);
        rt.setCycleCount(4);
        rt.setAutoReverse(true);

        rt.play();
    }


    public void carInit(){
        currentGear.setText("0");
        handleBreak();
        handleEngine();
        handleGearBox();

        lineRotate();
    }


}