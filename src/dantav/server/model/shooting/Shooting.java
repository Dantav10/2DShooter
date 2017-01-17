/**
 * Shooting
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.server.model.shooting;

import java.awt.Graphics;
import java.util.ArrayList;

import dantav.server.model.Location;
import dantav.server.model.Ship;

public abstract class Shooting {

	/**
	 * The list of the shootings
	 */
	public static ArrayList<Shooting> shooting = new ArrayList<Shooting>();

	/**
	 * The location of the shootings
	 */
	private Location location;

	/**
	 * What it does when the shot interacts with something
	 */
	protected abstract void getInteraction();

	/**
	 * The speed of the shot
	 */
	protected abstract int getSpeed();

	/**
	 * When the Shot should be destroyed
	 */
	protected abstract boolean destroy();

	/**
	 * The default location
	 */
	protected abstract Location getDefaultLocation();

	/**
	 * The score increase
	 */
	protected abstract int getScore();

	/**
	 * The graphics
	 */
	public abstract void getGraphics(Graphics g);

	/**
	 * Adds the shot to the list
	 */
	public void executeShot() {
		shooting.add(this);
	}

	/**
	 * Handles the shot while moving
	 */
	public void handleLaser() {
		if (destroy()) {
			Ship.getSingleton().setScore(
					Ship.getSingleton().getScore() + this.getScore());
			shooting.remove(this);
		} else {
			setLocation(Location.create(getLocation().getX() + getSpeed(),
					getLocation().getY()));
			getInteraction();
		}
	}

	/**
	 * @return location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Sets the location to the location
	 * 
	 * @param location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

}
