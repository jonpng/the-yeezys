package app.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Report {

    private static int reports = 0;
    private int number;//autogenerated
    private double xCoordinate;
    private double yCoordinate;
    private Date submitted;//autogenerated (stored as Date, accessed as String)
    private String reporter;//autogenerated
    private String reportName;//need on creation
    private String condition;
    private String type;
    private String NSDir;
    private String EWDir;

    /**
     * Constructor for a Report.
     * @param x Latitude coordinate
     * @param y Longitude coordinate
     * @param name Name of Report
     * @param condition Condition of the source
     * @param reporter User who reported the source
     * @param NSDir Latitude direction
     * @param EWDir Longitude direction.
     */
    public Report(double x, double y, String name, String condition, String reporter, String NSDir, String EWDir,
                  String type) {
        xCoordinate = x;
        yCoordinate = y;
        submitted = new Date();
        this.reporter = reporter;
        this.reportName = name;
        this.condition = condition;
        this.NSDir = NSDir;
        this.EWDir = EWDir;
        this.type = type;

        if (this.type != null) {
            reports++;
        }

        this.number = this.reports;
    }

    public Report(double x, double y, String name, String condition, String reporter, String NSDir, String EWDir,
                  String type, Timestamp date) {
        this(x, y, name, condition, reporter, NSDir, EWDir, type);

        submitted = new Date(date.getTime());
    }

    /**
     * Returns the report number.
     * @return report number (int)
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the latitude.
     * @param x A latitude coordinate
     */
    public void setX(double x) {
        this.xCoordinate = x;
    }

    /**
     * Gets the latitude coordinate
     * @return A longitude coordinate.
     */
    public double getX() {
        return xCoordinate;
    }

    /**
     * Sets longitude coordinate
     * @param y longitude coordinate
     */
    public void setY(double y) {
        this.yCoordinate = y;
    }

    /**
     * Gets longitude coordinate.
     * @return longitude coordinate.
     */
    public double getY() {
        return yCoordinate;
    }

    /**
     * Gets the date that the report was submitted.
     * @return date of submission
     */
    public String getDate() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(submitted);
    }

    public Timestamp getTimestamp() {
        return new Timestamp(submitted.getTime());
    }

    public Date date() {
        return submitted;
    }

    /**
     * Gets the reporter who submitted the report.
     * @return reporter of report
     */
    public String getReporter() {
        return reporter;
    }

    /**
     * Returns the Type of report.
     * @return Type of report
     */
    public String getReportName() {
        return reportName;
    }

    /**
     * Sets the condition of the water source.
     * @param condition condition of water source.
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }

    /**
     * Gets the condition of the water source.
     * @return condition of water source.
     */
    public String getCondition() {
        return condition;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    /**
     * Returns the total number of reports submitted.
     * @return reports submitted.
     */
    public static int getReports() {
        return reports;
    }

    /**
     * Sets the report number
     * @param num report number
     */
    public void setNumber(int num) {
        number = num;
    }

    /**
     * Returns a String representation of a report.
     * @return String representation of a report.
     */
    public String toString() {
        return reportName;
    }

    /**
     * Returns the N/S direction
     * @return North or South direction
     */
    public String getNSDir() {
        return NSDir;
    }

    /**
     * Returns the E/W Direction
     * @return East or West Direction
     */
    public String getEWDir() {
        return EWDir;
    }
}