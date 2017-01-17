/**
 * ShootingUpdate
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.server.model.update.impl;

import dantav.server.Constants;
import dantav.server.Server;
import dantav.server.model.shooting.Rock;
import dantav.server.model.shooting.Shooting;
import dantav.server.model.update.UpdateType;

public class ShootingUpdate implements UpdateType {

	/**
	 * The amount of ticks the server has gone by
	 */
	private int tick;

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.model.update.UpdateType#getUpdate() Updates the
	 *      bullets shot and also every Constants.NEW_ROCK_RATE
	 */
	@Override
	public void getUpdate() {
		for (int i = 0; i < Shooting.shooting.size(); i++) {
			Shooting.shooting.get(i).handleLaser();
		}
		if (!Server.getSingleton().isRunning()) {
			tick = 0;
			return;
		}
		if (tick >= Constants.NEW_ROCK_RATE) {
			new Rock().executeShot();
			tick = 0;
		}
		tick++;
	}

}
