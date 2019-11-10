package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;

public class CoordinateView extends SubView {

    public Coordinate[]  readOriginAndTarget(String message) {
        String command;
        Error error=null;
        Coordinate origin,target;
        do {
            command = this.console.readString(message);
            origin = new Coordinate().fromString(command.substring(0, 2));
            target = new Coordinate().fromString(command.substring(3, 5));
            if (!origin.isValid() || !target.isValid()) {
                error = Error.OUT_COORDINATE;
                this.console.writeln(error.name());

            }
        }while(null!=error);
        return new Coordinate[]{origin,target};
    }

}
