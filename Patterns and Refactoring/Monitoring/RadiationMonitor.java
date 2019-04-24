package patt.ReactorMonitoring;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class RadiationMonitor implements Observer {

    String location;
    /**
     * Constructs a RadiationMonitor object.
     *
     * @param location An arbitrary location.
     */
    public RadiationMonitor(String location) {
        this.location = location;
    }

    /**
     * Gets the location
     *
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Generates a report based on the current observation.
     *
     * @return a report
     */
    public abstract String generateReport();

    /**
     * Gets the current time.
     *
     * @return The current time in yyyy-MM-dd HH:mm:ss format
     */
    public String now() {
        String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat date = new SimpleDateFormat(DATE_FORMAT_NOW);
        return date.format(calendar.getTime());
    }
}