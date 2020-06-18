package com.avion.model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JLabel;

import com.avion.collision.CalculateDistance;
import com.avion.constante.Constante;
import com.avion.meteorite.Meteorite;

public class MeteoritesMoving extends JLabel {
	private Random randomX;
	private BufferedImage image;
	private int posX;
	private int posY;
	private Spacecraft spacecraft;
	private Meteorite meteorite;
	private static int cmpt;
	private int id;

	public MeteoritesMoving(Meteorite meteorite, Spacecraft spacecraft) {
		this.meteorite = meteorite;
		this.spacecraft = spacecraft;
		this.id = ++cmpt;
		randomX = new Random();
		setSize(Constante.WIDTH, Constante.HEIGHT);
		setVisible(true);
		image = meteorite.getImage();
		posX = randomX.nextInt(Constante.WIDTH);
		posY = 0;
		new Thread(new Runnable() {

			public void run() {
				while (!CalculateDistance.isCollided(posX, posY, meteorite.getTaille(), spacecraft)) {
					posY += meteorite.getVitesse();
					if (posY + meteorite.getVitesse() > Constante.WIDTH) {
						posY = -meteorite.getTaille();
						posX = randomX.nextInt(Constante.WIDTH - meteorite.getTaille()) - (meteorite.getTaille() / 2);
					}
					posY %= Constante.WIDTH;
					repaint();
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				System.out.println("booom");
			}

		}).start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, posX, posY, null);
	}
}
