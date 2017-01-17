/**
 * GraphicsType
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.server.graphics;

import java.awt.Graphics;

public interface GraphicsType {

	/**
	 * get the graphics
	 */
	void getGraphics(Graphics g);

	/**
	 * Is it a graphic specificly just to be shown at the launch title screen
	 */
	boolean isTitleGraphics();

}
