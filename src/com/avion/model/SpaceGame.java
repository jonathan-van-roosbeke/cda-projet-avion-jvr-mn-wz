package com.avion.model;

import java.awt.Dimension;
import java.util.Random;

import javax.swing.JLabel;

import com.avion.constante.Constante;
import com.avion.meteorite.Meteorite;
import com.avion.meteorite.MeteoriteZigzag;

public class SpaceGame extends JLabel {
	private Spacecraft vaisseau;
	private boolean start = false;
	private Random randomX = new Random();

	public SpaceGame() {

		Meteorite meteoriteSimple = Meteorite.meteorites.get(0);
		Meteorite meteoriteDeFeu = Meteorite.meteorites.get(1);
		Meteorite meteoriteZigzag = Meteorite.meteorites.get(2);
		Meteorite meteoriteDeGlace = Meteorite.meteorites.get(3);
		Meteorite meteoriteIceberg = Meteorite.meteorites.get(4);
		meteoriteDeFeu.setLocation(randomX.nextInt(Constante.WIDTH) - 50, -100);
		meteoriteZigzag.setLocation(randomX.nextInt(Constante.WIDTH) - 50, -300);
		meteoriteDeGlace.setLocation(randomX.nextInt(Constante.WIDTH) - 50, -600);
		meteoriteIceberg.setLocation(randomX.nextInt(Constante.WIDTH) - 50, -800);
		this.add(meteoriteSimple);
		this.add(meteoriteDeFeu);
		this.add(meteoriteZigzag);
		this.add(meteoriteDeGlace);
		this.add(meteoriteIceberg);
		this.setLayout(null);

		ScrollingBackground background = new ScrollingBackground();
		this.add(background);
		this.add(meteoriteSimple);
		vaisseau = new Spacecraft();
		this.add(vaisseau);

		ScrollingBackground bg = new ScrollingBackground();
		bg.setSize(new Dimension(Constante.WIDTH, Constante.HEIGHT));
		add(bg);

		new Thread(new Runnable() {
			int k = Integer.MAX_VALUE;

			public void run() {
				while (k > 0) {
					movingMeteorite(meteoriteSimple.getX(), meteoriteSimple.getY(), meteoriteSimple);
					movingMeteorite(meteoriteDeFeu.getX(), meteoriteDeFeu.getY(), meteoriteDeFeu);
					movingMeteorite(meteoriteDeGlace.getX(), meteoriteDeGlace.getY(), meteoriteDeGlace);
					movingMeteorite(meteoriteZigzag.getX(), meteoriteZigzag.getY(), meteoriteZigzag);
					movingMeteorite(meteoriteIceberg.getX(), meteoriteIceberg.getY(), meteoriteIceberg);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					k--;
				}
			}

		}).start();
	}

	boolean goRight = true;

	public void movingMeteorite(int x, int y, Meteorite meteorite) {
		y += meteorite.getVitesse();
		if (meteorite instanceof MeteoriteZigzag) {
			x %= Constante.WIDTH;
			if (x + 50 < Constante.WIDTH && goRight && goRight) {
				goRight = false;
			} else {
				goRight = false;
			}

			x += (x + 50 >  ? -50 : 50;

		}
		if (y % Constante.HEIGHT == 0) {
			y = 0;
			x = randomX.nextInt(Constante.WIDTH);
		}
		meteorite.setLocation(x, y % Constante.HEIGHT);
	}

	public Spacecraft getVaisseau() {
		return vaisseau;
	}
}