/**
 * 
 */
package battleship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author adrianolopes
 *
 */
public abstract class Ship implements IShip {
	
	private String category;
	private Compass bearing;
	private IPosition pos;
	protected List<IPosition> positions;
	
	/**
	 * 
	 */
	public Ship(String category, Compass bearing, IPosition pos) {
		this.category = category;
		this.bearing = bearing;
		this.pos = pos;
		positions = new ArrayList<IPosition>();
		
		// Concrete classes must set the positions
	}

	/* (non-Javadoc)
	 * @see battleship.IShip#getCategory()
	 */
	@Override
	public String getCategory() {
		return category;
	}

	/* (non-Javadoc)
	 * @see battleship.IShip#getSize()
	 */
	@Override
	public abstract int getSize();
	
	/* (non-Javadoc)
	 * @see battleship.IShip#getPosition()
	 */
	@Override
	public IPosition getPosition() {
		return pos;
	}

	/* (non-Javadoc)
	 * @see battleship.IShip#getBearing()
	 */
	@Override
	public Compass getBearing() {
		return bearing;
	}

	/* (non-Javadoc)
	 * @see battleship.IShip#stillFloating()
	 */
	@Override
	public boolean stillFloating() {
		for(int i = 0; i < getSize(); i++)
			if (!positions.get(i).isHit())
				return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see battleship.IShip#getTopMostPos()
	 */
	@Override
	public int getTopMostPos() {
		int top = positions.get(0).getRow();
		for (int i = 1; i < getSize(); i++)
			if (positions.get(i).getRow() < top)
				top = positions.get(i).getRow();
		return top;
	}

	/* (non-Javadoc)
	 * @see battleship.IShip#getBottomMostPos()
	 */
	@Override
	public int getBottomMostPos() {
		int bottom = positions.get(0).getRow();
		for (int i = 1; i < getSize(); i++)
			if (positions.get(i).getRow() > bottom)
				bottom = positions.get(i).getRow();
		return bottom;
	}

	/* (non-Javadoc)
	 * @see battleship.IShip#getLeftMostPos()
	 */
	@Override
	public int getLeftMostPos() {
		int left = positions.get(0).getColumn();
		for (int i = 1; i < getSize(); i++)
			if (positions.get(i).getColumn() < left)
				left = positions.get(i).getColumn();
		return left;
	}

	/* (non-Javadoc)
	 * @see battleship.IShip#getRightMostPos()
	 */
	@Override
	public int getRightMostPos() {
		int right = positions.get(0).getColumn();
		for (int i = 1; i < getSize(); i++)
			if (positions.get(i).getColumn() > right)
				right = positions.get(i).getColumn();
		return right;
	}

	/* (non-Javadoc)
	 * @see battleship.IShip#occupies(battleship.IPosition)
	 */
	@Override
	public boolean occupies(IPosition pos) {
		for (int i = 0; i < getSize(); i++)
			if (positions.get(i).equals(pos))
				return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see battleship.IShip#tooCloseTo(battleship.IShip)
	 */
	@Override
	public boolean tooCloseTo(IShip other) {
		Iterator<IPosition> otherPos = other.getPositions();
		while (otherPos.hasNext())
			if (tooCloseTo(otherPos.next()))
				return true;

		return false;
	}

	/* (non-Javadoc)
	 * @see battleship.IShip#getPositions()
	 */
	@Override
	public Iterator<IPosition> getPositions() {
		return positions.iterator();
	}

	/* (non-Javadoc)
	 * @see battleship.IShip#shoot(battleship.IPosition)
	 */
	@Override
	public void shoot(IPosition pos) {
		for (IPosition position : positions) {
			if (position.equals(pos))
				position.shoot();
		}
	}
	
	@Override
	public String toString() {
		return "[" + category + " " + bearing + " " + pos + "]";
	}
	
	private boolean tooCloseTo(IPosition pos) {
		for (int i = 0; i < this.getSize(); i++)
			if (positions.get(i).isAdjacentTo(pos))
				return true;
		return false;
	}

}
