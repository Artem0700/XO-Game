package io.game.xo.model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class FieldTest {

	@Test
	public void testGetSize() throws Exception {
		final Field field = new Field();
		assertEquals(3, field.getSize());
	}

	@Test
	public void testSetFigure() {
		final Field field = new Field();
		final Point inputPoint = new Point(0, 0);
		final Figure inputFigure = Figure.O;	
		field.setFigure(inputPoint, inputFigure);
		final Figure actualFigure = field.getFigure(inputPoint);
		assertEquals(inputFigure, actualFigure);
	}

}
