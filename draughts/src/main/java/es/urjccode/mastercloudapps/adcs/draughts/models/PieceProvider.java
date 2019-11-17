package es.urjccode.mastercloudapps.adcs.draughts.models;

interface PieceProvider {

    boolean isEmpty(Coordinate coordinate);
    Piece getPiece(Coordinate coordinate);

    boolean twoPiecesTogetherInBetween(Coordinate origin, Coordinate target);

    boolean isThereAPieceOfThisColorInBetween(Color color, Coordinate origin, Coordinate target);
}
