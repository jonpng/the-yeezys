package controller;

/**
 * Created by Brandon on 10/19/16.
 */

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.*;
import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.Report;
import model.ReportList;
import netscape.javascript.JSObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class WaterAvailabilityScreenController implements Initializable, MapComponentInitializedListener {

    @FXML
    private GoogleMapView view;
    private GoogleMap map;
    private MainFXApplication app;
    private ReportList<Report> reports;
    private ArrayList<String> markerNames = new ArrayList<String>();

    public void setMain(MainFXApplication app) {
        this.app = app;
    }

    @Override
    public void initialize(URL location, ResourceBundle rb) {
        view.addMapInializedListener(this);
    }

    @Override
    public void mapInitialized() {
        MapOptions options = new MapOptions();

        options.center(new LatLong(33.749, -84.3880))
                .mapType(MapTypeIdEnum.ROADMAP)
                .zoomControl(false)
                .zoom(12)
                .rotateControl(false)
                .scaleControl(false)
                .panControl(false)
                .streetViewControl(false);

        map = view.createMap(options);

        for (int i = 0; i < reports.size(); i++) {
            Report report = reports.get(i);
            MarkerOptions option = new MarkerOptions();
            option.label(report.getReportName())
                    .position(new LatLong(report.getX(), report.getY()))
                    .visible(true);
            markerNames.add(report.getReportName());
            Marker marker = new Marker(option);
            map.addUIEventHandler(marker, UIEventType.click, (JSObject obj) -> {
                for (int j = 0; j < reports.size(); j++) {
                    Report rep = reports.get(j);
                    for (int k = 0; k < markerNames.size(); k++) {
                        if (rep.getReportName().equals(markerNames.get(k))) {
                            app.setSelected(rep);
                            app.init(8);
                            return;
                        }
                    }
                }
            });
            map.addMarker(marker);
        }
        view.addMapInializedListener(this);
    }

    @FXML
    private void handleBack() {
        app.init(4);
    }

    public void loadReports(ReportList<Report> reports) {
        this.reports = reports;
    }
}
