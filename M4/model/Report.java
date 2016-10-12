package model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Report {

    private static int reports = 0;
    private int number;//autogenerated
    private double xCoordinate;
    private double yCoordinate;
    private Date submitted;//autogenerated (stored as Date, accessed as String)
    private User reporter;//autogenerated
    private User verifier;
    private String type;//need on creation
    private String condition;
    private boolean status;
    private String NSDir;
    private String EWDir;

    public Report(double x, double y, String Type, String Condition, User reporter, String NSDir, String EWDir) {
        //TODO: autogenerate number
        xCoordinate = x;
        yCoordinate = y;
        submitted = new Date();
        this.reporter = reporter;//TODO: autogenerate
        this.verifier = null;//TODO: autogenerate afterwards?
        type = Type;
        condition = Condition;
        status = false;
        this.NSDir = NSDir;
        this.EWDir = EWDir;
        reports++;
    }

    public int getNumber() {
        return number;
    }

    public void setX(double x) {
        this.xCoordinate = x;
    }

    public double getX() {
        return xCoordinate;
    }

    public void setY(double y) {
        this.yCoordinate = y;
    }

    public double getY() {
        return yCoordinate;
    }

    public String getDate() {
        return new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(submitted);
    }

    public User getReporter() {
        return reporter;
    }

    public void setVerifier(User verifier) {
        this.verifier = verifier;
    }

    public User getVerifier() {
        return verifier;
    }

    public String getType() {
        return type;
    }

    public void setCondition(String Condition) {
        this.condition = Condition;
    }

    public String getCondition() {
        return condition;
    }

    public static int getReports() {
        return reports;
    }

    public void setNumber(int num) {
        number = num;
    }

    public String toString() {
        return type;
    }

    public String getNSDir() {
        return NSDir;
    }

    public String getEWDir() {
        return EWDir;
    }
}