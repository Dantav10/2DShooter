/**
 * MusicHandler
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.server.model.music;

import java.io.File;

import javax.media.Format;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.PlugInManager;
import javax.media.format.AudioFormat;

/**
 * The music handler
 */
public class MusicHandler {

	/**
	 * The music instances
	 */
	public static final Music[] music = new Music[3];

	/**
	 * the singleton
	 */
	private static final MusicHandler singleton = new MusicHandler();

	/**
	 * the music player
	 */
	private Player musicPlayer;

	/**
	 * Plays the music
	 */
	public MusicHandler sendMusic() {
		try {
			musicPlayer = Manager.createPlayer(new MediaLocator(new File(
					"./data/music/" + music[0].getPath()).toURI().toURL()));
			musicPlayer.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return this;
	}

	/**
	 * Stops the musicPlayer
	 */
	public MusicHandler stopMusic() {
		this.musicPlayer.stop();
		return this;
	}

	/**
	 * Plays a sound
	 */
	public MusicHandler sendSound(int i) {
		try {
			Player player = Manager.createPlayer(new MediaLocator(new File(
					"./data/music/" + music[i].getPath()).toURI().toURL()));
			player.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return this;
	}

	/**
	 * Sets up the player
	 */
	static {
		Format input1 = new AudioFormat(AudioFormat.MPEGLAYER3);
		Format input2 = new AudioFormat(AudioFormat.MPEG);
		Format output = new AudioFormat(AudioFormat.LINEAR);
		PlugInManager.addPlugIn("com.sun.media.codec.audio.mp3.JavaDecoder",
				new Format[] { input1, input2 }, new Format[] { output },
				PlugInManager.CODEC);
	}

	/**
	 * @return singleton
	 */
	public static MusicHandler getSingleton() {
		return singleton;
	}
}
