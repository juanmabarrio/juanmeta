package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

public class CommandView extends SubView {

    private static final String[] COLORS = {"blancas", "negras"};

    private static final String MESSAGE = "Derrota!!! No puedes mover tus fichas!!!";

    CoordinateView coordinateView ;

    public CommandView(){
        super();
        coordinateView = new CoordinateView();
    }

    public void interact(PlayController playController) {
        String color = CommandView.COLORS[playController.getColor().ordinal()];
        Error error = null;
        GameView gameView = new GameView();

        do {
            Coordinate[] coordinates = coordinateView.readOriginAndTarget("Mueven las " + color + ": ");
            error = playController.move(coordinates[0], coordinates[1]);
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
