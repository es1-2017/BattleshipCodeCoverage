/**
 * 
 */
package battleship;

import java.util.Iterator;

/**
 * @author adrianolopes
 *
 */
public interface IShip {
	String getCategory();
	abstract int getSize();
	IPosition getPosition();
	Compass getBearing();
	boolean stillFloating();
	int getTopMostPos();
	int getBottomMostPos();
	int getLeftMostPos();
	int getRightMostPos();
	boolean occupies(IPosition pos);
	boolean tooCloseTo(IShip other);
	Iterator<IPosition> getPositions();
	void shoot(IPosition pos);

}
