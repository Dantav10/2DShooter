package dantav.util.configuration.impl;

import dantav.server.xml.XMLType;
import dantav.util.configuration.Configuration;

public class XMLConfiguration extends Configuration {

	@Override
	public String getConfigurationPath() {
		return "xml.cfg";
	}

	@Override
	public String getConfigurationKey() {
		return "xml";
	}

	@Override
	public void bind(Object handlerInstance, int id) {
		XMLType.xmlType[id] = (XMLType) handlerInstance;
	}

}
