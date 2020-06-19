package com.avion.model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;

public class ScrollingBackground extends JLabel implements Runnable {

	/**
	 * Generer automatiquement pour eviter les warning
	 */
	private static final long serialVersionUID = 1L;
	private static Background backOne = new Background();
	private static Background backTwo = new Background(0, backOne.getImageHeight());

	private static BufferedImage back;

	public ScrollingBackground() {
		new Thread(this).start();
		setVisible(true);
	}

	@Override
	public void run() {
		try {
			int k = Integer.MAX_VALUE;
			while (k > 0) {
				Thread.sleep(30);
				repaint();
				k--;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Graphics window) {
		paint(window);
	}

	@Override
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