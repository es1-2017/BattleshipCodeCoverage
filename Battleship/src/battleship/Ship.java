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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see battleship.IShip#getBearing()
	 */
	@Override
	public Compass getBearing() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see battleship.IShip#stillFloating()
	 */
	@Override
	public boolean stillFloating() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see battleship.IShip#getTopMostPos()
	 */
	@Override
	public int getTopMostPos() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see battleship.IShip#getBottomMostPos()
	 */
	@Override
	public int getBottomMostPos() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see battleship.IShip#getLeftMostPos()
	 */
	@Override
	public int getLeftMostPos() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see battleship.IShip#getRightMostPos()
	 */
	@Override
	public int getRightMostPos() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see battleship.IShip#occupies(battleship.IPosition)
	 */
	@Override
	public boolean occupies(IPosition pos) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see battleship.IShip#tooCloseTo(battleship.IShip)
	 */
	@Override
	public boolean tooCloseTo(IShip other) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub

	}

}
