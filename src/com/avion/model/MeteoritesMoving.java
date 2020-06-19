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
import com.avion.dialog.Historique;
import com.avion.dialog.Replay;
import com.avion.dialog.WelcomeController;
import com.avion.meteorite.Meteorite;
import com.avion.meteorite.MeteoriteDeGlace;
import com.avion.meteorite.MeteoriteZigzag;
import com.avion.outils.Outils;
import com.avion.view.Info;
import com.avion.view.LifeBar;

public class MeteoritesMoving extends JLabel {
	private Random randomX;
	private BufferedImage image;
	private int positionMeteoriteX;
	private int positionMeteoriteY;
	private static int life = 10;
	private static int score;
	private static boolean display = true;
	private static JLabel explosion;
	private static boolean continuer = true;
	private static JFrame vFrame;
	private static int counter = 0;

	private int positionMeteoriteXZigZag;

	public MeteoritesMoving(Meteorite meteorite, Spacecraft spacecraft, JFrame frame) {
		vFrame = frame;
		explosion = new JLabel(new ImageIcon(AnimatedPictures.tExplosion));
		explosion.setSize(100, 100);
		randomX = new Random();
		setSize(Constante.WIDTH, Constante.HEIGHT);
		setVisible(true);
		image = meteorite.getImage();
		positionMeteoriteX = randomX.nextInt(Constante.WIDTH - meteorite.getTaille());
		positionMeteoriteY = 0;
		positionMeteoriteXZigZag = meteorite instanceof MeteoriteZigzag ? positionMeteoriteX : positionMeteoriteXZigZag;
		startPlaying(meteorite, spacecraft);
	}

	public void startPlaying(Meteorite meteorite, Spacecraft spacecraft) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (continuer) {
					testLife();
					playe(meteorite, spacecraft);
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					remove(explosion);
				}
				synchronized (explosion) {
					if (display) {
						new Historique();
						display = false;
					}
				}
			}

		}).start();
	}

	public void playe(Meteorite meteorite, Spacecraft spacecraft) {
		LifeBar.setLifeBar(life);
		if (meteorite instanceof MeteoriteZigzag) {
			positionMeteoriteXZigZag += 10;
			positionMeteoriteX += ((positionMeteoriteXZigZag / Constante.WIDTH) % 2 == 0) ? 10 : -10;
		}
		if (CalculateDistance.isCollided(positionMeteoriteX, positionMeteoriteY, meteorite.getTaille(), spacecraft)) {
			life -= meteorite.getDegat();
			Info.setLife(life);
			explosion.setLocation(spacecraft.getX(), spacecraft.getY());
			add(explosion);
			revalidate();
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
		repaint();

	}

	public void testLife() {
		if (life <= 0) {
			synchronized (explosion) {
				counter++;
				counter %= 5;
				if (counter == 1) {
					Outils.writeFile(WelcomeController.getName() + ";");
					Outils.writeFile(Integer.toString(Info.getScore()) + ";");
					Outils.writeFile(Outils.getDate() + "\n");
					Replay replay = new Replay(vFrame);
					continuer = replay.getResult() == 0;
					positionMeteoriteY = 0;
					life = 10;
					Info.setLife(life);
					Info.setScore(0);
					LifeBar.setLifeBar(life);
				}
			}
			positionMeteoriteY = (randomX.nextInt(100) * -1) - 100;

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
