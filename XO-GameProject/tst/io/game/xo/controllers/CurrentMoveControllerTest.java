package io.game.xo.controllers;
import static org.junit.Assert.*;
import java.awt.Point;
import org.junit.Test;
import controllers.CurrentMoveController;
import controllers.WinnerController;
import io.game.xo.model.Field;
import io.game.xo.model.Figure;
public class CurrentMoveControllerTest {
	@Test
	public void testCurrentMoveWhenNextMoveIsO() throws Exception {
		final CurrentMoveController currentMoveController = new CurrentMoveController();
		for (int i = 0; i < 3; i++) {
			final Field field = new Field(3);
			field.setFigure(new Point(i, 0), Figure.X);
			field.setFigure(new Point(i, 1), Figure.O);
			field.setFigure(new Point(i, 2), Figure.X);
			assertEquals(Figure.O, currentMoveController.currentMove(field));
		}
	}
	@Test
	public void testCurrentMoveWhenNextMoveIsX() throws Exception {
		final CurrentMoveController currentMoveController = new CurrentMoveController();
		for (int i = 0; i < 3; i++) {
			final Field field = new Field(3);
			field.setFigure(new Point(i, 1), Figure.O);
			field.setFigure(new Point(i, 2), Figure.X);
			assertEquals(Figure.X, currentMoveController.currentMove(field));
		}
	}
	@Test
	public void testCurrentMoveWhenNoNextMove() throws Exception {
		final CurrentMoveController currentMoveController = new CurrentMoveController();
		final Field field = new Field(3);
		field.setFigure(new Point(0, 0), Figure.O);
		field.setFigure(new Point(0, 1), Figure.X);
		field.setFigure(new Point(0, 2), Figure.O);
		field.setFigure(new Point(1, 0), Figure.X);
		field.setFigure(new Point(1, 1), Figure.O);
		field.setFigure(new Point(1, 2), Figure.X);
		field.setFigure(new Point(2, 0), Figure.O);
		field.setFigure(new Point(2, 1), Figure.X);
		field.setFigure(new Point(2, 2), Figure.X);
		assertNull(currentMoveController.currentMove(field));
	}
}