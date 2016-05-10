package src.com.kamontat.code.player;

import src.com.kamontat.code.obstacle.Piece;
import src.com.kamontat.gui.Map;

import java.awt.*;

/**
 * An instance of this class is a J*Man.
 * There should at most one J*Man in a game board at a time
 */
public class JMan extends Piece {

	private Map map;

	/**
	 * Constructor: a new J*Man at position (x, y) on src.com.kamontat.gui.Map m
	 * with color red if c = 0, green if c = 1, and yellow if c = 2.
	 */
	public JMan(int x, int y, int c, Map m) {
		super(JMAN, m);
		// Complete this
		map = m;

		setColor(c == 0 ? Color.RED: c == 1 ? Color.GREEN: Color.YELLOW);
		setX(x);
		setY(y);
	}

	/**
	 * Constructor: a new J*Man at position (x, y) on src.com.kamontat.gui.Map m
	 * with color c. Precondition: c is one of
	 * Color.RED, Color.GREEN, and Color.YELLOW.
	 */
	public JMan(int x, int y, Color c, Map m) {
		super(JMAN, m);
		// Complete this;
		map = m;

		setColor(c);
		setX(x);
		setY(y);
	}


	public void checkHit(int dir) {
		int[] position = new int[]{getX(), getY()};

		switch (dir) {
			case 0:
				if (!map.isEmpty(position[0], position[1] - 1)) {
					if (checkColor(map.pieceAt(position[0], --position[1]))) {
						map.removePieceAt(position[0], position[1]);
						canStep(dir);
					}
				}
				break;
			case 1:
				if (!map.isEmpty(position[0], position[1] + 1)) {
					if (checkColor(map.pieceAt(position[0], ++position[1]))) {
						map.removePieceAt(position[0], position[1]);
						canStep(dir);
					}
				}
				break;
			case 2:
				if (!map.isEmpty(position[0] - 1, position[1])) {
					if (checkColor(map.pieceAt(--position[0], position[1]))) {
						map.removePieceAt(position[0], position[1]);
						canStep(dir);
					}
				}
				break;
			case 3:
				if (!map.isEmpty(position[0] + 1, position[1])) {
					if (checkColor(map.pieceAt(++position[0], position[1]))) {
						map.removePieceAt(position[0], position[1]);
						canStep(dir);
					}
				}
				break;
			default:
				break;
		}
	}

	public boolean checkColor(Piece obstacle) {
		// when hit the wall
		if (obstacle == null) {
			return false;
		}

		if (getColor().equals(Color.GREEN) && obstacle.getColor().equals(Color.RED)) {
			setColor(obstacle.getColor());
			return true;
		}
		if (getColor().equals(Color.YELLOW) && obstacle.getColor().equals(Color.GREEN)) {
			setColor(obstacle.getColor());
			return true;
		}
		if (getColor().equals(Color.RED) && obstacle.getColor().equals(Color.YELLOW)) {
			setColor(obstacle.getColor());
			return true;
		}
		return false;
	}

	/**
	 * J*Man should move based on what button is pushed.
	 * This method is not used.
	 */

	public void act() {
		return;
	}

	/**
	 * = representation of this piece
	 */
	public String toString() {
		return getColorWord() + " J*Man at (" + getX() + ", " + getY() + ")";
	}
}
