/**
 * Image
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.server.image;

import javax.swing.ImageIcon;

import dantav.server.model.Location;

public class Image {

	/**
	 * The x coordinate where image will be shown
	 */
	private int x;
	/**
	 * The y coordinate where image will be shown
	 */
	private int y;
	/**
	 * s The path of the image
	 */
	private String path;
	/**
	 * The ImageType class it is linked too
	 */
	private String imageType;
	/**
	 * Is the image clicked
	 */
	private boolean isClicked;

	/**
	 * Creates a new location based on x and y coordinates
	 */
	public Location getLocation() {
		return Location.create(x, y);
	}

	/**
	 * @return image
	 */
	public java.awt.Image getImage() {
		return new ImageIcon("./data/images/" + path).getImage();
	}

	/**
	 * @return isClicked
	 */
	public boolean isClicked() {
		return isClicked;
	}

	/**
	 * @param isClicked
	 */
	public void setClicked(boolean isClicked) {
		this.isClicked = isClicked;
	}

	/**
	 * The image type
	 */
	public ImageType getImageType() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		Class<?> image = Class.forName("dantav.server.image.impl." + imageType);
		Object object = image.newInstance();
		return (ImageType) object;
	}

}
