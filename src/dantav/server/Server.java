/**
 * Server
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.server;

import dantav.server.model.music.MusicHandler;

import java.io.IOException;

import dantav.server.model.update.UpdateHandler;
import dantav.server.xml.XMLType;
import dantav.util.configuration.Configuration;

public class Server implements Runnable {

	/**
	 * is the server running
	 */
	public volatile boolean isRunning;

	/**
	 * The singleton
	 */
	private static final Server singleton = new Server();

	/**
	 * What the server calls
	 */
	public Server sendServer() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, IOException {
		Configuration.loadConfiguration();
		XMLType.loadXML();
		MusicHandler.getSingleton().sendMusic();
		return this;
	}

	/**
	 * Starts the server
	 */
	public Server startServer() {
		this.isRunning = true;
		new Thread(this).start();
		MusicHandler.getSingleton().stopMusic();
		return this;
	}

	/**
	 * Stops the server
	 */
	public Server stopServer() {
		this.isRunning = false;
		Panel.getSingleton().repaint();
		MusicHandler.getSingleton().sendMusic();
		return this;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 * @see dantav.server.Constants.UPDATE_TIME_MILLISECONDS
	 */
	@Override
	public void run() {
		while (isRunning) {
			Panel.getSingleton().repaint();
			try {
				Thread.sleep(Constants.UPDATE_TIME_MILLISECONDS);
				UpdateHandler.getUpdateHandler().sendUpdateHandler();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Sets the isRunning to isRunning
	 * 
	 * @param isRunning
	 */
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	/**
	 * @return isRunning
	 */
	public boolean isRunning() {
		return isRunning;
	}

	/**
	 * @return singleton
	 */
	public static Server getSingleton() {
		return singleton;
	}
}
