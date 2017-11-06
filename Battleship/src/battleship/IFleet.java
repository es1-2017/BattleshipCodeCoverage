/**
 * 
 */
package battleship;

import java.util.Iterator;

/**
 * @author adrianolopes
 *
 */
public interface IFleet {
	boolean addShip(IShip s);
	Iterator<IShip> listShipsLike(String category);
	Iterator<IShip> listFloatingShips();
	Iterator<IShip> listAllShips();
	IShip shipAt(IPosition pos);
}
