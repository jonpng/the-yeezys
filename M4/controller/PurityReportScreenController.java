package controller;

/**
 * Created by Brandon on 10/12/16.
 */

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.PurityReport;

public class PurityReportScreenController {

    private MainFXApplication screen;
    private PurityReport selection;

    @FXML
    private Label srcName;

    @FXML
    private Label name;

    @FXML
    private Label number;

    @FXML
    private Label condition;

    @FXML
    private Label date;

    @FXML
    private Label srcLocation;

    @FXML
    private Label virusPPM;

    @FXML
    private Label contaminantPPM;

    /**
     * Sets the controller's main to the application.
     * @param screen The application using this controller.
     */
    public void setMain(MainFXApplication screen) {
        this.screen = screen;
    }

    /**
     * Loads and displays a report.
     * @param report Report that gets loaded and displayed.
     */
    public void loadReport(PurityReport report) {
        selection = report;

        String day = selection.getDate();
        String reporter = selection.getReporter();
        String ns = selection.getNSDir();
        String ew = selection.getEWDir();
        String reportName = selection.getReportName();
        String reportCondition = selection.getCondition();
        int num = selection.getNumber();
        double lat = Math.abs(selection.getX());
        double lon = Math.abs(selection.getY());


        srcLocation.setText(lat + " " + ns + " " + lon + " " + ew);
        number.setText(Integer.toString(num));
        date.setText(day);
        srcName.setText(reportName);
        name.setText(reporter);
        condition.setText(reportCondition);
        virusPPM.setText(new Double(selection.getVirusPPM()).toString());
        contaminantPPM.setText(new Double(selection.getContainmentPPM()).toString());

        number.setVisible(true);
        date.setVisible(true);
        srcName.setVisible(true);
        name.setVisible(true);
        srcLocation.setVisible(true);
        condition.setVisible(true);
        virusPPM.setVisible(true);
        contaminantPPM.setVisible(true);

        selection.addDate();
    }

    @FXML
    /**
     * Backs the user out of the report screen.
     */
    private void handleBack() {
        screen.init(11);
    }
}