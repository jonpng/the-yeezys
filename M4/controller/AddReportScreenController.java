package controller;

/**
 * Created by Brandon on 10/12/16.
 */

import javafx.fxml.FXML;

import fxapp.MainFXApplication;
import model.User;
import model.Report;
import model.ReportList;

import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class AddReportScreenController {

    private MainFXApplication screen;
    private User user;

    @FXML
    private TextField srcName;

    @FXML
    private TextField latCoor;

    @FXML
    private TextField longCoor;

    @FXML
    private Label errorMsg;

    @FXML
    private Label coorErr;

    @FXML
    private Button nsBtn;

    @FXML
    private Button ewBtn;

    public void setMain(MainFXApplication screen) {
        this.screen = screen;
    }

    public void loadUser(User user) {
        this.user = user;
    }

    @FXML
    private void handleAdd() {
        String latitude = latCoor.getCharacters().toString();
        double lat = 0;
        try {
            lat = Double.parseDouble(latitude);
            if (lat > 180) {
                coorErr.setVisible(true);
            }
        } catch (Exception e) {
            coorErr.setVisible(true);
            return;
        }

        String longitude = longCoor.getCharacters().toString();
        double longi = 0;
        try {
            longi = Double.parseDouble(longitude);
            if (longi > 180) {
                coorErr.setVisible(true);
            }
        } catch (Exception e) {
            coorErr.setVisible(true);
            return;
        }

        String name = srcName.getCharacters().toString();
        if (name == null) {
            errorMsg.setVisible(true);
            return;
        }

        Report report = new Report(lat, longi, name, null, user, nsBtn.getText(), ewBtn.getText());
        report.setNumber(Report.getReports() + 1);

        ReportList<Report> reports = screen.getReports();
        reports.add(report);
        screen.init(4);
    }

    @FXML
    private void handleCancel() {
        screen.init(4);
    }

    @FXML
    private void handleNS() {
        String dir = nsBtn.getText();
        if (dir.equals("N")) {
            nsBtn.setText("S");
        } else {
            nsBtn.setText("N");
        }
    }

    @FXML
    private void handleEW() {
        String dir = ewBtn.getText();
        if (dir.equals("E")) {
            ewBtn.setText("W");
        } else {
            ewBtn.setText("E");
        }
    }
}
