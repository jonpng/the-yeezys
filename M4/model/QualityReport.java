package model;

/**
 * Created by Steve on 10/30/2016.
 */
public class QualityReport extends Report{
    private static int reports = 0;
    private double virusPPM;
    private double containmentPPM;

    /**
     * Contructor for a Report.
     *
     * @param x         Latitude coordinate
     * @param y         Longitude coordinate
     * @param name      Name of Report
     * @param condition Condition of the source
     * @param reporter  User who reported the source
     * @param NSDir     Latitude direction
     * @param EWDir     Longitude direction.
     */
    public QualityReport(double x, double y, String name, String condition, User reporter, String NSDir, String EWDir,
                         double virusPPM, double containmentPPM) {
        super(x, y, name, condition, reporter, NSDir, EWDir, null);
        this.virusPPM = virusPPM;
        this.containmentPPM = containmentPPM;
    }

    public double getContainmentPPM() {
        return containmentPPM;
    }

    public double getVirusPPM() {
        return virusPPM;
    }

    public void setContainmentPPM(double containmentPPM) {
        this.containmentPPM = containmentPPM;
    }

    public void setVirusPPM(double virusPPM) {
        this.virusPPM = virusPPM;
    }
}
