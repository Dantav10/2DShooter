/**
 * UpdateConfiguration
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.util.configuration.impl;

import dantav.server.model.update.UpdateHandler;
import dantav.server.model.update.UpdateType;
import dantav.util.configuration.Configuration;

public class UpdateConfiguration extends Configuration {

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.util.configuration.Configuration#getConfigurationPath()
	 */
	@Override
	public String getConfigurationPath() {
		return "update.cfg";
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.util.configuration.Configuration#getConfigurationKey()
	 */
	@Override
	public String getConfigurationKey() {
		return "update";
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.util.configuration.Configuration#bind(java.lang.Object, int)
	 */
	@Override
	public void bind(Object handlerInstance, int id) {
		UpdateHandler.getUpdateHandler().updateType[id] = (UpdateType) handlerInstance;
	}

}
