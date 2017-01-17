/**
 * PlayerMovementUpdate
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.server.model.update.impl;

import dantav.server.model.ShipMovement;
import dantav.server.model.update.UpdateType;

public class PlayerMovementUpdate implements UpdateType {

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.model.update.UpdateType#getUpdate()
	 */
	@Override
	public void getUpdate() {
		ShipMovement.getSingleton().sendShipApproval();
	}

}
