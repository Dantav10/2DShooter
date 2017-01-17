/**
 * ImageGraphics
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.server.graphics.impl;

import java.awt.Graphics;

import dantav.server.graphics.GraphicsType;
import dantav.server.image.ImageHandler;

public class ImageGraphics implements GraphicsType {

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.graphics.GraphicsType#getGraphics(java.awt.Graphics)
	 */
	@Override
	public void getGraphics(Graphics g) {
		for (int i = 0; i < ImageHandler.image.length; i++) {
			g.drawImage(ImageHandler.image[i].getImage(), ImageHandler.image[i]
					.getLocation().getX(), ImageHandler.image[i].getLocation()
					.getY(), null);
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.graphics.GraphicsType#isTitleGraphics()
	 */
	@Override
	public boolean isTitleGraphics() {
		return true;
	}

}
