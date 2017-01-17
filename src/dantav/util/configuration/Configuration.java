/**
 * Configuration
 * 
 * February 16, 2014
 * 
 * Dan0194 80%
 * Graham 20%
 */
package dantav.util.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import dantav.server.Constants;

public abstract class Configuration {

	/**
	 * The configuration path
	 */
	public abstract String getConfigurationPath();

	/**
	 * The configuration key
	 */
	public abstract String getConfigurationKey();

	/**
	 * The bind
	 */
	public abstract void bind(Object handlerInstance, int id);

	/**
	 * Loads all of the configuration
	 */
	public static final void loadConfiguration() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, IOException {
		for (int i = 0; i < Constants.configuration.length; i++) {
			Constants.configuration[i].parseConfiguration();
		}
	}

	/**
	 * Parses the configuration
	 */
	public void parseConfiguration() throws IOException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		FileInputStream fis = new FileInputStream("./data/"
				+ getConfigurationPath());
		try {
			ConfigurationParser p = new ConfigurationParser(fis);
			Map<String, Map<String, String>> complexMappings = p
					.getComplexMappings();
			if (complexMappings.containsKey(getConfigurationKey())) {
				Map<Class<?>, Object> loadedHandlers = new HashMap<Class<?>, Object>();
				for (Map.Entry<String, String> handler : complexMappings.get(
						getConfigurationKey()).entrySet()) {
					int id = Integer.parseInt(handler.getKey());
					Class<?> handlerClass = Class.forName(handler.getValue());
					Object handlerInstance;
					if (loadedHandlers.containsKey(handlerClass)) {
						handlerInstance = loadedHandlers.get(loadedHandlers
								.get(handlerClass));
					} else {
						handlerInstance = handlerClass.newInstance();
					}
					bind(handlerInstance, id);
				}
			}
		} finally {
			fis.close();
		}
	}

}
