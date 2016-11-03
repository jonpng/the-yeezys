package model;

/**
 * Created by Steve on 10/30/2016.
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PurityReport extends Report{
    private static int reports = 0;
    private double virusPPM;
    private double contaminantPPM;
    private ArrayList<String> dates;
    private ArrayList<Double> contaminants;
    private ArrayList<Double> viruses;
    private String date;
    private int number;

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
    public PurityReport(double x, double y, String name, String condition, String reporter, String NSDir, String EWDir,
                        double virusPPM, double contaminantPPM) {
        super(x, y, name, condition, reporter, NSDir, EWDir, null);
        this.virusPPM = virusPPM;
        this.contaminantPPM = contaminantPPM;
        contaminants = new ArrayList<Double>();
        contaminants.add(contaminantPPM);

        viruses = new ArrayList<Double>();
        viruses.add(virusPPM);

        dates = new ArrayList<String>();

        this.reports++;
        this.number = this.reports;
    }

    public int getNumber() {
        return number;
    }

    public double getContainmentPPM() {
        return contaminantPPM;
    }

    public double getVirusPPM() {
        return virusPPM;
    }

    public void setContainmentPPM(double contaminantPPM) {
        this.contaminantPPM = contaminantPPM;
        contaminants.add(contaminantPPM);
    }

    public void setVirusPPM(double virusPPM) {
        this.virusPPM = virusPPM;
    }

    public static int getReports() {
        return reports;
    }

    public void addDate() {
        dates.add(new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new Date()));
    }

    public ArrayList<String> getDates() {
        return dates;
    }

    public ArrayList<Double> getContaminants() {
        return contaminants;
    }

    public ArrayList<Double> getViruses() {
        return viruses;
    }

    public String year() {
        String year = super.date().toString();
        return year.substring(year.length()-4);
    }
}
