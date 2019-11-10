package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

public class CommandView extends SubView {

    private static final String[] COLORS = {"blancas", "negras"};

    private static final String MESSAGE = "Derrota!!! No puedes mover tus fichas!!!";

    public CommandView(){
        super();
    }

    public void interact(PlayController playController) {
        String color = CommandView.COLORS[playController.getColor().ordinal()];
        Error error = null;
        GameView gameView = new GameView();

        do {
            CoordinateView coordinateView = new CoordinateView();
            coordinateView.readCoordinate("Mueven las " + color + ": ");
            //String command = this.console.readString("Mueven las " + color + ": ");
            //Coordinate origin = new Coordinate().fromString(command.substring(0, 2));
            //Coordinate target = new Coordinate().fromString(command.substring(3, 5));
            error = playController.move(coordinateView.getOrigin(), coordinateView.getTarget());
            if (error != null){
                console.writeln("Error!!!" + error.name());
            gameView.write(playController);
            }
        } while (error != null);
        if (playController.isBlocked()){
            this.console.write(CommandView.MESSAGE);
        }
    }

}
