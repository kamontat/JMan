package src.com.kamontat.code.obstacle;

import src.com.kamontat.gui.Map;

import java.awt.*;

/**
 * @author kamontat
 * @since 6/5/59 - 23:08
 */
public class Pillar extends Piece {
	private Map map;

	public Pillar(int x, int y, int c, Map m) {
		super(Piece.PILLAR, m);

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
			setColor(randColor(new Color[]{Color.RED, Color.GREEN, Color.YELLOW}));
		}
	}
}
