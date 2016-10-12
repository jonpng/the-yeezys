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

    public void setMain(MainFXApplication screen) {
        this.screen = screen;
    }

    public void loadUser(User user) {
        this.user = user;
    }

    public void loadReports() {
        reports = screen.getReports();
        if (reports.size() != 0) {
            noReports.setVisible(false);
        }
        reportList.setItems(reports);
    }

    @FXML
    private void handleViewRep() {
        if (reportList.getItems().size() == 0) {
            return;
        }
        screen.init(6);
    }

    @FXML
    private void handleAddRep() {
        screen.init(5);
    }

    @FXML
    private void handleVerifyRep() {

    }

    @FXML
    private void handleBack() {
        screen.init(1);
    }

    public Report getSelection() {
        return reportList.getSelectionModel().getSelectedItem();
    }
}
