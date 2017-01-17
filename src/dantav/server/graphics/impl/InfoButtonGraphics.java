package dantav.server.graphics.impl;

import java.awt.Color;
import java.awt.Graphics;

import dantav.server.graphics.GraphicsType;
import dantav.server.image.ImageHandler;

public class InfoButtonGraphics implements GraphicsType {

	/**
	 * The info button id
	 */
	private static final int INFO_BUTTON_ID = 1;

	@Override
	public void getGraphics(Graphics g) {
		System.out.println(ImageHandler.image[INFO_BUTTON_ID].isClicked());
		if (ImageHandler.image[INFO_BUTTON_ID].isClicked()) {
			g.setColor(Color.GREEN);
			g.drawString("Game Objectives:", 330, 300);
			g.drawString("To dodge any meteriod's that are coming in", 240, 320);
			g.drawString("You've got 10 bullets so use them wisely", 250, 340);
		}
	}

	@Override
	public boolean isTitleGraphics() {
		return true;
	}

}
