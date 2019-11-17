package es.urjccode.mastercloudapps.adcs.draughts.models;

class Draught extends Piece {

    Draught(Color color) {
        super(color);
    }



    Error isCorrectMoveForMyTypeOfPiece(Coordinate origin, Coordinate target, PieceProvider pieceProvider) {

      int distance = origin.diagonalDistance(target);
      if (distance > 2 && pieceProvider.twoPiecesTogetherInBetween(origin,target)){
          return Error.TOO_MANY_PIECES_IN_BETWEEN;
      }
      return null;
    }
}
