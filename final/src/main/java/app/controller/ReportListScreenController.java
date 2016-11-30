package app.controller;

/**
 * Created by Brandon on 10/12/16.
 */

import app.fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import app.model.PersistenceManager;
import app.model.Report;
import app.model.ReportList;
import app.model.User;


public class ReportListScreenController {

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
    private Button addPurity;

    @FXML
    private Button viewPurity;

    @FXML
    private Button viewHistoricalTrends;

    @FXML
    private Button addReport;

    /**
     * Sets the main application using this instance of ReportListScreenController
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

        if (this.user.getAccountType().equals("Worker") || this.user.getAccountType().equals("Manager")) {
            addPurity.setDisable(false);
        }

        if (this.user.getAccountType().equals("Manager")) {
            viewPurity.setDisable(false);
            viewHistoricalTrends.setDisable(false);
        }
    }

    /**
     * Loads reports that are currently in the report list.
     */
    public void loadReports() {
        if (!screen.isReportLoaded()) {
            PersistenceManager.accessReports(screen, screen.getConnection());
            screen.setReportLoaded();
        }

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
        if (reportList.getItems().size() == 0 || reportList.getSelectionModel().getSelectedItem() == null) {
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
    private void handleAddQualityRep() {
        screen.init(9);
    }

    @FXML
    private void handleViewQualityRep() {
        screen.init(11);
    }

    @FXML
    /**
     * Backs out of report screen when user hits the back button.
     */
    private void handleBack() {
        screen.init(1);
    }

    @FXML
    private void handleViewHistory() {
        screen.init(13);
    }

    @FXML
    /**
     * Loads the map.
     */
    private void handleMap() {
        screen.init(7);
    }

    /**
     * Gets the selected report from the ListView.
     * @return Selected Report.
     */
    public Report getSelection() {
        return reportList.getSelectionModel().getSelectedItem();
    }
}
