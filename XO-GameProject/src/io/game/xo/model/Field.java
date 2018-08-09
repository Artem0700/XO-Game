package io.game.xo.model;
import java.awt.Point;
import exceptions.InvalidePointException;
public class Field {
	private static final int MIN_COORDINATE = 0;
	private final int fieldSize;
	private final Figure[][] field;
	public Field(final int fieldSize) {
		this.fieldSize = fieldSize;
		field = new Figure[fieldSize][fieldSize];
	}
	public int getSize() {
		return fieldSize;
	}
	public Figure getFigure(final Point point) throws InvalidePointException {
		if (!checkPoint(point)) {
			throw new InvalidePointException();
		}
		return field[point.x][point.y];
	}
	public void setFigure(final Point point, final Figure figure) throws InvalidePointException {
		if (!checkPoint(point)) {
			throw new InvalidePointException();
		}
		field [point.x][point.y] = figure;
	}
	private boolean checkPoint(final Point point) {
		return checkCoordinate(point.x, field.length) && checkCoordinate(point.y, field[point.x].length);
	}
	private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {
		return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;
	}
}
