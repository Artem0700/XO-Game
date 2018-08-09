package io.game.xo.controllers;
import static org.junit.Assert.*;
import java.awt.Point;
import org.junit.Test;

import controllers.MoveController;
import controllers.WinnerController;
import io.game.xo.model.Field;
import io.game.xo.model.Figure;
public class WinnerControllerTest {
	@Test
	public void testGetWinnerWhenWinnerRow() throws Exception {
		final WinnerController winnerController = new WinnerController();
		for (int i = 0; i < 3; i++) {
			final Field field = new Field(3);
			field.setFigure(new Point(i, 0), Figure.X);
			field.setFigure(new Point(i, 1), Figure.X);
			field.setFigure(new Point(i, 2), Figure.X);
			assertEquals(Figure.X, winnerController.getWinner(field));
		}
	}
	@Test
	public void testGetWinnerWhenNoWinnerRow() throws Exception {
		final WinnerController winnerController = new WinnerController();
		for (int i = 0; i < 3; i++) {
			final Field field = new Field(3);
			field.setFigure(new Point(i, 0), Figure.X);
			field.setFigure(new Point(i, 1), Figure.X);
			field.setFigure(new Point(i, 2), Figure.O);
			assertNull(winnerController.getWinner(field));
		}
	}
}
