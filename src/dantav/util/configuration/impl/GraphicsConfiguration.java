/**
 * GraphicsConfiguration
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.util.configuration.impl;

import dantav.server.graphics.*;
import dantav.util.configuration.Configuration;

public class GraphicsConfiguration extends Configuration {

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.util.configuration.Configuration#getConfigurationPath()
	 */
	@Override
	public String getConfigurationPath() {
		return "graphics.cfg";
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.util.configuration.Configuration#getConfigurationKey()
	 */
	@Override
	public String getConfigurationKey() {
		return "graphic";
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.util.configuration.Configuration#bind(java.lang.Object, int)
	 */
	@Override
	public void bind(Object handlerInstance, int id) {
		GraphicsHandler.graphicsType[id] = (GraphicsType) handlerInstance;
	}

}
