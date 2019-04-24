package patt.ReactorMonitoring;


import java.util.ArrayList;
import java.util.List;

public class ResearchCentre extends RadiationMonitor {

    /**
     * Constructs a ResearchCentre object, which observes reactor radiation readings
     * and constantly prints a report with the current moving average of the
     * recorded observations.
     *
     * @param location An arbitrary location.
     */
    List<Double> observation = new ArrayList<Double>();
    public ResearchCentre(String location) {
        super(location);
    }

    /**
     * Updates the monitor with a new observation and prints a report.
     */
    public void update(Subject subject) {
        double newObservation = subject.getState();
        observation.add(newObservation);
        System.out.println(this.generateReport());
    }

    /**
     * Generates a report of the current moving average, updated by a new
     * observation. The moving average is calculated by summing all observations
     * made so far, and dividing by the quantity of observations so far.
     */
    public String generateReport() {
        double movingAverage;
        double total = 0;
        if (observation.size() > 0) {
            for (double value : observation) {
                total = total + value;
            }
            movingAverage = total / observation.size();
        } else{
            movingAverage = 0;
        }
        String roundedAverage = String.format("%.5g", movingAverage);
        String str = this.now() + " :: moving average :: " + roundedAverage + " :: " + this.location ;
        return str;
    }

}