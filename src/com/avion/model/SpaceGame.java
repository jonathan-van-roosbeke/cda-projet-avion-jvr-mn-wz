package com.avion.model;

import java.util.Random;

import javax.swing.JLabel;

import com.avion.constante.Constante;
import com.avion.meteorite.Meteorite;
import com.avion.view.GuiClavier;

public class SpaceGame extends JLabel {
	private GuiClavier clavier;
	private Spacecraft vaisseau;

	public SpaceGame(GuiClavier pClavier) {

//		ScrollingBackground sb = new ScrollingBackground();
//		add(sb);
//		this.setBackground(Color.YELLOW);
		this.add(new ScrollingBackground());
		this.setLayout(null);
		Random x = new Random();
		Meteorite m1 = Meteorite.meteorites.get(0);
		Meteorite m2 = Meteorite.meteorites.get(1);
		Meteorite m3 = Meteorite.meteorites.get(2);
		Meteorite m4 = Meteorite.meteorites.get(3);
		Meteorite m5 = Meteorite.meteorites.get(4);
		m2.setLocation(x.nextInt(Constante.WIDTH) - 50, -100);
		m3.setLocation(x.nextInt(Constante.WIDTH) - 50, -300);
		m4.setLocation(x.nextInt(Constante.WIDTH) - 50, -600);
		m5.setLocation(x.nextInt(Constante.WIDTH) - 50, -800);
		this.add(m1);
		this.add(m2);
		this.add(m3);
		this.add(m4);
		this.add(m5);

		this.clavier = pClavier;
		this.setLayout(null);

		ScrollingBackground background = new ScrollingBackground();
		this.add(background);
		this.add(m1);

		vaisseau = new Spacecraft();
		this.add(vaisseau);

		new Thread(new Runnable() {
			int x1 = x.nextInt(Constante.WIDTH - m1.getTaille()) + 25;
			int x2 = x.nextInt(Constante.WIDTH - m1.getTaille()) + 25;
			int x3 = x.nextInt(Constante.WIDTH - m1.getTaille()) + 25;
			int x4 = x.nextInt(Constante.WIDTH - m1.getTaille()) + 25;
			int y1 = 0;
			int y2 = 0;
			int y3 = 0;
			int y4 = 0;
			int k = Integer.MAX_VALUE;

			public void run() {
				while (k > 0) {
					y1 += m1.getVitesse();
					y2 += m2.getVitesse();
					y3 += m3.getVitesse();
					y4 += m4.getVitesse();
					if (y1 % Constante.HEIGHT == 0) {
						y1 = 0;
						x1 = x.nextInt(Constante.WIDTH);
					}
					if (y2 % Constante.HEIGHT == 0) {
						y2 = 0;
						x2 = x.nextInt(Constante.WIDTH);
					}
					if (y3 % Constante.HEIGHT == 0) {
						y3 = 0;
						x3 = x.nextInt(Constante.WIDTH);
					}
					if (y4 % Constante.HEIGHT == 0) {
						y4 = 0;
						x4 = x.nextInt(Constante.WIDTH);
					}
					m1.setLocation(x1, y1 % Constante.HEIGHT);
					m2.setLocation(x2, y2 % Constante.HEIGHT);
					m3.setLocation(x3, y3 % Constante.HEIGHT);
					m4.setLocation(x4, y4 % Constante.HEIGHT);
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

	public Spacecraft getVaisseau() {
		return vaisseau;
	}
}