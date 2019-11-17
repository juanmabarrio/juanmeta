package es.urjccode.mastercloudapps.adcs.draughts.models;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DraughtTest {

    @Test
    public void testIsWhiteDraughtNotBlockedWhenOnSecondRowAndSpaceBehind() {
        Game game = new GameBuilder()
            .row("        ")
            .row("        ")
            .row("        ")
            .row("n   n    ")
            .row(" n n    ")
            .row("  B     ")
            .row("        ")
            .row("        ")
            .turn(new Turn())
            .build();
        Coordinate coordinate = new Coordinate(7, 0);
        assertTrue(game.getPiece(coordinate).isBlocked(game.getBoard(), coordinate));
    }
}
