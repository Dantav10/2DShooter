/**
 * StartButtonImage
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.server.image.impl;

import dantav.server.Server;
import dantav.server.image.Image;
import dantav.server.image.ImageType;

public class StartButtonImage implements ImageType {

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.image.ImageType#getAction()
	 */
	@Override
	public void getAction(Image image) {
		Server.getSingleton().startServer();
	}

}
