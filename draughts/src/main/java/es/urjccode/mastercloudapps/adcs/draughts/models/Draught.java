package es.urjccode.mastercloudapps.adcs.draughts.models;

class Draught extends Piece {

    Draught(Color color) {
        super(color);
    }


    boolean isAdvanced(Coordinate origin, Coordinate target) {
        assert origin != null;
        assert target != null;
        int difference = origin.getRow() - target.getRow();
        return difference != 0;
    }



    Error isCorrectMovementForMyTypeOfPiece(Coordinate origin, Coordinate target, PieceProvider pieceProvider){
        return null;
    }
}
