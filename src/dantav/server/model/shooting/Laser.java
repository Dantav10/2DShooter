/**
 * Laser
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.server.model.shooting;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import dantav.server.model.music.MusicHandler;
import dantav.server.Constants;
import dantav.server.model.Location;
import dantav.server.model.Ship;

public class Laser extends Shooting {

	/**
	 * Sets the location of the laser
	 */
	public Laser() {
		this.setLocation(getDefaultLocation());
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.model.shooting.Shooting#getInteraction() When
	 *      interacting with something this is called
	 */
	@Override
	protected void getInteraction() {
		for (int i = 0; i < shooting.size(); i++) {
			if (shooting.get(i) instanceof Rock) {
				final Rectangle rock = new Rectangle(shooting.get(i)
						.getLocation().getX(), shooting.get(i).getLocation()
						.getY(), Constants.METERIOID_IMAGE.getWidth(null),
						Constants.METERIOID_IMAGE.getHeight(null));
				final Rectangle laser = new Rectangle(
						this.getLocation().getX(), this.getLocation().getY(),
						20, 20);
				if (rock.intersects(laser)) {
					MusicHandler.getSingleton().sendSound(
							Constants.EXPLOSION_SOUND);
					shooting.remove(i);
					shooting.remove(this);
				}
			}
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.model.shooting.Shooting#getSpeed() The speed of the
	 *      laser
	 */
	@Override
	protected int getSpeed() {
		return Constants.LASER_SPEED;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.model.shooting.Shooting#destroy() What point to
	 *      destroy it from the list
	 */
	@Override
	protected boolean destroy() {
		return this.getLocation().getX() > 600;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.model.shooting.Shooting#getDefaultLocation() The
	 *      Default location
	 */
	@Override
	protected Location getDefaultLocation() {
		return Location.create(Ship.getSingleton().getLocation().getX() + 50,
				Ship.getSingleton().getLocation().getY() + 35);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.model.shooting.Shooting#getScore()
	 */
	@Override
	protected int getScore() {
		return 0;
	}

	@Override
	public void getGraphics(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(this.getLocation().getX(), this.getLocation().getY(), 30, 10);
	}
}
