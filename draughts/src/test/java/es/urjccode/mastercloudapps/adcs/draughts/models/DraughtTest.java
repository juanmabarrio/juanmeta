package es.urjccode.mastercloudapps.adcs.draughts.models;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DraughtTest {

    @Test
    public void testIsWhiteDraughtBlockedWhenOnFirstColumnAndTwoEnemiesBlocking() {
        Game game = new GameBuilder()
            .row("        ")
            .row("    b   ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("  n     ")
            .row(" n      ")
            .row("B       ")
            .turn(new Turn())
            .build();
        Coordinate coordinate = new Coordinate(7, 0);
        assertTrue(game.getPiece(coordinate).isBlocked(game.getBoard(), coordinate));
    }

    @Test
    public void testIsBlackDraughtBlockedWhenOnFirstColumnAndTwoEnemiesBlocking() {
        Turn blackTurn = new Turn();
        blackTurn.change();
        Game game = new GameBuilder()
            .row("N       ")
            .row(" b      ")
            .row("  b     ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .turn(blackTurn)
            .build();
        Coordinate coordinate = new Coordinate(0, 0);
        assertTrue(game.getPiece(coordinate).isBlocked(game.getBoard(), coordinate));
    }

    @Test
    public void testIsWhiteDraughtBlockedWhenOnFirstColumnAndAnotherWhiteBlocking() {
        Game game = new GameBuilder()
            .row("        ")
            .row("    b   ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row(" b      ")
            .row("B       ")
            .turn(new Turn())
            .build();
        Coordinate coordinate = new Coordinate(7, 0);
        assertTrue(game.getPiece(coordinate).isBlocked(game.getBoard(), coordinate));
    }

    @Test
    public void testIsBlackDraughtBlockedWhenOnFirstColumnAndAnotherBlackBlocking() {
        Turn blackTurn = new Turn();
        blackTurn.change();
        Game game = new GameBuilder()
            .row("N       ")
            .row(" n      ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .turn(blackTurn)
            .build();
        Coordinate coordinate = new Coordinate(0, 0);
        assertTrue(game.getPiece(coordinate).isBlocked(game.getBoard(), coordinate));
    }

}
