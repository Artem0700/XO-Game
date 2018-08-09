package controllers;
import java.awt.Point;

import exceptions.AlreadyOccupiedException;
import exceptions.InvalidePointException;
import io.game.xo.model.Field;
import io.game.xo.model.Figure;
public class MoveController {
	public void applyFigure(final Field field, 
							final Figure figure, 
							final Point point) throws InvalidePointException, 
													  AlreadyOccupiedException {
		if (field.getFigure(point) != null) {
			throw new AlreadyOccupiedException();
		}
		field.setFigure(point, figure);
	}
}
