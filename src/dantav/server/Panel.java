/**
 * Panel
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.server;

import java.awt.Graphics;

import javax.swing.JPanel;

import dantav.server.graphics.GraphicsHandler;
import dantav.server.model.listeners.KeysListener;
import dantav.server.model.listeners.MousesListener;

@SuppressWarnings("serial")
public class Panel extends JPanel {

	/**
	 * The singleton
	 */
	private static final Panel singleton = new Panel();

	/**
	 * Gets the panel characteristics
	 */
	public Panel sendPanel() {
		this.setSize(Constants.JFRAME_DIMENSIONS);
		this.setVisible(true);
		this.setFocusable(true);
		this.addKeyListener(new KeysListener());
		this.addMouseListener(new MousesListener());
		return this;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics) paints the
	 *      graphics
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Constants.SPACE_BACKGROUND, 0, 0, null);
		GraphicsHandler.getSingleton().loadAllGraphics(g);
	}

	/**
	 * @return singleton
	 */
	public static Panel getSingleton() {
		return singleton;
	}

}
