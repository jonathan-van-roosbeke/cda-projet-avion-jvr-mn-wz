package com.avion.model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.avion.collision.CalculateDistance;
import com.avion.constante.AnimatedPictures;
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
	private static int nombreDeVie = 100;

	public MeteoritesMoving(Meteorite meteorite, Spacecraft spacecraft) {
		JLabel explosion = new JLabel(new ImageIcon(AnimatedPictures.tExplosion));
		explosion.setSize(100, 100);
		this.meteorite = meteorite;
		this.spacecraft = spacecraft;
		this.id = ++cmpt;
		randomX = new Random();
		setSize(Constante.WIDTH, Constante.HEIGHT);
		setVisible(true);
		image = meteorite.getImage();
		posX = randomX.nextInt(Constante.WIDTH - meteorite.getTaille()) + (meteorite.getTaille());
		posY = 0;

		new Thread(new Runnable() {

			public void run() {
				while (nombreDeVie > 0) {
					if (CalculateDistance.isCollided(posX, posY, meteorite.getTaille(), spacecraft)) {
						explosion.setLocation(spacecraft.getX(), spacecraft.getY());
						add(explosion);
						revalidate();
					}
					posY += meteorite.getVitesse();
					if (posY + meteorite.getVitesse() > Constante.WIDTH) {
						posY = -meteorite.getTaille();
						posX = randomX.nextInt(Constante.WIDTH - meteorite.getTaille()) + (meteorite.getTaille());
					}
					posY %= Constante.WIDTH;
					repaint();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					remove(explosion);

				}
			}

		}).start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, posX, posY, null);
	}
}
