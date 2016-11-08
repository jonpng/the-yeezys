package controller;

/**
 * Created by Brandon on 11/2/16.
 */

import fxapp.MainFXApplication;
import model.PurityReport;
import model.ReportList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;


public class HistoricalReportSelectController {

    private MainFXApplication screen;
    private ReportList<PurityReport> reportList;
    private PurityReport report;

    @FXML
    private TextField reportField;

    @FXML
    private TextField yearField;

    @FXML
    private Label dne;

    public void setMain(MainFXApplication screen) {
        this.screen = screen;
    }

    @FXML
    private void handleBack() {
        screen.init(11);
    }

    @FXML
    private void handleContaminantReport() {
        loadReport();
        if (report == null) {
            dne.setVisible(true);
            return;
        }
        screen.init(12);
    }

    @FXML
    private void handleVirusReport() {
        loadReport();
        if (report == null) {
            dne.setVisible(true);
            return;
        }
        screen.init(12);
    }

    private void loadReports() {
        reportList = screen.getPurityReports();
    }

    private PurityReport searchReports(String name) {
        for (int i = 0; i < reportList.size(); i++) {
            PurityReport pr = reportList.get(i);
            String yearString = yearField.getText();
            if (name.equals(pr.getReportName()) && yearString.equals(pr.year())) {
                return pr;
            }
        }
        return null;
    }

    public void loadReport() {
        loadReports();
        String name = reportField.getText();
        report = searchReports(name);
    }

    public PurityReport getPReport() {
        return report;
    }
}
