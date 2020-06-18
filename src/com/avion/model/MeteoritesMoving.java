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
import com.avion.view.Info;
import com.avion.view.LifeBar;

public class MeteoritesMoving extends JLabel {
	private Random randomX;
	private BufferedImage image;
	private int posX;
	private int posY;
	private Spacecraft spacecraft;
	private Meteorite meteorite;
	private static int cmpt;
	private int id;
	private static int life = 10;
	private static int score;
	private static boolean display = true;
	private static JLabel explosion;
	private static boolean continuer = true;

	public MeteoritesMoving(Meteorite meteorite, Spacecraft spacecraft, JFrame frame) {
		explosion = new JLabel(new ImageIcon(AnimatedPictures.tExplosion));
		explosion.setSize(100, 100);
		randomX = new Random();
		setSize(Constante.WIDTH, Constante.HEIGHT);
		setVisible(true);
		image = meteorite.getImage();
		posX = randomX.nextInt(Constante.WIDTH - meteorite.getTaille());
		posY = 0;

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
						posY = 0;
						life = 100;
//						display = true;
						Info.setLife(life);
					}
					LifeBar.setLifeBar(life);
					if (CalculateDistance.isCollided(posX, posY, meteorite.getTaille(), spacecraft)) {

						life -= meteorite.getDegat();
						Info.setLife(life);

						explosion.setLocation(spacecraft.getX(), spacecraft.getY());
						add(explosion);
						revalidate();
					}

					posY += meteorite.getVitesse();
					if (posY + meteorite.getVitesse() > Constante.WIDTH + meteorite.getTaille()
							+ Constante.HEIGHT_CLAVIER) {

						posY = -meteorite.getTaille();
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
				System.out.println("booom");

//				
			}

		}).start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, posX, posY, null);
	}

	public static int getLife() {
		return life;
	}

	public static int getScore() {
		return score;
	}

}
