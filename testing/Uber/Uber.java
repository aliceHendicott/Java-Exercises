package junit.Uber;

import java.util.concurrent.*;

public class Uber {

    private String carModel;
    private String driverName;
    private static double fareRate;
    private long startTime;
    private long endTime;
    private double surge = 0.0;

    public Uber(String carModel, String driverName){
        this.carModel = carModel;
        this.driverName = driverName;
    }

    public String getDriverName(){ return driverName; }

    public String getCarModel(){ return carModel; }

    public static void setRate(double rate) { fareRate = rate; }

    public static double getFareRate(){ return fareRate; }

    public void pickup(){
        startTime = System.nanoTime();
    }

    public void setSurge(double surgeMultiplier){
        surge = surgeMultiplier;
    }

    public double setdownPassenger(){
        endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double seconds = (double)elapsedTime / 1_000_000_000.0;
        double fare;
        if (surge == 0.0) {
            fare = seconds * fareRate;
        } else{
            fare = seconds * fareRate * surge;
        }
        return fare;
    }

}
