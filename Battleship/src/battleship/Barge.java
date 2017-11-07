/**
 * 
 */
package battleship;

/**
 * @author adrianolopes
 *
 */
public class Barge extends Ship {
	
	private static final int SIZE = 1;
	private static final String NAME = "Barca";

	/**
	 * @param bearing - barge bearing
	 * @param pos - upper left position of the barge
	 */
	public Barge(Compass bearing, IPosition pos) {
		super(Barge.NAME, bearing, pos);
		positions.add(new Position(pos.getRow(), pos.getColumn()));
	}

	@Override
	public int getSize() {
		return SIZE;
	}

}
