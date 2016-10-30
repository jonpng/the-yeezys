package controller;

/**
 * Created by Brandon on 10/12/16.
 */

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Report;
import model.User;

public class QualityReportScreenController {

    private MainFXApplication screen;
    private Report selection;

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
    private Label type;

    @FXML
    private Label srcLocation;
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
    public void loadReport(Report report) {
        selection = report;

        String day = selection.getDate();
        User reporter = selection.getReporter();
        String ns = selection.getNSDir();
        String ew = selection.getEWDir();
        String reportName = selection.getReportName();
        String reportCondition = selection.getCondition();
        int num = selection.getNumber();
        double lat = Math.abs(selection.getX());
        double lon = Math.abs(selection.getY());


        srcLocation.setText(new String(lat + " " + ns + " " + lon + " " + ew));
        number.setText(Integer.toString(num));
        date.setText(day);
        srcName.setText(reportName);
        name.setText(reporter.getName());
        condition.setText(reportCondition);
        type.setText(selection.getType());

        number.setVisible(true);
        date.setVisible(true);
        srcName.setVisible(true);
        name.setVisible(true);
        srcLocation.setVisible(true);
        condition.setVisible(true);
        type.setVisible(true);
    }

    @FXML
    /**
     * Backs the user out of the report screen.
     */
    private void handleBack() {
        screen.init(4);
    }
}