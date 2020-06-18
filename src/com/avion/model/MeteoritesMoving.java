package com.avion.model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JLabel;

import com.avion.collision.CalculateDistance;
import com.avion.constante.Constante;
import com.avion.meteorite.Meteorite;
import com.avion.view.Info;

public class MeteoritesMoving extends JLabel {
	private Random randomX;
	private BufferedImage image;
	private int posX;
	private int posY;
	private Spacecraft spacecraft;
	private Meteorite meteorite;
	private static int cmpt;
	private int id;
	private static int life = 100;
	private static int score;

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

			@Override
			public void run() {
				while (!CalculateDistance.isCollided(posX, posY, meteorite.getTaille(), spacecraft) && life > 0) {

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
				life -= 20;
				Info.setLife(life);
				System.out.println("booom");
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

//	if (meteorite instanceof MeteoriteSimple) {
//		score += 2;
//	}
//	if (meteorite instanceof MeteoriteDeFeu) {
//		score += 1;
//	}
//	if (meteorite instanceof MeteoriteDeGlace) {
//		score += 3;
//	}
//	if (meteorite instanceof MeteoriteIceberg) {
//		score += 4;
//	}
//	if (meteorite instanceof MeteoriteZigzag) {
//		score += 5;
//	}
//	Info.setScore(score);

}
