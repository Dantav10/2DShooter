/**
 * Rock
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.server.model.shooting;

import dantav.server.model.music.MusicHandler;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import dantav.server.Constants;
import dantav.server.model.Location;
import dantav.server.model.Ship;

public class Rock extends Shooting {

	/**
	 * Sets the default location
	 */
	public Rock() {
		this.setLocation(getDefaultLocation());
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.model.shooting.Shooting#getInteraction() When
	 *      interactacting with something this is called
	 */
	@Override
	protected void getInteraction() {
		final Rectangle ship = new Rectangle(Ship.getSingleton().getLocation()
				.getX(), Ship.getSingleton().getLocation().getY(),
				Constants.SHIP_IMAGE.getWidth(null),
				Constants.SHIP_IMAGE.getHeight(null));
		final Rectangle rock = new Rectangle(this.getLocation().getX(), this
				.getLocation().getY(),
				Constants.METERIOID_IMAGE.getWidth(null),
				Constants.METERIOID_IMAGE.getHeight(null));
		if (rock.intersects(ship)) {
			MusicHandler.getSingleton().sendSound(Constants.EXPLOSION_SOUND);
			Ship.getSingleton().setHealth(Ship.getSingleton().getHealth() - 1);
			Ship.getSingleton().sendDeath();
			shooting.remove(this);
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.model.shooting.Shooting#getSpeed() The speed of the
	 *      rock
	 */
	@Override
	protected int getSpeed() {
		return -Constants.LASER_SPEED;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.model.shooting.Shooting#destroy() What point to
	 *      destroy from the list
	 */
	@Override
	protected boolean destroy() {
		return this.getLocation().getX() < -150;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.model.shooting.Shooting#getDefaultLocation() The
	 *      default location
	 */
	@Override
	protected Location getDefaultLocation() {
		return Location.create(600, new Random().nextInt(300) - 10);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.model.shooting.Shooting#getScore()
	 */
	@Override
	protected int getScore() {
		return 1;
	}

	@Override
	public void getGraphics(Graphics g) {
		g.drawImage(Constants.METERIOID_IMAGE, this.getLocation().getX(), this
				.getLocation().getY(), null);
	}

}
