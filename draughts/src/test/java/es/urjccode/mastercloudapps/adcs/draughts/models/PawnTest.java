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
    public void testIsBlackPawnBlockedWhenOnFirstColumnAndAnotherBlackBlocking(){
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
    public void testIsBlackPawnBlockedWhenOnLastColumnAndAnotherBlackBlocking(){
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

    @Test
    public void testIsWhitePawnBlockedWhenOnSecondColumnAndEnemiesBlocking(){
        Game game = new GameBuilder()
            .row("        ")
            .row("    b   ")
            .row("        ")
            .row("        ")
            .row("   n    ")
            .row("n n     ")
            .row(" b      ")
            .row("        ")
            .turn(new Turn())
            .build();
        Coordinate coordinate = new Coordinate(6,1);
        assertTrue(game.getPiece(coordinate).isBlocked(game.getBoard(), coordinate));
    }

    @Test
    public void testIsBlackPawnBlockedWhenOnSecondColumnAndTwoEnemiesBlocking(){
        Turn blackTurn = new Turn();
        blackTurn.change();
        Game game = new GameBuilder()
            .row("        ")
            .row(" n      ")
            .row("b b     ")
            .row("   b    ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .turn(blackTurn)
            .build();
        Coordinate coordinate = new Coordinate(1,1);
        assertTrue(game.getPiece(coordinate).isBlocked(game.getBoard(), coordinate));
    }

    @Test
    public void testIsWhitePawnBlockedWhenOnSecondColumnAndAnotherWhiteBlocking(){
        Game game = new GameBuilder()
            .row("        ")
            .row("    b   ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("b b     ")
            .row(" b      ")
            .row("        ")
            .turn(new Turn())
            .build();
        Coordinate coordinate = new Coordinate(6,1);
        assertTrue(game.getPiece(coordinate).isBlocked(game.getBoard(), coordinate));
    }

    @Test
    public void testIsBlackPawnBlockedWhenOnSecondColumnAndAnotherBlackBlocking(){
        Turn blackTurn = new Turn();
        blackTurn.change();
        Game game = new GameBuilder()
            .row("        ")
            .row(" n      ")
            .row("n n     ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .turn(blackTurn)
            .build();
        Coordinate coordinate = new Coordinate(1,1);
        assertTrue(game.getPiece(coordinate).isBlocked(game.getBoard(), coordinate));
    }




}
