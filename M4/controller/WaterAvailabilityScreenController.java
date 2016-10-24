package controller;

/**
 * Created by Brandon on 10/19/16.
 */

import fxapp.MainFXApplication;
import model.ReportList;
import model.Report;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

import com.lynden.gmapsfx.javascript.event.UIEventHandler;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import netscape.javascript.JSObject;
import java.util.ArrayList;

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
            option.label(report.getType())
                    .position(new LatLong(report.getX(), report.getY()))
                    .visible(true);
            markerNames.add(report.getType());
            Marker marker = new Marker(option);
            map.addUIEventHandler(marker, UIEventType.click, (JSObject obj) -> {
                for (int j = 0; j < reports.size(); j++) {
                    Report rep = reports.get(j);
                    for (int k = 0; k < markerNames.size(); k++) {
                        if (rep.getType().equals(markerNames.get(k))) {
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
