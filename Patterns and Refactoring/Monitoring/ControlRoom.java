package patt.ReactorMonitoring;

import java.util.ArrayList;
import java.util.List;

public class ControlRoom extends RadiationMonitor {

    double warningThreshold;
    List<Double> observation = new ArrayList<Double>();
    /**
     * Constructs a ControlRoom object, which observes reactor radiation readings
     * and prints reports if the radiation exceeds a threshold.
     *
     * @param location         An arbitrary location.
     * @param warningThreshold The radiation threshold for when reports should be printed.
     */
    public ControlRoom(String location, double warningThreshold) {
        super(location);
        this.warningThreshold = warningThreshold;
    }

    /**
     * Updates the monitor with a new observation and prints a report if and only if
     * the observation is equal to or greater than the warning threshold.
     */
    public void update(Subject subject) {
        double newObservation = subject.getState();
        observation.add(newObservation);
        if (newObservation >= warningThreshold){
            System.out.println(generateReport());
        }
    }

    /**
     * Generates a report based on the current observation.
     */
    @Override
    public String generateReport() {
        double lastObservation = observation.get(observation.size()-1);
        String roundedObservation = String.format("%.5g", lastObservation);
        String str = this.now() + " :: WARNING :: " + roundedObservation + " :: " + location;
        return str;
    }
}