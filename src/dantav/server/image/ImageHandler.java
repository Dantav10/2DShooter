/**
 * ImageHandler
 * 
 * February 16, 2014
 * 
 * Dan0194
 */
package dantav.server.image;

import dantav.server.model.Boundary;
import dantav.server.model.Location;

public class ImageHandler {

	/**
	 * Amount of images
	 */
	public static Image[] image = new Image[2];

	/**
	 * The singleton
	 */
	private static final ImageHandler singleton = new ImageHandler();

	/**
	 * If the image has been pressed get the action it performs
	 */
	public ImageHandler sendImagePressed(Location location) {
		for (int i = 0; i < image.length; i++) {
			final Boundary boundary = new Boundary(image[i].getLocation()
					.getX(), image[i].getLocation().getX()
					+ image[i].getImage().getWidth(null), image[i]
					.getLocation().getY(), image[i].getLocation().getY()
					+ image[i].getImage().getHeight(null));
			if (Boundary.isInArea(location, boundary)) {
				try {
					image[i].getImageType().getAction(image[i]);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		return this;
	}

	/**
	 * @return singleton
	 */
	public static ImageHandler getSingleton() {
		return singleton;
	}

}
