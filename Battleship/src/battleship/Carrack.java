/**
 * 
 */
package battleship;

/**
 * @author adrianolopes
 *
 */
public class Carrack extends Ship {
	
	private static final int SIZE = 3;
	private static final String NAME = "Nau";

	/**
	 * @param bearing
	 * @param pos
	 */
	public Carrack(Compass bearing, IPosition pos) {
		super(Carrack.NAME, bearing, pos);
		if (bearing == Compass.NORTH || bearing == Compass.SOUTH)
			for (int r = 0; r < SIZE; r++)
				positions.add(new Position(pos.getRow()+r, pos.getColumn()));
		else if (bearing == Compass.EAST || bearing == Compass.WEST)
			for (int c = 0; c < SIZE; c++)
				positions.add(new Position(pos.getRow(), pos.getColumn()+c));
		// else ... TODO: invalid bearing
	}

	/* (non-Javadoc)
	 * @see battleship.Ship#getSize()
	 */
	@Override
	public int getSize() {
		return Carrack.SIZE;
	}

}
