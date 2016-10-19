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

public class WaterAvailabilityScreenController implements Initializable, MapComponentInitializedListener {

    @FXML
    private GoogleMapView view;
    private GoogleMap map;
    private MainFXApplication app;

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

        ReportList<Report> r = app.getReports();
        for (int i = 0; i < r.size(); i++) {
            Report report = r.get(i);
            MarkerOptions option = new MarkerOptions();
            option.label(report.getType())
                    .position(new LatLong(report.getX(), report.getY()))
                    .visible(true);
            Marker marker = new Marker(option);
            map.addMarker(marker);
        }
        view.addMapInializedListener(this);
    }

    @FXML
    private void handleBack() {
        app.init(4);
    }
}
