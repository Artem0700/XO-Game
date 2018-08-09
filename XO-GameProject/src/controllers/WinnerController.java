package controllers;
import java.awt.Point;
import exceptions.InvalidePointException;
import io.game.xo.model.Field;
import io.game.xo.model.Figure;
public class WinnerController {
	public Figure getWinner(final Field field) {
		try {
				for (int i = 0; i < 3; i++) {
					if (check(field, new Point(i, 0), p -> new Point ) {
						return field.getFigure(new Point(i, 0));
					}
				}
				for (int i = 0; i < 3; i++) {
					if (check(field, new Point(0, i), new Point(1, i), new Point(2, i))) {
						return field.getFigure(new Point(0, i));
					}
				}
				if (check(field, new Point(0, 0), new Point(1, 1), new Point(2, 2))) {
					return field.getFigure(new Point(0, 0));
				}
				if (check(field, new Point(0, 2), new Point(1, 1), new Point(2, 0))) {
					return field.getFigure(new Point(1, 1));
				}
		} catch (InvalidePointException e) {
			e.printStackTrace();
		}
		return null;
	}
	private boolean check(final Field field, final Point currentPoint, final IPointGenerator pointGenerator) {
		final Figure currentFigure;
		final Figure nextFigure;
		final Point nextPoint = pointGenerator.next(currentPoint);
		try {
			currentFigure = field.getFigure(currentPoint);
			nextFigure = field.getFigure(nextPoint);
		} catch (final InvalidePointException e) {
			return true;
		}
		if (currentFigure == null) {
			return false;
		}
		if (currentFigure != nextFigure) {
			return false;
		}
		return check(field, nextPoint, pointGenerator);
	}
	private interface IPointGenerator {
		Point next(final Point point);
	}
}
