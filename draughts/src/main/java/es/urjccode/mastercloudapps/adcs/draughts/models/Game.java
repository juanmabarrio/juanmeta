package es.urjccode.mastercloudapps.adcs.draughts.models;

import java.util.List;

public class Game {




    private Board board;


    private Turn turn;


    public Game() {
        this.turn = new Turn();
        this.board = new Board();
        for (int i = 0; i < this.board.getDimension(); i++) {
            for (int j = 0; j < this.board.getDimension(); j++) {
                Coordinate coordinate = new Coordinate(i, j);
                Piece piece = this.getInitialPiece(coordinate);
                if (piece != null) {
                    this.board.put(coordinate, piece);
                }
            }
        }
    }


    private Piece getInitialPiece(Coordinate coordinate) {
        assert coordinate != null;
        if (coordinate.isBlack()) {
            final int row = coordinate.getRow();
            Color color = null;
            if (row <= 2) {
                color = Color.BLACK;
            } else if (row >= 5) {
                color = Color.WHITE;
            }
            if (color != null) {
                return new Pawn(color);
            }
        }
        return null;
    }

    public void move(Coordinate origin, Coordinate target) {
        assert this.isCorrect(origin, target) == null;
        if (origin.diagonalDistance(target) == 2) {
            this.board.remove(origin.betweenDiagonal(target));
        }
        this.board.move(origin, target);
        if (this.board.getPiece(target).isLimit(target)) {
            this.board.remove(target);
            this.board.put(target, new Draught(Color.WHITE));
        }
        this.turn.change();
    }

    public Error isCorrect(Coordinate origin, Coordinate target) {
        assert origin != null;
        assert target != null;
        if (board.isEmpty(origin)) {
            return Error.EMPTY_ORIGIN;
        }
        if (this.turn.getColor() != this.board.getColor(origin)) {
            return Error.OPPOSITE_PIECE;
        }
        return this.board.getPiece(origin).isCorrect(origin, target, board);
    }

    public Color getColor(Coordinate coordinate) {
        assert coordinate != null;
        return this.board.getColor(coordinate);
    }

    public Color getColor() {
        return this.turn.getColor();
    }


    public boolean isBlocked() {
        Color color = this.turn.getColor();
        List<Piece> pieces = this.board.getPieces(color);
        if (pieces.size()==0) return false;

            for (int i = 0; i < this.board.getDimension(); i++) {
                for (int j = 0; j < this.board.getDimension(); j++) {
                    Piece piece = this.board.getPiece(new Coordinate(i,j));
                    if (piece != null && piece.getColor()==color){
                        if (!piece.isBlocked(this.board,new Coordinate(i,j))){
                            return false;
                        }
                    }
                }
            }
        return true;
    }


    public int getDimension() {
        return this.board.getDimension();
    }

    public Piece getPiece(Coordinate coordinate) {
        assert coordinate != null;
        return this.board.getPiece(coordinate);
    }

    @Override
    public String toString() {
        return this.board + "\n" + this.turn;
    }


    public void setBoard(Board board) {
        this.board = board;
    }


    public void setTurn(Turn turn) {
        this.turn = turn;
    }

    public boolean noMorePiecesLeft() {
        return this.board.getPieces(this.turn.getColor()).isEmpty();
    }

    public Board getBoard() {
        return board;
    }
}
