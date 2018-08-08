package io.game.xo.model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import exceptions.InvalidePointException;

public class FieldTest {

	@Test
	public void testGetSize() throws Exception {
		final Field field = new Field();
		assertEquals(3, field.getSize());
	}

	@Test
	public void testGetFigureWhenFigureIsNotSet() {
		final Field field = new Field();
		final Point inputPoint = new Point(0, 0);
		try {
			field.getFigure(inputPoint);
			fail();
		} catch (final InvalidePointException e) {
			
		}
	}
}
