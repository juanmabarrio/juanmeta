package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GameWithDraughtsTest {

    @Mock
    Turn turn;

    @Mock
    Piece piece;
    
    @Mock
    Board board;

    @InjectMocks
    Game game;

    @Before
    public void before(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGivenGameWhenWhitePawnAtLimitThenNewDraugts(){
        Coordinate origin = new Coordinate(1,0);
        Coordinate target = new Coordinate(0,1);
        
        when (turn.getColor()).thenReturn(Color.WHITE);
        when(board.isEmpty(origin)).thenReturn(false);
        when(board.getColor(origin)).thenReturn(Color.WHITE);
        when(board.getPiece(origin)).thenReturn(piece);
        when(piece.isCorrect(origin, target, board)).thenReturn(null);
        when(board.remove(origin)).thenReturn(new Pawn(Color.WHITE));
        
        when(board.getPiece(target)).thenReturn(new Pawn(Color.WHITE));
        game.move(origin, target);
        verify(board).remove(target);
        verify(board).put(any(Coordinate.class), any(Draught.class));
    }

    @Test
    public void testGivenGameWhenPawnAtLimitAndEatingThenNewDraugts(){
        Coordinate origin = new Coordinate(2,1);
        Coordinate target = new Coordinate(0,3);
        when (turn.getColor()).thenReturn(Color.WHITE);
        when(board.isEmpty(origin)).thenReturn(false);
        when(board.getColor(origin)).thenReturn(Color.WHITE);
        when(board.getPiece(origin)).thenReturn(piece);
        when(piece.isCorrect(origin, target, board)).thenReturn(null);
        when(board.remove(origin)).thenReturn(new Pawn(Color.WHITE));
        when(board.getPiece(target)).thenReturn(new Pawn(Color.WHITE));
        game.move(origin, target);
        verify(board).remove(origin.betweenDiagonal(target));
        verify(board).remove(target);
        verify(board).put(any(Coordinate.class), any(Draught.class));
    }

    @Test
    public void testGivenGameWhenBlackPawnAtLimitThenNewDraugts(){
        Coordinate origin = new Coordinate(6,3);
        Coordinate target = new Coordinate(7,2);
        when (turn.getColor()).thenReturn(Color.BLACK);
        when(board.isEmpty(origin)).thenReturn(false);
        when(board.getColor(origin)).thenReturn(Color.BLACK);
        when(board.getPiece(origin)).thenReturn(piece);
        when(piece.isCorrect(origin, target, board)).thenReturn(null);
        when(board.remove(origin)).thenReturn(new Pawn(Color.BLACK));
        when(board.getPiece(target)).thenReturn(new Pawn(Color.BLACK));
        game.move(origin, target);
        verify(board).remove(target);
        verify(board).put(any(Coordinate.class), any(Draught.class));
    }


    @Test
    public void testGivenGameWhenDraughtMovingMoreThanTwoThenIsCorrect() {
        Game game = new GameBuilder()
                   .row("")
                   .row("")
                   .row("")
                   .row("")
                   .row("")
                   .row("")
                   .row("")
                   .row("B")
                   .turn(new Turn())
                   .build();
        assertNull(game.isCorrect(new Coordinate(7,0),new Coordinate(0,7)));
    }

    @Test
    public void testGivenGameWhenDraughtMovingMoreThanTwoButThereAreTwoPiecesTogetherInTheDiagonalThenError() {
        Game game = new GameBuilder()
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("  n     ")
            .row(" n      ")
            .row("B       ")
            .turn(new Turn())
            .build();
        assertEquals(Error.TOO_MANY_PIECES_IN_BETWEEN
                    ,game.isCorrect(new Coordinate(7,0),new Coordinate(0,7)));
    }

    @Test
    public void testGivenGameWhenDraughtMovingMoreThanTwoSquaresButThereIsOnePieceSameColorInBetweenTogetherInTheDiagonalThenError() {
        Game game = new GameBuilder()
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("  n     ")
            .row(" n      ")
            .row("B       ")
            .turn(new Turn())
            .build();
        assertEquals(Error.TOO_MANY_PIECES_IN_BETWEEN
            ,game.isCorrect(new Coordinate(7,0),new Coordinate(0,7)));
    }

    @Test
    public void testGivenGameWhenDraughtMovingMoreThanTwoSquaresButThereIsOneEnemyPieceInTheDiagonalThenOK() {
        Game game = new GameBuilder()
            .row("        ")
            .row("      n ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("B       ")
            .turn(new Turn())
            .build();
        assertNull(game.isCorrect(new Coordinate(7,0),new Coordinate(0,7)));
    }

    @Test
    public void testGivenGameWhenDraughtMovingMoreThanTwoSquaresButOneOfMyPiecesInTheDiagonalThenError() {
        Turn turn = new Turn();
        turn.change();
        Game game = new GameBuilder()
            .row("        ")
            .row("      n ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("N       ")
            .turn(turn)
            .build();
        assertEquals(Error.CANT_EAT_YOUR_PIECES,game.isCorrect(new Coordinate(7,0),new Coordinate(0,7)));
    }
}
