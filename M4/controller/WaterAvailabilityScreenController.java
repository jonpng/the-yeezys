package controller;

/**
 * Created by Brandon on 10/19/16.
 */

import fxapp.MainFXApplication;
import com.lynden.gmapsfx.GoogleMapView;
import javafx.fxml.FXML;

public class WaterAvailabilityScreenController {

    @FXML
    private GoogleMapView map;
    private MainFXApplication screen;

    public void setMain(MainFXApplication screen) {
        this.screen = screen;
    }


}
