/**
 * ShootingGraphics
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.server.graphics.impl;

import java.awt.Graphics;

import dantav.server.graphics.GraphicsType;
import dantav.server.model.shooting.Shooting;

public class ShootingGraphics implements GraphicsType {

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.graphics.GraphicsType#getGraphics(java.awt.Graphics)
	 */
	@Override
	public void getGraphics(Graphics g) {
		for (int i = 0; i < Shooting.shooting.size(); i++) {
			Shooting.shooting.get(i).getGraphics(g);
		}
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
