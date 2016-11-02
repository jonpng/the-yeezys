package controller;

/**
 * Created by Brandon on 10/12/16.
 */

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Report;
import model.ReportList;
import model.User;

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

    @FXML
    private ComboBox<String> srcType;

    @FXML
    private ComboBox<String> srcCondition;


    /**
     * Sets the main app this controller pertains to.
     * @param screen Main app using this controller.
     */
    public void setMain(MainFXApplication screen) {
        this.screen = screen;
    }

    /**
     * Loads user that is adding report.
     * @param user User adding a report.
     */
    public void loadUser(User user) {
        this.user = user;
    }

    @FXML
    /**
     * Action taken when user clicks the Add Button
     */
    private void handleAdd() {
        String latitude = latCoor.getCharacters().toString();
        double lat = 0;
        try {
            lat = Double.parseDouble(latitude);
            if (lat > 180) {
                coorErr.setVisible(true);
                return;
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
                return;
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

        if (nsBtn.getText().equalsIgnoreCase("S")) {
            lat *= -1;
        }
        if (ewBtn.getText().equalsIgnoreCase("W")) {
            longi *= -1;
        }

        String type = srcType.getValue();
        String condition = srcCondition.getValue();

        Report report = new Report(lat, longi, name, condition, user.getUsername(), nsBtn.getText(), ewBtn.getText(), type);

        ReportList<Report> reports = screen.getReports();
        reports.add(report);
        screen.init(4);
    }

    @FXML
    /**
     * Action taken when user clicks the Cancel button.
     */
    private void handleCancel() {
        screen.init(4);
    }

    @FXML
    /**
     * Action taken when user toggles N/S button.
     */
    private void handleNS() {
        String dir = nsBtn.getText();
        if (dir.equals("N")) {
            nsBtn.setText("S");
        } else {
            nsBtn.setText("N");
        }
    }

    @FXML
    /**
     * Action taken when user toggles E/W button.
     */
    private void handleEW() {
        String dir = ewBtn.getText();
        if (dir.equals("E")) {
            ewBtn.setText("W");
        } else {
            ewBtn.setText("E");
        }
    }
}
