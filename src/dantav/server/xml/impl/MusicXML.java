/**
 * MusicXML
 * 
 * February 17, 2014
 * 
 * Dan0194
 */
package dantav.server.xml.impl;

import dantav.server.model.music.Music;
import dantav.server.model.music.MusicHandler;
import dantav.server.xml.XMLType;

public class MusicXML extends XMLType {

	/**
	 * This tells the XMLType what array to store the data into
	 */
	public MusicXML() {
		super(MusicHandler.music);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.xml.XMLType#getPath()
	 */
	@Override
	public String getPath() {
		return "music.xml";
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.xml.XMLType#getKey()
	 */
	@Override
	public String getKey() {
		return "music";
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.xml.XMLType#getClassName()
	 */
	@Override
	public Class<?> getClassName() {
		return Music.class;
	}

}
