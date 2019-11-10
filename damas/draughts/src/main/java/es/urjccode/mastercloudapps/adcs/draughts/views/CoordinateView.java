package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

public class CoordinateView extends SubView {

    public Coordinate[]  readOriginAndTarget(String message) {
        String command = this.console.readString(message);
        Coordinate origin = new Coordinate().fromString(command.substring(0, 2));
        Coordinate target = new Coordinate().fromString(command.substring(3, 5));
        Coordinate[] coordinates = {origin,target};
        return coordinates;

    }

}
