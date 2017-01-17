package dantav.server.image.impl;

import dantav.server.Panel;
import dantav.server.image.Image;
import dantav.server.image.ImageType;

public class InfoButtonImage implements ImageType {

	@Override
	public void getAction(Image image) {
		image.setClicked(!image.isClicked());
		Panel.getSingleton().repaint();
	}

}
