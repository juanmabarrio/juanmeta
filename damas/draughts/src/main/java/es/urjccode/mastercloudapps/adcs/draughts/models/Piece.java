package es.urjccode.mastercloudapps.adcs.draughts.models;

public abstract class Piece {

	private Color color;

	Piece(Color color){
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

	public abstract boolean isAdvanced(Coordinate origin, Coordinate target);

    public abstract Error canMove(Coordinate origin, Coordinate target);
}
