/**
 * UpdateHandler
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.server.model.update;

public class UpdateHandler {

	/**
	 * The singleton
	 */
	private static final UpdateHandler singleton = new UpdateHandler();

	/**
	 * Amount of updates needed
	 */
	public final UpdateType[] updateType = new UpdateType[2];

	/**
	 * Handles all of the UpdateType classes
	 */
	public UpdateHandler sendUpdateHandler() {
		for (int i = 0; i < updateType.length; i++) {
			updateType[i].getUpdate();
		}
		return this;
	}

	/**
	 * @return singleton
	 */
	public static UpdateHandler getUpdateHandler() {
		return singleton;
	}

}
