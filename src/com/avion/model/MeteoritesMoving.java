package com.avion.model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JLabel;

import com.avion.constante.Constante;
import com.avion.meteorite.Meteorite;

public class MeteoritesMoving extends JLabel {
	private Random randomX;
	private BufferedImage image;
	private int posX;
	private int posY;

	public MeteoritesMoving(Meteorite meteorite) {
		randomX = new Random();
		setSize(Constante.WIDTH, Constante.HEIGHT);
		setVisible(true);
		image = meteorite.getImage();
		posX = randomX.nextInt(Constante.WIDTH);
		posY = 0;
		new Thread(new Runnable() {
			int k = Integer.MAX_VALUE;

			public void run() {
				while (k > 0) {
					posY += meteorite.getVitesse();
					if (posY + meteorite.getVitesse() > Constante.WIDTH) {
						posY = 0;
						posX = randomX.nextInt(Constante.WIDTH - meteorite.getTaille()) - (meteorite.getTaille() / 2);
					}
					posY %= Constante.WIDTH;
					repaint();
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					k--;
				}
			}

		}).start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, posX, posY % Constante.HEIGHT, null);
	}
}
