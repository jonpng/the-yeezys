package controller;

/**
 * Created by Brandon on 10/31/16.
 */

import fxapp.MainFXApplication;
import model.PurityReport;
import model.Report;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.Axis;
import java.util.Date;

public class GraphScreenController {

    @FXML
    private LineChart graph;

    private Axis<Date> x;
    private Axis<Double> y;

    private MainFXApplication screen;
    private PurityReport report;

    public void setMain(MainFXApplication screen) {
        this.screen = screen;
    }

    @FXML
    private void handleBack() {
        screen.init(11);
    }

    public void loadReport(PurityReport r) {
        report = r;
    }
}
