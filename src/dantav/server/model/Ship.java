/**
 * Ship
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.server.model;

import java.awt.Image;
import java.util.logging.Logger;

import dantav.server.Constants;
import dantav.server.Server;
import dantav.server.model.shooting.Shooting;

public class Ship {

	/**
	 * The singleton of the ship
	 */
	private static final Ship singleton = new Ship();

	/**
	 * the health
	 */
	private int health;

	/**
	 * the score
	 */
	private int score;
	/**
	 * The image
	 */
	private Image image;
	/**
	 * The location
	 */
	private Location location;

	/**
	 * Number of lasers
	 */
	private int laserAmount;

	/**
	 * Your logger
	 */
	public static Logger logger = Logger.getLogger("Player");

	/**
	 * Defines default player variables
	 */
	private Ship() {
		this.health = 10;
		this.laserAmount = 10;
		this.image = Constants.SHIP_IMAGE;
		this.location = Constants.DEFAULT_PLAYER_LOCATION;
	}

	public Ship sendDeath() {
		final int score = this.score;
		if (getHealth() <= 0) {
			this.health = 10;
			this.laserAmount = 10;
			this.location = Constants.DEFAULT_PLAYER_LOCATION;
			this.score = 0;
			Shooting.shooting.removeAll(Shooting.shooting);
			logger.info("You die and end up with a score of " + score);
			Server.getSingleton().stopServer();
		}
		return this;
	}

	/**
	 * @return health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @return laserAmount
	 */
	public int getLaserAmount() {
		return laserAmount;
	}

	/**
	 * @return image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * @return score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @return location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @return singleton
	 */
	public static Ship getSingleton() {
		return singleton;
	}

	/**
	 * @param laserAmount
	 */
	public void setLaserAmount(int laserAmount) {
		this.laserAmount = laserAmount;
	}

	/**
	 * @param health
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @param location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

}
