/**
 * ShipMovement
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.server.model;

import dantav.server.Constants;

public class ShipMovement {

	/**
	 * The singleton
	 */
	private static final ShipMovement singleton = new ShipMovement();

	/**
	 * The key direction
	 */
	private KeyDirection keyDirection = null;

	/**
	 * @auther Dan0194 They key direction enum
	 */
	public enum KeyDirection {
		/**
		 * Up key
		 */
		UP,
		/**
		 * Down key
		 */
		DOWN;
	}

	/**
	 * Moves the ship
	 */
	public ShipMovement sendShipMovement() {
		final int direction = keyDirection.ordinal() == 0 ? -Constants.SPEED_SHIP
				: Constants.SPEED_SHIP;
		Ship.getSingleton().setLocation(
				Location.create(Ship.getSingleton().getLocation().getX(), Ship
						.getSingleton().getLocation().getY()
						+ direction));
		return this;
	}

	/**
	 * All of the checks before can move
	 */
	public ShipMovement sendShipApproval() {
		/**
		 * If the key direction is null
		 */
		if (keyDirection == null) {
			return null;
		}
		/**
		 * If they are trying to move up and are at the top of the screen
		 */
		if (keyDirection == KeyDirection.UP
				&& Ship.getSingleton().getLocation().getY() < -5) {
			return null;
		}
		/**
		 * If they are trying to move down and are at the bottom of the screen
		 */
		if (keyDirection == KeyDirection.DOWN
				&& Ship.getSingleton().getLocation().getY() > 298) {
			return null;
		}
		/**
		 * If everything is fine send the ship movement
		 */
		return sendShipMovement();
	}

	/**
	 * @return keyDirection
	 */
	public KeyDirection getKeyDirection() {
		return keyDirection;
	}

	/**
	 * Sets the keyDirection to the keyDirection
	 * 
	 * @param keyDirection
	 */
	public void setKeyDirection(KeyDirection keyDirection) {
		this.keyDirection = keyDirection;
	}

	/**
	 * @return singleton
	 */
	public static ShipMovement getSingleton() {
		return singleton;
	}
}
