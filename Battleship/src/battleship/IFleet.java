/**
 * 
 */
package battleship;

import java.util.Iterator;
import java.util.List;

/**
 * @author adrianolopes
 *
 */
public interface IFleet {

	int SQUAREGRIDSIZE = 10;
	boolean addShip(IShip s);
	List<IShip> listShipsLike(String category);
	List<IShip> listFloatingShips();
	List<IShip> listAllShips();
	IShip shipAt(IPosition pos);
	
}
