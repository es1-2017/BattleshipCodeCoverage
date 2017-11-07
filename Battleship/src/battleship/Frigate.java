/**
 * 
 */
package battleship;

/**
 * @author adrianolopes
 *
 */
public class Frigate extends Ship {
	
	private static final int SIZE = 4;
	private static final String NAME = "Fragata";

	/**
	 * @param bearing
	 * @param pos
	 */
	public Frigate(Compass bearing, IPosition pos) {
		super(Frigate.NAME, bearing, pos);
		if (bearing == Compass.NORTH || bearing == Compass.SOUTH)
			for (int r = 0; r < SIZE; r++)
				positions.add(new Position(pos.getRow()+r, pos.getColumn()));
		else if (bearing == Compass.EAST || bearing == Compass.WEST)
			for (int c = 0; c < SIZE; c++)
				positions.add(new Position(pos.getRow(), pos.getColumn()+c));
		// else ... TODO: invalid bearing
		else 
			throw new IllegalArgumentException("ERROR! invalid bearing for thr frigate");
	}

	/* (non-Javadoc)
	 * @see battleship.Ship#getSize()
	 */
	@Override
	public int getSize() {
		return Frigate.SIZE;
	}

}
