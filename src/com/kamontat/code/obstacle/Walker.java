package src.com.kamontat.code.obstacle;

import src.com.kamontat.gui.Map;

import java.awt.*;

/**
 * @author kamontat
 * @since 6/5/59 - 22:52
 */
public class Walker extends Piece {
	private Map map;

	public Walker(int x, int y, int c, Map m) {
		super(Piece.WALKER, m);

		setColor(c == 0 ? Color.RED: c == 1 ? Color.GREEN: Color.YELLOW);
		setX(x);
		setY(y);
	}

	/**
	 * block can't move
	 */
	@Override
	public void act() {
		if (rand(1, 3) == 1) {
			int rand = rand(0, 3);
			canStep(rand);
		}
	}
}
