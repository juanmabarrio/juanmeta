package es.urjccode.mastercloudapps.adcs.draughts.models;

import java.util.List;

class Pawn extends Piece {

    private static final int MAX_DISTANCE = 2;

    Pawn(Color color) {
        super(color);
    }

    boolean isAdvanced(Coordinate origin, Coordinate target) {
        assert origin != null;
        assert target != null;
        int difference = origin.getRow() - target.getRow();
        if (this.getColor() == Color.WHITE) {
            return difference > 0;
        }
        return difference < 0;
    }

    Error isCorrectMoveForMyTypeOfPiece(Coordinate origin, Coordinate target, PieceProvider pieceProvider) {
        int distance = origin.diagonalDistance(target);
        if (!this.isAdvanced(origin, target)) {
            return Error.NOT_ADVANCED;
        }

        if (distance > Pawn.MAX_DISTANCE) {
            return Error.BAD_DISTANCE;
        }

        if (distance == Pawn.MAX_DISTANCE) {
            if (pieceProvider.getPiece(origin.betweenDiagonal(target)) == null) {
                return Error.EATING_EMPTY;
            }
        }

        return null;
    }

    boolean isBlocked(PieceProvider board, Coordinate coordinate) {
        int row = coordinate.getRow();
        int column = coordinate.getColumn();
        int rowShift,columnShift;
        Piece piece;
        rowShift = (this.getColor() == Color.BLACK) ? +1 : -1;
        if (column == 0 || column ==7) {
            columnShift = (column == 0) ? +1 : -1;
            piece = board.getPiece(new Coordinate(row + rowShift, column + columnShift));
            if (piece == null) {
                return false;
            }
            if (piece.getColor() == this.getColor()) {
                return true;
            }
            piece = board.getPiece(new Coordinate(row + rowShift + rowShift, column + columnShift + columnShift));
            if (piece == null) {
                return false;
            } else return true;
        }
    return false;
    }
}
