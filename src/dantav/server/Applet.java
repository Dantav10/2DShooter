/**
 * Applet
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.server;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Applet {

	/**
	 * Main method
	 */
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, IOException {
		Server.getSingleton().sendServer();
		new Applet().getApplet(Panel.getSingleton().sendPanel());
	}

	/**
	 * Gets the panel characteristics
	 */
	private Applet getApplet(JPanel jPanel) {
		JFrame jFrame = new JFrame();
		jFrame.setSize(Constants.JFRAME_DIMENSIONS);
		jFrame.setVisible(true);
		jFrame.setResizable(false);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.add(jPanel);
		return this;
	}
}
