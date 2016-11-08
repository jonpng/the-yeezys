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
import model.PersistenceManager;
import model.PurityReport;
import model.ReportList;
import model.User;

public class AddPurityReportScreenController {

    private MainFXApplication screen;
    private User user;

    @FXML
    private TextField srcName;

    @FXML
    private TextField latCoord;

    @FXML
    private TextField longCoord;

    @FXML
    private Label errorMsg;

    @FXML
    private Label coordErr;

    @FXML
    private Button nsBtn;

    @FXML
    private Button ewBtn;

    @FXML
    private TextField virusPPM;

    @FXML
    private TextField contaminantPPM;

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
        String latitude = latCoord.getCharacters().toString();
        double lat = 0;
        try {
            lat = Double.parseDouble(latitude);
            if (lat > 180) {
                coordErr.setVisible(true);
                return;
            }
        } catch (Exception e) {
            coordErr.setVisible(true);
            return;
        }

        String longitude = longCoord.getCharacters().toString();
        double longi = 0;
        try {
            longi = Double.parseDouble(longitude);
            if (longi > 180) {
                coordErr.setVisible(true);
                return;
            }
        } catch (Exception e) {
            coordErr.setVisible(true);
            return;
        }

        String name = srcName.getCharacters().toString();
        if (name == null) {
            errorMsg.setVisible(true);
            return;
        }

        double virusMeasure = 0;
        try {
            if (virusPPM.getCharacters().toString().isEmpty()) {
                throw new IllegalArgumentException();
            }

            virusMeasure = Double.parseDouble(virusPPM.getCharacters().toString());
        } catch (Exception e) {
            errorMsg.setVisible(true);
            return;
        }

        double contaminantMeasure = 0;
        try {
            if (contaminantPPM.getCharacters().toString().isEmpty()) {
                throw new IllegalArgumentException();
            }

            contaminantMeasure = Double.parseDouble(contaminantPPM.getCharacters().toString());
        } catch (Exception e) {
            errorMsg.setVisible(true);
            return;
        }

        if (nsBtn.getText().equalsIgnoreCase("S")) {
            lat *= -1;
        }
        if (ewBtn.getText().equalsIgnoreCase("W")) {
            longi *= -1;
        }
        PurityReport report = new PurityReport(lat, longi, name, srcCondition.getValue(), user.getUsername(),
                nsBtn.getText(), ewBtn.getText(), virusMeasure, contaminantMeasure);

        PersistenceManager.insertPurityReport(report.getNumber(), report.getX(), report.getY(), report.getTimestamp(),
                report.getReporter(), report.getReportName(), report.getCondition(), report.getVirusPPM(),
                report.getContainmentPPM(), report.getNSDir(), report.getEWDir(), screen.getConnection());

        ReportList<PurityReport> purityReports = screen.getPurityReports();
        purityReports.add(report);

        if (user.getAccountType().equals("Manager")) {
            screen.init(11);
        } else {
            screen.init(4);
        }
    }

    @FXML
    /**
     * Action taken when user clicks the Cancel button.
     */
    private void handleCancel() {
        if (user.getAccountType().equals("Manager")) {
            screen.init(11);
        } else {
            screen.init(4);
        }
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
