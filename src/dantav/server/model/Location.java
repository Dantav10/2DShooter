/**
 * Location
 * 
 * January 25th, 2014
 * 
 * Dan0194
 */
package dantav.server.model;

/**
 * A location
 */
public class Location {

	/**
	 * The x coordinate of the location
	 */
	private int x;
	/**
	 * The y coordinate of the location
	 */
	private int y;

	/**
	 * Creates a new location
	 */
	public static Location create(int x, int y) {
		return new Location(x, y);
	}

	/**
	 * @param x
	 * @param y
	 */
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return y
	 */
	public int getY() {
		return y;
	}

}
