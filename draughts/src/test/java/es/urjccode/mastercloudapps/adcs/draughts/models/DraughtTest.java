package es.urjccode.mastercloudapps.adcs.draughts.models;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
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
        Coordinate coordinate = new Coordinate(5, 2);
        assertFalse(game.getPiece(coordinate).isBlocked(game.getBoard(), coordinate));
    }

    @Test
    public void testIsWhiteDraughtBlockedWhenSorroundedWithEnemies() {
        Game game = new GameBuilder()
            .row("        ")
            .row("        ")
            .row("        ")
            .row("n   n   ")
            .row(" n n    ")
            .row("  B     ")
            .row(" n n    ")
            .row("n   n   ")
            .turn(new Turn())
            .build();
        Coordinate coordinate = new Coordinate(5, 2);
        assertTrue(game.getPiece(coordinate).isBlocked(game.getBoard(), coordinate));
    }


}
