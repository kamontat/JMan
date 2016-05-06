package src.com.kamontat.code.obstacle;

import src.com.kamontat.gui.Map;

import java.awt.*;

/**
 * @author kamontat
 * @since 6/5/59 - 22:43
 */
public class Block extends Piece {

	private Map map;

	public Block(int x, int y, Map m) {
		super(Piece.BLOCK, m);

		setColor(Color.WHITE);
		setX(x);
		setY(y);
	}

	/**
	 * block can't move
	 */
	@Override
	public void act() {
		return;
	}
}
