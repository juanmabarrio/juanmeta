package es.urjccode.mastercloudapps.adcs.draughts.models;

import java.util.HashSet;
import java.util.Set;

class Draught extends Piece {

    Draught(Color color) {
        super(color);
    }


    Error isCorrectMoveForMyTypeOfPiece(Coordinate origin, Coordinate target, PieceProvider pieceProvider) {

        int distance = origin.diagonalDistance(target);
        if (distance > 2 && pieceProvider.twoPiecesTogetherInBetween(origin, target)) {
            return Error.TOO_MANY_PIECES_IN_BETWEEN;
        }
        if (pieceProvider.isThereAPieceOfThisColorInBetween(this.getColor(), origin, target)) {
            return Error.CANT_EAT_YOUR_PIECES;
        }

        return null;
    }

    @Override
    boolean isBlocked(PieceProvider board, Coordinate coordinate) {
        int row = coordinate.getRow();
        int column = coordinate.getColumn();
        int rowShift;
        Piece piece;
        rowShift = (this.getColor() == Color.BLACK) ? +1 : -1;
        Set<Integer> columnShifts = new HashSet<>();
        columnShifts.add(-1);
        columnShifts.add(1);
        if (column == 0)
            columnShifts.remove(-1);
        if (column == board.getDimension() - 1)
            columnShifts.remove(1);
        //first level search.
        for (int columnShift : columnShifts) {
            piece = board.getPiece(new Coordinate(row + rowShift, column + columnShift));
            if (piece == null) {
                return false;
            }
            if (piece.getColor() == this.getColor()) {
                return true;
            }
        }
        //second level search
        if (column == 1)
            columnShifts.remove(-1);
        if (column == board.getDimension() - 2)
            columnShifts.remove(1);
        for (int columnShift : columnShifts) {
            piece = board.getPiece(new Coordinate(row + rowShift + rowShift, column + columnShift + columnShift));
            if (piece == null) {
                return false;
            } else return true;
        }
        return false;
    }
}


