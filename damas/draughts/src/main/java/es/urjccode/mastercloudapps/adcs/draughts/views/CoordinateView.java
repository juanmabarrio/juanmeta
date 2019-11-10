package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

public class CoordinateView extends SubView {


    private Coordinate target,origin;

    public Coordinate[]  readOriginAndTarget(String message) {
        String command = this.console.readString(message);
        this.origin = new Coordinate().fromString(command.substring(0, 2));
        this.target = new Coordinate().fromString(command.substring(3, 5));
        Coordinate[] coordinates = {origin,target};
        return coordinates;

    }

    public Coordinate getTarget() {
        return target;
    }

    public Coordinate getOrigin() {
        return origin;
    }

}
