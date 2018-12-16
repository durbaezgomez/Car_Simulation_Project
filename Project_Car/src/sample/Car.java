package sample;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Car {

    String[] gearArray = {"R","0","1","2","3","4","5"};
    int[] gearMaxSpeed = {10,0,10,30,40,60,100};
    int gearIndex = 1;
    IntegerProperty currentSpeed = new SimpleIntegerProperty();



    public IntegerProperty getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int value) {
        currentSpeed.set(value);
    }


}
