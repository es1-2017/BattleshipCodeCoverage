/**
 * 
 */
package battleship;

import java.util.List;

/**
 * @author adrianolopes
 *
 */
public interface IGame {
	
	IShip fire(IPosition pos);
	List<IPosition> getShots();
	int getRepeatedShots();
	int getInvalidShots();
	int getHits();
	int getSunkShips();
	int getRemainingShips();	

}
