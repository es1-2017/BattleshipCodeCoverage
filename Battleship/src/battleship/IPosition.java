/**
 * 
 */
package battleship;

/**
 * @author adrianolopes
 *
 */
public interface IPosition {
	int getRow();
	int getColumn();
	boolean equals(IPosition other);
	boolean isAdjacentTo(IPosition other);
	void occupy();
	void shoot();
	boolean isOccupied();
	boolean isHit();
}
