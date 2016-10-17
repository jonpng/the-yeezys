package controller;

/**
 * Created by Brandon on 10/12/16.
 */

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import model.Report;
import model.User;
import model.ReportList;
import fxapp.MainFXApplication;
import java.util.ArrayList;
import javafx.collections.ObservableList;


public class ReportListController {

    private MainFXApplication screen;
    private ReportList<Report> reports;
    private User user;

    @FXML
    private ListView<Report> reportList;

    @FXML
    private Label noReports;

    @FXML
    private Button viewReport;

    @FXML
    private Button addReport;

    @FXML
    private Button verifyReport;

    /**
     * Sets the main application using this instance of ReportListController
     * @param screen application using the controller.
     */
    public void setMain(MainFXApplication screen) {
        this.screen = screen;
    }

    /**
     * Loads the user trying to access the report list.
     * @param user User trying to access the report list/
     */
    public void loadUser(User user) {
        this.user = user;
    }

    /**
     * Loads reports that are currently in the report list.
     */
    public void loadReports() {
        reports = screen.getReports();
        if (reports.size() != 0) {
            noReports.setVisible(false);
        }
        reportList.setItems(reports);
    }

    @FXML
    /**
     * Loads the view report screen when user selects a report to view.
     */
    private void handleViewRep() {
        if (reportList.getItems().size() == 0) {
            return;
        }
        screen.init(6);
    }

    @FXML
    /**
     * Loads the add report screen when user elects to add a report.
     */
    private void handleAddRep() {
        screen.init(5);
    }

    @FXML
    /**
     * Loads the verify report screen when worker elects to verify report.
     */
    private void handleVerifyRep() {

    }

    @FXML
    /**
     * Backs out of report screen when user hits the back button.
     */
    private void handleBack() {
        screen.init(1);
    }

    /**
     * Gets the selected report from the ListView.
     * @return Selected Report.
     */
    public Report getSelection() {
        return reportList.getSelectionModel().getSelectedItem();
    }
}
