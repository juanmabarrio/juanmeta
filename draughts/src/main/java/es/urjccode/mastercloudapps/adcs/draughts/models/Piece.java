package es.urjccode.mastercloudapps.adcs.draughts.models;

public abstract class Piece {

	private Color color;

	protected Piece(Color color) {
		assert color != null;
		this.color = color;
	}


	Error isCorrect(Coordinate origin, Coordinate target, PieceProvider pieceProvider) {
		if (!origin.isDiagonal(target)) {
			return Error.NOT_DIAGONAL;
		}
		if (!pieceProvider.isEmpty(target)) {
			return Error.NOT_EMPTY_TARGET;
		}

		return this.isCorrectMoveForMyTypeOfPiece(origin, target,pieceProvider);
	}

    boolean isLimit(Coordinate coordinate){
        return coordinate.getRow()== 0 && this.getColor() == Color.WHITE ||
            coordinate.getRow()== 7 && this.getColor() == Color.BLACK;
    }

    abstract Error isCorrectMoveForMyTypeOfPiece(Coordinate origin, Coordinate target, PieceProvider pieceProvider);

    Color getColor() {
        return this.color;
    }

}
