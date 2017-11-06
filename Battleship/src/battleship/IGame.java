/**
 * 
 */
package battleship;

import java.util.Iterator;

/**
 * @author adrianolopes
 *
 */
public interface IGame {
	IShip fire(IPosition pos);
	Iterator<IPosition> getShots();
	int getRepeatedShots();
	int getInvalidShots();
	int getHits();
	int getSunkShips();
	int getRemainingShips();
	

}
