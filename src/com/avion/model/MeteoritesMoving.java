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
import com.avion.meteorite.MeteoriteZigzag;
import com.avion.view.Info;

public class MeteoritesMoving extends JLabel {
	private Random randomX;
	private BufferedImage image;
	private int positionMeteoriteX;
	private int positionMeteoriteY;
	private static int life = 100;
	private static int score;

	private int posXZigZag;

	public MeteoritesMoving(Meteorite meteorite, Spacecraft spacecraft) {
		JLabel explosion = new JLabel(new ImageIcon(AnimatedPictures.tExplosion));
		explosion.setSize(100, 100);
		randomX = new Random();
		setSize(Constante.WIDTH, Constante.HEIGHT);
		setVisible(true);
		image = meteorite.getImage();
		positionMeteoriteX = randomX.nextInt(Constante.WIDTH - meteorite.getTaille());
		positionMeteoriteY = 0;
		posXZigZag = meteorite instanceof MeteoriteZigzag ? positionMeteoriteX : posXZigZag;
		startPlaying(meteorite, spacecraft, explosion);
	}

	public void startPlaying(Meteorite meteorite, Spacecraft spacecraft, JLabel explosion) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (life > 0) {
					if (CalculateDistance.isCollided(posX, posY, meteorite.getTaille(), spacecraft)) {

						explosion.setLocation(spacecraft.getX(), spacecraft.getY());
						add(explosion);
						revalidate();
					}

					posY += meteorite.getVitesse();
					if (posY + meteorite.getVitesse() > Constante.WIDTH + meteorite.getTaille()
							+ Constante.HEIGHT_CLAVIER) {

						posY = -meteorite.getTaille();
						posX = randomX.nextInt(Constante.WIDTH - meteorite.getTaille());
						System.out.println("int " + (posY - 200));
						Info.setScore(meteorite.getScore() + Info.getScore());
						if (meteorite instanceof MeteoriteDeGlace) {
							((MeteoriteDeGlace) meteorite).setTaille();
						}
					}
					move(meteorite, spacecraft, explosion);
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

	public void move(Meteorite meteorite, Spacecraft spacecraft, JLabel explosion) {
		if (CalculateDistance.isCollided(positionMeteoriteX, positionMeteoriteY, meteorite.getTaille(), spacecraft)) {
			life -= meteorite.getDegat();
			Info.setLife(life);
			explosion.setLocation(spacecraft.getX(), spacecraft.getY());
			add(explosion);
			revalidate();
		}
		if (meteorite instanceof MeteoriteZigzag) {
			posXZigZag += 10;
			positionMeteoriteX += ((posXZigZag / Constante.WIDTH) % 2 == 0) ? 10 : -10;
		}

		positionMeteoriteY += meteorite.getVitesse();
		if (positionMeteoriteY + meteorite.getVitesse() > Constante.WIDTH + meteorite.getTaille()
				+ Constante.HEIGHT_CLAVIER) {

			positionMeteoriteY = -meteorite.getTaille();
			positionMeteoriteX = randomX.nextInt(Constante.WIDTH - meteorite.getTaille());
			posXZigZag = meteorite instanceof MeteoriteZigzag ? positionMeteoriteX : posXZigZag;

			if (meteorite instanceof MeteoriteDeGlace) {
				((MeteoriteDeGlace) meteorite).setTaille();
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, positionMeteoriteX, positionMeteoriteY, null);
	}

	public static int getLife() {
		return life;
	}

	public static int getScore() {
		return score;
	}
}
