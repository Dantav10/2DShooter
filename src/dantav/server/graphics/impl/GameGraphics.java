/**
 * InfoGraphics
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.server.graphics.impl;

import java.awt.Color;
import java.awt.Graphics;

import dantav.server.graphics.GraphicsType;
import dantav.server.model.Ship;

public class GameGraphics implements GraphicsType {

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.graphics.GraphicsType#getGraphics(java.awt.Graphics)
	 */
	@Override
	public void getGraphics(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(50, 10, Ship.getSingleton().getHealth() * 10, 10);
		g.setColor(Color.WHITE);
		g.drawString("Health:", 0, 20);
		g.drawString("Score: " + Ship.getSingleton().getScore(), 160, 20);
		for (int i = 0; i < Ship.getSingleton().getLaserAmount(); i++) {
			g.setColor(Color.MAGENTA);
			g.fillOval(220 + (i * 15), 10, 10, 10);
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
