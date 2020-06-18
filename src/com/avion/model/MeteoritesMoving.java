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
import com.avion.meteorite.MeteoriteDeGlace;

public class MeteoritesMoving extends JLabel {
	private Random randomX;
	private BufferedImage image;
	private int posX;
	private int posY;
	private static int nombreDeVie = 100;

	public MeteoritesMoving(Meteorite meteorite, Spacecraft spacecraft) {
		JLabel explosion = new JLabel(new ImageIcon(AnimatedPictures.tExplosion));
		explosion.setSize(100, 100);
		randomX = new Random();
		setSize(Constante.WIDTH, Constante.HEIGHT);
		setVisible(true);
		image = meteorite.getImage();
		posX = randomX.nextInt(Constante.WIDTH - meteorite.getTaille());
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
					if (posY + meteorite.getVitesse() > Constante.WIDTH + meteorite.getTaille()
							+ Constante.HEIGHT_CLAVIER) {

						posY = -meteorite.getTaille();
						System.out.println(posY);
						posX = randomX.nextInt(Constante.WIDTH - meteorite.getTaille());
						if (meteorite instanceof MeteoriteDeGlace) {
							((MeteoriteDeGlace) meteorite).setTaille();
						}
					}
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
