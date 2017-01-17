/**
 * ImageXML
 * 
 * February 17, 2014
 * 
 * Dan0194
 */
package dantav.server.xml.impl;

import dantav.server.image.Image;
import dantav.server.image.ImageHandler;
import dantav.server.xml.XMLType;

public class ImageXML extends XMLType {

	/**
	 * This tells the XMLType what array to store the data into
	 */
	public ImageXML() {
		super(ImageHandler.image);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.xml.XMLType#getKey()
	 */
	@Override
	public String getKey() {
		return "image";
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.xml.XMLType#getClassName()
	 */
	@Override
	public Class<?> getClassName() {
		return Image.class;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see dantav.server.xml.XMLType#getPath()
	 */
	@Override
	public String getPath() {
		return "image.xml";
	}

}
