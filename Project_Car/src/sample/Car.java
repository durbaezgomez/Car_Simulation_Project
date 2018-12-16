package sample;

public class Car {

    String[] gearArray = {"R","0","1","2","3","4","5"};
    int[] gearMaxSpeed = {10,0,10,30,40,60,100};
    int gearIndex = 1;
    int currentSpeed = 0;

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }


}
