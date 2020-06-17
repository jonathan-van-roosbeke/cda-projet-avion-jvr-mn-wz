package com.avion.model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;

public class ScrollingBackground extends JLabel implements Runnable {

	// Two copies of the background image to scroll
	private Background backOne;
	private Background backTwo;

	private BufferedImage back;

	public ScrollingBackground() {
		backOne = new Background();
		backTwo = new Background(0, backOne.getImageHeight());

		new Thread(this).start();
		setVisible(true);
	}

	@Override
	public void run() {
		try {
			while (true) {
				Thread.currentThread().sleep(3);
				repaint();
			}
		} catch (Exception e) {
		}
	}

	@Override
	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		Graphics2D twoD = (Graphics2D) window;

		if (back == null)
			back = (BufferedImage) (createImage(getWidth(), getHeight()));

		Graphics buffer = back.createGraphics();

		backOne.draw(buffer);
		backTwo.draw(buffer);

		twoD.drawImage(back, null, 0, 0);
	}
}