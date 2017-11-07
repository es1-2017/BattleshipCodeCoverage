/**
 * 
 */
package battleship;

/**
 * @author adrianolopes
 *
 */
public class Galleon extends Ship {
	
	private static final int SIZE = 5;
	private static final String NAME = "Galeao";

	/**
	 * @param bearing
	 * @param pos
	 */
	public Galleon(Compass bearing, IPosition pos) {
		super(Galleon.NAME, bearing, pos);
		switch (bearing) {
		case NORTH:
			fillNorth(pos);
			break;
		case EAST:
			fillEast(pos);
			break;
		case SOUTH:
			fillSouth(pos);
			break;
		case WEST:
			fillWest(pos);
			break;
		default:
			// TODO: invalid bearing
			throw new IllegalArgumentException("ERROR! invalid bearing for the galleon");
		}
	}

	/* (non-Javadoc)
	 * @see battleship.Ship#getSize()
	 */
	@Override
	public int getSize() {
		return Galleon.SIZE;
	}

	private void fillNorth(IPosition pos) {
		for (int i = 0; i < 3; i++) {
			positions.add(new Position(pos.getRow(), pos.getColumn()+i));
		}
		positions.add(new Position(pos.getRow()+1, pos.getColumn()+1));
		positions.add(new Position(pos.getRow()+2, pos.getColumn()+1));
	}
	
	private void fillSouth(IPosition pos) {
		for (int i = 0; i < 2; i++) {
			positions.add(new Position(pos.getRow()+i, pos.getColumn()));
		}
		for (int j = 2; j < 5; j++) {
			positions.add(new Position(pos.getRow()+2, pos.getColumn()+j-3));
		}
	}
	
	private void fillEast(IPosition pos) {
		positions.add(new Position(pos.getRow(), pos.getColumn()));
		for (int i = 1; i < 4; i++) {
			positions.add(new Position(pos.getRow()+1, pos.getColumn()+i-3));
		}
		positions.add(new Position(pos.getRow()+2, pos.getColumn()));
	}

	private void fillWest(IPosition pos) {
		positions.add(new Position(pos.getRow(), pos.getColumn()));
		for (int i = 1; i < 4; i++) {
			positions.add(new Position(pos.getRow()+1, pos.getColumn()+i-1));
		}
		positions.add(new Position(pos.getRow()+2, pos.getColumn()));
	}
	
}
