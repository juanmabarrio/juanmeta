package es.urjccode.mastercloudapps.adcs.draughts.models;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PawnTest {

    @Test
    public void testIsPawnBlocked(){
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
        assertTrue(game.getPiece(new Coordinate(7,1)).isBlocked());

    }



}
