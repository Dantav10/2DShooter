/**
 * GraphicsHandler
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.server.graphics;

import java.awt.Graphics;

import dantav.server.Server;

public class GraphicsHandler {

	/**
	 * The singleton
	 */
	public static final GraphicsHandler singleton = new GraphicsHandler();

	/**
	 * The amount of graphics
	 */
	public static final GraphicsType[] graphicsType = new GraphicsType[6];

	/**
	 * Loads the graphics
	 */
	public GraphicsHandler loadAllGraphics(Graphics g) {
		for (int i = 0; i < graphicsType.length; i++) {
			if (graphicsType[i].isTitleGraphics()
					&& !Server.getSingleton().isRunning()) {
				graphicsType[i].getGraphics(g);
			}
			if (!graphicsType[i].isTitleGraphics()
					&& Server.getSingleton().isRunning()) {
				graphicsType[i].getGraphics(g);
			}
		}
		return this;
	}

	/**
	 * @return singleton
	 */
	public static GraphicsHandler getSingleton() {
		return singleton;
	}

}
