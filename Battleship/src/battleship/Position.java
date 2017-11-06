/**
 * 
 */
package battleship;

/**
 * @author adrianolopes
 *
 */
public class Position implements IPosition {
	private int row;
	private int column;
	private boolean isOccupied;
	private boolean isHit;

	/**
	 * 
	 */
	public Position(int row, int column) {
		this.row = row;
		this.column = column;
		this.isOccupied = false;
		this.isHit = false;
	}

	/* (non-Javadoc)
	 * @see battleship.IPosition#getRow()
	 */
	@Override
	public int getRow() {
		return row;
	}

	/* (non-Javadoc)
	 * @see battleship.IPosition#getColumn()
	 */
	@Override
	public int getColumn() {
		return column;
	}

	/* (non-Javadoc)
	 * @see battleship.IPosition#equals(battleship.IPosition)
	 */
	@Override
	public boolean equals(IPosition other) {
		return (   this.getRow() == other.getRow()
				&& this.getColumn() == other.getColumn());
	}

	/* (non-Javadoc)
	 * @see battleship.IPosition#isAdjacentTo(battleship.IPosition)
	 */
	@Override
	public boolean isAdjacentTo(IPosition other) {
		return (   Math.abs(this.getRow() - other.getRow()) <= 1
		        && Math.abs(this.getColumn() - other.getColumn()) <= 1);
	}

	/* (non-Javadoc)
	 * @see battleship.IPosition#occupy()
	 */
	@Override
	public void occupy() {
		isOccupied = true;
	}

	/* (non-Javadoc)
	 * @see battleship.IPosition#shoot()
	 */
	@Override
	public void shoot() {
		isHit = true;
	}

	/* (non-Javadoc)
	 * @see battleship.IPosition#isOccupied()
	 */
	@Override
	public boolean isOccupied() {
		return isOccupied;
	}

	/* (non-Javadoc)
	 * @see battleship.IPosition#isHit()
	 */
	@Override
	public boolean isHit() {
		return isHit;
	}

	@Override
	public String toString() {
		return ("Linha = " + row + " Coluna = " + column);
	}
	
}
