/**
 * TitleTextGraphics
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.server.graphics.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import dantav.server.graphics.GraphicsType;

public class TitleTextGraphics implements GraphicsType {

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.graphics.GraphicsType#getGraphics(java.awt.Graphics)
	 */
	@Override
	public void getGraphics(Graphics g) {
		g.setColor(Color.RED);
		g.setFont(new Font("Market", Font.ITALIC, 40));
		g.drawString("2D Shooter", 180, 150);
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Arial", Font.BOLD, 16));
		g.drawString("Copyright of Dan0194", 0, 360);
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
