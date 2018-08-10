package view;
import java.awt.Point;
import java.util.InputMismatchException;
import java.util.Scanner;
import controllers.CurrentMoveController;
import controllers.MoveController;
import controllers.WinnerController;
import exceptions.AlreadyOccupiedException;
import exceptions.InvalidePointException;
import io.game.xo.model.Field;
import io.game.xo.model.Figure;
import io.game.xo.model.Game;
public class ConsoleView {
	private final CurrentMoveController currentMoveController = new CurrentMoveController();
	private final WinnerController winnerController = new WinnerController();
	private final MoveController moveController = new MoveController();
	public void show(final Game game) {
		System.out.format("Game name: %s\n", game.getName());
		final Field field = game.getField();
		for (int x = 0; x < field.getSize(); x++) {
			if (x != 0) {
				printSeparator();
			}
			printLine(field, x);
		}
	}
	public boolean move(final Game game) {
		final Field field = game.getField();
		final Figure winner = winnerController.getWinner(field);
		if (winner != null) {
			System.out.format("Winner is: %s", winner);
			return false;
		}
		final Figure currentFigure = currentMoveController.currentMove(field);
		if (currentFigure == null) {
			System.out.println("No winner and no moves left!");
			return false;
		}
		System.out.format("Please enter move point for: %s\n", currentFigure);
		final Point point = askPoint();
		try {
			moveController.applyFigure(field, currentFigure, point);
		} catch (InvalidePointException | AlreadyOccupiedException e) { 
			System.out.println("Point is invalid!");
		}
		return true;
	}
	private Point askPoint() {
		return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
	}
	private int askCoordinate(final String coordinateName) {
		System.out.format("Please input %s: ", coordinateName);
		final Scanner in = new Scanner(System.in);
		try {
			return in.nextInt();
		} catch (final InputMismatchException e) {
			System.out.println("Set a number!");
			return askCoordinate(coordinateName);
		}
	}
	private void printLine(final Field field, final int x) {
		
		for (int y = 0; y < field.getSize(); y++) {
			if (y != 0){
				System.out.print("|");
			}
			System.out.print(" ");
			final Figure figure;
			try {
				figure = field.getFigure(new Point(y, x));
			} catch (InvalidePointException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			System.out.print(figure != null ? figure : " ");
			System.out.print(" ");
		}
		System.out.println();
	}
	private void printSeparator() {
		System.out.println("-----------");
	}
}