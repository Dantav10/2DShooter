/**
 * KeysListener
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.server.model.listeners;

import dantav.server.model.music.MusicHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import dantav.server.Constants;
import dantav.server.model.Ship;
import dantav.server.model.ShipMovement;
import dantav.server.model.ShipMovement.KeyDirection;
import dantav.server.model.shooting.Laser;

public class KeysListener implements KeyListener {

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			ShipMovement.getSingleton().setKeyDirection(KeyDirection.UP);
			break;
		case KeyEvent.VK_DOWN:
			ShipMovement.getSingleton().setKeyDirection(KeyDirection.DOWN);
			break;
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_SPACE:
			if (Ship.getSingleton().getLaserAmount() > 0) {
				final Laser laser = new Laser();
				laser.executeShot();
				MusicHandler.getSingleton().sendSound(Constants.LASER_SOUND);
				Ship.getSingleton().setLaserAmount(
						Ship.getSingleton().getLaserAmount() - 1);
			} else {
				Ship.logger.info("Your out of ammo.");
			}
			break;
		default:
			ShipMovement.getSingleton().setKeyDirection(null);
		}
	}

}
