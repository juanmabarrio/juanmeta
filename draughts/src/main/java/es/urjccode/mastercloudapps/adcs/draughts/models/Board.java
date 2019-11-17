package es.urjccode.mastercloudapps.adcs.draughts.models;

import java.util.ArrayList;
import java.util.List;

class Board implements PieceProvider {

    private static final int DIMENSION = 8;
    private Square[][] squares;

    Board() {
        this.squares = new Square[this.getDimension()][this.getDimension()];
        for (int i = 0; i < this.getDimension(); i++) {
            for (int j = 0; j < this.getDimension(); j++) {
                this.squares[i][j] = new Square();
            }
        }
    }

    @Override
    public boolean twoPiecesTogetherInBetween(Coordinate origin, Coordinate target){
        assert origin!=null && target!=null;
        Coordinate coordinate;
        Piece currentPiece = null;
        Piece previousPiece;
        int rowShift =0;
        int columnShift = 0;

        do {
            previousPiece = currentPiece;
            if (origin.getRow() > target.getRow()) {
                rowShift--;
            }
            else{
                rowShift++;
            }
            if (origin.getColumn() > target.getColumn()) {
                columnShift--;
            }
            else{
                columnShift++;
            }

            coordinate = new Coordinate(origin.getRow() + rowShift, origin.getColumn() + columnShift);
            currentPiece = this.getPiece(coordinate);
            if (previousPiece != null && currentPiece != null){
                return true;
            }

        }
        while(target.diagonalDistance(coordinate) > 0);
        return false;
    }

    @Override
    public boolean isThereAPieceOfThisColorInBetween(Color color, Coordinate origin, Coordinate target) {
        assert origin!=null && target!=null;
        Coordinate coordinate;
        Piece piece = null;
        int rowShift =0;
        int columnShift = 0;

        do {
            if (origin.getRow() > target.getRow()) {
                rowShift--;
            }
            else{
                rowShift++;
            }
            if (origin.getColumn() > target.getColumn()) {
                columnShift--;
            }
            else{
                columnShift++;
            }

            coordinate = new Coordinate(origin.getRow() + rowShift, origin.getColumn() + columnShift);
            piece = this.getPiece(coordinate);
            if (piece != null && piece.getColor().equals(color)){
                return true;
            }

        }
        while(target.diagonalDistance(coordinate) > 0);
        return false;
    }


    private Square getSquare(Coordinate coordinate){
        assert coordinate!=null;
        return this.squares[coordinate.getRow()][coordinate.getColumn()];
    }

    void put(Coordinate coordinate, Piece piece){
        assert piece != null;
        this.getSquare(coordinate).put(piece);
    }

    Piece remove(Coordinate coordinate) {
        assert this.getPiece(coordinate) != null;
        return this.getSquare(coordinate).remove();
    }

    void move(Coordinate origin, Coordinate target) {
        this.put(target, this.remove(origin));
    }

    @Override
    public Piece getPiece(Coordinate coordinate) {
        return this.getSquare(coordinate).getPiece();
    }

    @Override
    public boolean isEmpty(Coordinate coordinate) {
        return this.getSquare(coordinate).isEmpty();
    }
    
    Color getColor(Coordinate coordinate) {
        return this.getSquare(coordinate).getColor();
    }

    List<Piece> getPieces(Color color) {
        List<Piece> pieces = new ArrayList<Piece>();
        for (int i = 0; i < this.getDimension(); i++) {
            for (int j = 0; j < this.getDimension(); j++) {
                Piece piece = this.squares[i][j].getPiece();
                if (piece != null && piece.getColor().equals(color)){
                    pieces.add(piece);
                }

            }
        }
		return pieces;
	}
    
    int getDimension() {
		return Board.DIMENSION;
	}

    @Override
    public String toString() {
        String string = "";
        string += this.toStringHorizontalNumbers();
        for (int i = 0; i < this.getDimension(); i++) {
            string += this.toStringHorizontalPiecesWithNumbers(i);
        }
        string += this.toStringHorizontalNumbers();
        return string;
    }

    private String toStringHorizontalNumbers(){
        String string = " ";
        for (int j = 0; j < Board.DIMENSION; j++) {
            string += j;
        }
        return string + "\n";
    }

    private String toStringHorizontalPiecesWithNumbers(int row){
        String string = "" + row;
        for (int j = 0; j < this.getDimension(); j++) {
            Piece piece = this.getPiece(new Coordinate(row, j));
            if (piece == null) {
                string += " ";
            } else {
                final String[] letters = {"b","n"};
                string += letters[piece.getColor().ordinal()];
            }
        }
        return string + row + "\n";
    }

}
