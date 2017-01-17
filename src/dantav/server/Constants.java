/**
 * Constants
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.server;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;

import dantav.server.model.Location;
import dantav.util.configuration.Configuration;
import dantav.util.configuration.impl.GraphicsConfiguration;
import dantav.util.configuration.impl.UpdateConfiguration;
import dantav.util.configuration.impl.XMLConfiguration;

public final class Constants {

	/**
	 * So this class can never be constructed
	 */
	private Constants() {
		throw new AssertionError();
	};

	/**
	 * The Window dimensions
	 */
	public static final Dimension JFRAME_DIMENSIONS = new Dimension(600, 400);

	/**
	 * The configurations
	 */
	public static final Configuration[] configuration = {
			new GraphicsConfiguration(), new UpdateConfiguration(),
			new XMLConfiguration(), };

	/**
	 * The default player's location
	 */
	public static final Location DEFAULT_PLAYER_LOCATION = Location.create(20,
			20);

	/**
	 * The moving speed of the ship
	 */
	public static final int SPEED_SHIP = 10;

	/**
	 * The speed of the laser
	 */
	public static final int LASER_SPEED = 10;

	/**
	 * The speed of the rock
	 */
	public static final int ROCK_SPEED = 10;

	/**
	 * The amount of how fast the rocks coming in(seconds)
	 */
	public static final int NEW_ROCK_RATE = 7;

	/**
	 * The delay of the laser (how fast you can shoot one) (milliseconds)
	 */
	public static final int LASER_DELAY = 400;

	/**
	 * Every time the game updates in this certain amount of time
	 */
	public static final int UPDATE_TIME_MILLISECONDS = 50;

	/**
	 * The meteriod image
	 */
	public static final Image METERIOID_IMAGE = new ImageIcon(
			"./data/images/meteriod.png").getImage();

	/**
	 * The Space background
	 */
	public static final Image SPACE_BACKGROUND = new ImageIcon(
			"./data/images/space_image.png").getImage();

	/**
	 * The Ship image
	 */
	public static final Image SHIP_IMAGE = new ImageIcon(
			"./data/images/space_ship.png").getImage();

	/**
	 * The Imperial march music id
	 */
	public static final int LASER_SOUND = 2;

	/**
	 * The explosion sound
	 */
	public static final int EXPLOSION_SOUND = 1;
}
