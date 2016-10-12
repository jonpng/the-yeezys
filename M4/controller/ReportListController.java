package controller;

/**
 * Created by Brandon on 10/12/16.
 */

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import model.Report;
import fxapp.MainFXApplication;
import java.util.ArrayList;
import javafx.collections.ObservableList;


public class ReportListController {

    private MainFXApplication screen;
    private ArrayList<Report> reports;

    @FXML
    private ListView<Report> reportListView;

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

    public void loadReports(ArrayList<Report> reports) {
        this.reports = reports;
        if (reports.size() == 0) {
            return;
        }
        noReports.setVisible(false);
        reportListView.setItems((ObservableList<Report>)reports);
    }

    @FXML
    private void handleViewRep() {
        screen.init(5);
    }

    @FXML
    private void handleAddRep() {
        screen.init(6);
    }

    @FXML
    private void handleVerifyRep() {

    }

    @FXML
    private void handleBack() {
        screen.init(1);
    }
}
