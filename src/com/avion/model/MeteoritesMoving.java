package com.avion.model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.avion.collision.CalculateDistance;
import com.avion.constante.AnimatedPictures;
import com.avion.constante.Constante;
import com.avion.meteorite.Meteorite;
import com.avion.meteorite.MeteoriteDeGlace;
import com.avion.meteorite.MeteoriteZigzag;
import com.avion.view.Info;
import com.avion.view.LifeBar;

public class MeteoritesMoving extends JLabel {
	private Random randomX;
	private BufferedImage image;
	private int positionMeteoriteX;
	private int positionMeteoriteY;
	private static int life = 100;
	private Spacecraft spacecraft;
	private Meteorite meteorite;
	private static int cmpt;
	private int id;
	private static int score;
	private static boolean display = true;
	private static JLabel explosion;
	private static boolean continuer = true;
	private static JFrame frame;

	private int positionMeteoriteXZigZag;

	public MeteoritesMoving(Meteorite meteorite, Spacecraft spacecraft, JFrame frame) {
		frame = frame;
		explosion = new JLabel(new ImageIcon(AnimatedPictures.tExplosion));
		explosion.setSize(100, 100);
		randomX = new Random();
		setSize(Constante.WIDTH, Constante.HEIGHT);
		setVisible(true);
		image = meteorite.getImage();
		positionMeteoriteX = randomX.nextInt(Constante.WIDTH - meteorite.getTaille());
		positionMeteoriteY = 0;
		positionMeteoriteXZigZag = meteorite instanceof MeteoriteZigzag ? positionMeteoriteX : positionMeteoriteXZigZag;
		startPlaying(meteorite, spacecraft, explosion);
	}

	public void startPlaying(Meteorite meteorite, Spacecraft spacecraft, JLabel explosion) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				int counter = 1;
				while (continuer) {
					if (life <= 0) {
						counter++;
						counter %= 5;

						synchronized (explosion) {
							if (counter == 1) {
//								display = false;
								Replay replay = new Replay(frame);
								System.out.println("Replay?");
								continuer = replay.getResult() == 0;
							}
						}
						positionMeteoriteY = 0;
						life = 100;
//						display = true;
						Info.setLife(life);
					}
					LifeBar.setLifeBar(life);
					if (CalculateDistance.isCollided(positionMeteoriteX, positionMeteoriteY, meteorite.getTaille(),
							spacecraft)) {

						life -= meteorite.getDegat();
						Info.setLife(life);

						explosion.setLocation(spacecraft.getX(), spacecraft.getY());
						add(explosion);
						revalidate();
					}

					positionMeteoriteY += meteorite.getVitesse();
					if (positionMeteoriteY + meteorite.getVitesse() > Constante.WIDTH + meteorite.getTaille()
							+ Constante.HEIGHT_CLAVIER) {

						positionMeteoriteY = -meteorite.getTaille();
						positionMeteoriteX = randomX.nextInt(Constante.WIDTH - meteorite.getTaille());
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
				System.out.println("booom");

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
			positionMeteoriteXZigZag += 10;
			positionMeteoriteX += ((positionMeteoriteXZigZag / Constante.WIDTH) % 2 == 0) ? 10 : -10;
		}

		positionMeteoriteY += meteorite.getVitesse();
		if (positionMeteoriteY + meteorite.getVitesse() > Constante.WIDTH + meteorite.getTaille()
				+ Constante.HEIGHT_CLAVIER) {

			Info.setScore(meteorite.getScore() + Info.getScore());
			positionMeteoriteY = -meteorite.getTaille();
			positionMeteoriteX = randomX.nextInt(Constante.WIDTH - meteorite.getTaille());
			positionMeteoriteXZigZag = meteorite instanceof MeteoriteZigzag ? positionMeteoriteX
					: positionMeteoriteXZigZag;

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
