package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Pawn extends Piece {

    public Pawn(Color color){
        super(color);
    }
    @Override
    public Error canMove(Coordinate origin, Coordinate target){
        if (!origin.isDiagonal(target)) {
            return Error.NOT_DIAGONAL;
        }
        if (!this.isAdvanced(origin, target)) {
            return Error.NOT_ADVANCED;
        }
        if (origin.diagonalDistance(target) >= 3) {
            return Error.BAD_DISTANCE;
        }
        return null;
    }

    @Override
    public boolean isAdvanced(Coordinate origin, Coordinate target) {
        int difference = origin.getRow() - target.getRow();
        if (this.getColor() == Color.WHITE){
            return difference>0;
        }
        return difference<0;
    }
}
