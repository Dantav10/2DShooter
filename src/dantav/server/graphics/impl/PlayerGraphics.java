/**
 * PlayerGraphics
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.server.graphics.impl;

import java.awt.Graphics;

import dantav.server.graphics.GraphicsType;
import dantav.server.model.Ship;

public class PlayerGraphics implements GraphicsType {

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.graphics.GraphicsType#getGraphics(java.awt.Graphics)
	 */
	@Override
	public void getGraphics(Graphics g) {
		g.drawImage(Ship.getSingleton().getImage(), Ship.getSingleton()
				.getLocation().getX(),
				Ship.getSingleton().getLocation().getY(), null);

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.graphics.GraphicsType#isTitleGraphics()
	 */
	@Override
	public boolean isTitleGraphics() {
		return false;
	}

}
