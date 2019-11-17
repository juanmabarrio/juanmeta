package es.urjccode.mastercloudapps.adcs.draughts.models;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PawnTest {

    @Test
    public void testIsWhitePawnBlockedWhenOnFirstColumnAndTwoEnemiesBlocking(){
        Game game = new GameBuilder()
            .row("        ")
            .row("    b   ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("  n     ")
            .row(" n      ")
            .row("b       ")
            .turn(new Turn())
            .build();
        Coordinate coordinate = new Coordinate(7,0);
        assertTrue(game.getPiece(coordinate).isBlocked(game.getBoard(), coordinate));
    }

    @Test
    public void testIsBlackPawnBlockedWhenOnFirstColumnAndTwoEnemiesBlocking(){
        Turn blackTurn = new Turn();
        blackTurn.change();
        Game game = new GameBuilder()
            .row("n       ")
            .row(" b      ")
            .row("  b     ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .turn(blackTurn)
            .build();
        Coordinate coordinate = new Coordinate(0,0);
        assertTrue(game.getPiece(coordinate).isBlocked(game.getBoard(), coordinate));
    }

    @Test
    public void testIsWhitePawnBlockedWhenOnFirstColumnAndAnotherWhiteBlocking(){
        Game game = new GameBuilder()
            .row("        ")
            .row("    b   ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row(" b      ")
            .row("b       ")
            .turn(new Turn())
            .build();
        Coordinate coordinate = new Coordinate(7,0);
        assertTrue(game.getPiece(coordinate).isBlocked(game.getBoard(), coordinate));
    }

    @Test
    public void testIsBlackPawnBlockedWhenOnFirstColumnAndAnotherWhiteBlocking(){
        Turn blackTurn = new Turn();
        blackTurn.change();
        Game game = new GameBuilder()
            .row("n       ")
            .row(" n      ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .turn(blackTurn)
            .build();
        Coordinate coordinate = new Coordinate(0,0);
        assertTrue(game.getPiece(coordinate).isBlocked(game.getBoard(), coordinate));
    }


    @Test
    public void testIsWhitePawnBlockedWhenOnLastColumnAndTwoEnemiesBlocking(){
        Game game = new GameBuilder()
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("     n  ")
            .row("      n ")
            .row("       b")
            .turn(new Turn())
            .build();
        Coordinate coordinate = new Coordinate(7,7);
        assertTrue(game.getPiece(coordinate).isBlocked(game.getBoard(), coordinate));
    }

    @Test
    public void testIsBlackPawnBlockedWhenOnLastColumnAndTwoEnemiesBlocking(){
        Turn blackTurn = new Turn();
        blackTurn.change();
        Game game = new GameBuilder()
            .row("       n")
            .row("      b ")
            .row("     b  ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .turn(blackTurn)
            .build();
        Coordinate coordinate = new Coordinate(0,7);
        assertTrue(game.getPiece(coordinate).isBlocked(game.getBoard(), coordinate));
    }

    @Test
    public void testIsWhitePawnBlockedWhenOnLastColumnAndAnotherWhiteBlocking(){
        Game game = new GameBuilder()
            .row("        ")
            .row("    b   ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("      b ")
            .row("       b")
            .turn(new Turn())
            .build();
        Coordinate coordinate = new Coordinate(7,7);
        assertTrue(game.getPiece(coordinate).isBlocked(game.getBoard(), coordinate));
    }

    @Test
    public void testIsBlackPawnBlockedWhenOnLastColumnAndAnotherWhiteBlocking(){
        Turn blackTurn = new Turn();
        blackTurn.change();
        Game game = new GameBuilder()
            .row("       n")
            .row("      n ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .turn(blackTurn)
            .build();
        Coordinate coordinate = new Coordinate(0,7);
        assertTrue(game.getPiece(coordinate).isBlocked(game.getBoard(), coordinate));
    }




}
