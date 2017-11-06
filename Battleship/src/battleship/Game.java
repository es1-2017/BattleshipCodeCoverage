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
public class Game implements IGame {
	
	private List<IPosition> shots;
	private IFleet fleet;
	private int countInvalidShots;
	private int countRepeatedShots;
	private int countHits;
	private int countSinks;

	/**
	 * 
	 */
	public Game(IFleet fleet) {
		shots = new ArrayList<IPosition>();
		countInvalidShots = 0;
		countRepeatedShots = 0;
		this.fleet = fleet;
	}

	/* (non-Javadoc)
	 * @see battleship.IGame#fire(battleship.IPosition)
	 */
	@Override
	public IShip fire(IPosition pos) {
		if (!validateShot(pos))
			countInvalidShots++;
		else { // valid shot!
			if (repeatedShot(pos))
				countRepeatedShots++;
			else {
				shots.add(pos);
				IShip s = fleet.shipAt(pos);
				if (s != null) {
					s.shoot(pos);
					countHits++;
					if (!s.stillFloating()) {
						countSinks++;
						return s;
					}
				}
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see battleship.IGame#getShots()
	 */
	@Override
	public List<IPosition> getShots() {
		return shots;
	}

	/* (non-Javadoc)
	 * @see battleship.IGame#getRepeatedShots()
	 */
	@Override
	public int getRepeatedShots() {
		return this.countRepeatedShots;
	}

	/* (non-Javadoc)
	 * @see battleship.IGame#getInvalidShots()
	 */
	@Override
	public int getInvalidShots() {
		return this.countInvalidShots;
	}

	/* (non-Javadoc)
	 * @see battleship.IGame#getHits()
	 */
	@Override
	public int getHits() {
		return this.countHits;
	}

	/* (non-Javadoc)
	 * @see battleship.IGame#getSunkShips()
	 */
	@Override
	public int getSunkShips() {
		return this.countSinks;
	}

	/* (non-Javadoc)
	 * @see battleship.IGame#getRemainingShips()
	 */
	@Override
	public int getRemainingShips() {
		List<IShip> floatingShips = fleet.listFloatingShips();
		return floatingShips.size();
	}

	
	private boolean validateShot(IPosition pos) {
		return (   pos.getRow() >= 0
			    && pos.getRow() <= fleet.SQUAREGRIDSIZE 
			    && pos.getColumn() >= 0
			    && pos.getColumn() <= fleet.SQUAREGRIDSIZE);
	}
	
	private boolean repeatedShot(IPosition pos) {
		for (int i = 0; i < shots.size(); i++)
			if (shots.get(i).equals(pos))
				return true;
		return false;
	}
	
}
