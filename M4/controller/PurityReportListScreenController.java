package controller;

/**
 * Created by Brandon on 10/12/16.
 */

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.PurityReport;
import model.ReportList;
import model.User;


public class PurityReportListScreenController {

    private MainFXApplication screen;
    private ReportList<PurityReport> reports;
    private User user;

    @FXML
    private ListView<PurityReport> reportList;

    @FXML
    private Label noReports;

    @FXML
    private Button viewReport;

    @FXML
    private Button viewHistory;

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
    }

    /**
     * Loads reports that are currently in the report list.
     */
    public void loadReports() {
        reports = screen.getPurityReports();
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
        screen.init(10);
    }

    @FXML
    /**
     * Loads the add report screen when user elects to add a report.
     */
    private void handleAddRep() {
        screen.init(9);
    }

    @FXML
    private void handleViewHistory() {
            screen.init(13);
    }

    @FXML
    /**
     * Backs out of report screen when user hits the back button.
     */
    private void handleBack() {
        screen.init(4);
    }

    /**
     * Gets the selected report from the ListView.
     * @return Selected Report.
     */
    public PurityReport getSelection() {
        return reportList.getSelectionModel().getSelectedItem();
    }
}
