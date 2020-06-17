package com.avion.model;

import javax.swing.JPanel;

import com.avion.constante.Constante;
import com.avion.view.GuiClavier;

public class SpaceGame extends JPanel {

	private static int width = Constante.WIDTH;
	private static int heigth = Constante.HEIGHT;
	private GuiClavier clavier;
	private Spacecraft vaisseau;

	public SpaceGame(GuiClavier pClavier) {
		this.clavier = pClavier;
		this.setLayout(null);

		ScrollingBackground background = new ScrollingBackground();
		this.add(background);
		MeteoritePanel m1 = new MeteoritePanel();
		this.add(m1);

		vaisseau = new Spacecraft();
		this.add(vaisseau);

		new Thread(new Runnable() {
			public void run() {
				while (true) {
					m1.setLocation(m1.getX(), (m1.getY() + 10) % width);
					m1.repaint();
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	public Spacecraft getVaisseau() {
		return vaisseau;
	}

}