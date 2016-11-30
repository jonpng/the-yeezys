package app.controller;

/**
 * Created by Brandon on 10/31/16.
 */

import app.fxapp.MainFXApplication;
import app.model.PurityReport;
import app.model.PointList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.Axis;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.chart.XYChart.Data;
import java.util.Date;

public class GraphScreenController {

    @FXML
    private LineChart graph;

    private MainFXApplication screen;
    private PurityReport report;


    /**
     * Screen that becomes linked to this controller.
     * @param screen screen linked to the controller.
     */
    public void setMain(MainFXApplication screen) {
        this.screen = screen;
    }

    @FXML
    private void handleBack() {
        screen.init(11);
    }

    /**
     * Loads a Purity Report into the graph controller to display on graph.
     * @param r PurityReport loaded in.
     */
    public void loadReport(PurityReport r) {
        report = r;
    }

    /**
     * Draws the graph.
     */
    @SuppressWarnings("unchecked")
    public void draw() {
        PointList<String> dateList = new PointList<String>();
        PointList<Double> dataList = new PointList<Double>();
        PointList<Data<String, Double>> points = new PointList<Data<String, Double>>();

        dateList.add(report.getDate());
        dataList.add(report.getContainmentPPM());

        for (int i = 0; i < dateList.size(); i++) {
            Data<String, Double> point = new Data<String, Double>(dateList.get(i), dataList.get(i));
            points.add(point);
        }

        Series<String, Double> series = new Series<String, Double>(points);

        PointList<Series<String, Double>> pointList = new PointList<Series<String, Double>>();
        pointList.add(series);

        //noinspection unchecked,unchecked
        graph.setData(pointList);
    }
}
