/**
 * 
 */
package battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adrianolopes
 *
 */
public class Fleet implements IFleet {

	private List<IShip> ships;
		
	/**
	 * 
	 */
	public Fleet() {
		ships = new ArrayList<IShip>();
	}

	/* (non-Javadoc)
	 * @see battleship.IFleet#addShip(battleship.IShip)
	 */
	@Override
	public boolean addShip(IShip s) {
		boolean result = false;
		if ((ships.size() <= SQUAREGRIDSIZE) && (isInsideMap(s)) && (!colisionRisk(s))){
			ships.add(s);
			result = true;
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see battleship.IFleet#listShipsLike(java.lang.String)
	 */
	@Override
	public List<IShip> listShipsLike(String category) {
		List<IShip> shipsLike = new ArrayList<IShip>();
		for (IShip s: ships) {
			if (s.getCategory().equals(category))
				shipsLike.add(s);
		}
		
		return shipsLike;
	}

	/* (non-Javadoc)
	 * @see battleship.IFleet#listFloatingShips()
	 */
	@Override
	public List<IShip> listFloatingShips() {
		List<IShip> floatingShips = new ArrayList<IShip>();
		for (IShip s: ships) {
			if (s.stillFloating())
				floatingShips.add(s);
		}
		return floatingShips;
	}

	/* (non-Javadoc)
	 * @see battleship.IFleet#listAllShips()
	 */
	@Override
	public List<IShip> listAllShips() {
		List<IShip> allShips = new ArrayList<IShip>();
		for (IShip s: ships) {
			allShips.add(s);
		}
		return allShips;
	}

	/* (non-Javadoc)
	 * @see battleship.IFleet#shipAt(battleship.IPosition)
	 */
	@Override
	public IShip shipAt(IPosition pos) {
		for (int i = 0; i < ships.size(); i++)
		if (ships.get(i).occupies(pos))
			return ships.get(i);
		return null;
	}
	
	private boolean isInsideMap(IShip s) {
		return (   s.getLeftMostPos() >= 0
				&& s.getRightMostPos() <= SQUAREGRIDSIZE-1
				&& s.getTopMostPos() >= 0
				&& s.getBottomMostPos() <= SQUAREGRIDSIZE-1);
	}
	
	private boolean colisionRisk(IShip s) {
		for (int i = 0; i < ships.size(); i++) {
			if (ships.get(i).tooCloseTo(s))
				return true;
		}
		return false;
	}
	

}
