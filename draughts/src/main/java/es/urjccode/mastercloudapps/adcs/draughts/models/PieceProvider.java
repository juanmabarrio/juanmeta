package es.urjccode.mastercloudapps.adcs.draughts.models;

import java.util.List;

interface PieceProvider {

    boolean isEmpty(Coordinate coordinate);
    Piece getPiece(Coordinate coordinate);

    boolean twoPiecesTogetherInBetween(Coordinate origin, Coordinate target);

    boolean isThereAPieceOfThisColorInBetween(Color color, Coordinate origin, Coordinate target);

    int getDimension();
    List<Piece> getPieces(Color color);
}
