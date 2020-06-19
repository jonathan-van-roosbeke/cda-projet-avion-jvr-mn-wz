package com.avion.model;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.avion.constante.Constante;
import com.avion.meteorite.Meteorite;

public class SpaceGame extends JLabel {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private static Spacecraft vaisseau;
	private static JLabel label;

	public SpaceGame(JFrame frame) {
		label = this;
		vaisseau = new Spacecraft();
		startGame(frame);

	}

	public static void startGame(JFrame frame) {
		label.removeAll();
		for (Meteorite meteorite : Meteorite.meteorites) {
			label.add(new MeteoritesMoving(meteorite, vaisseau, frame));
		}
		label.setLayout(null);
		ScrollingBackground background = new ScrollingBackground();
		label.add(background);
		label.add(vaisseau);
		ScrollingBackground bg = new ScrollingBackground();
		bg.setSize(new Dimension(Constante.WIDTH, Constante.HEIGHT));
		label.add(bg);
		label.repaint();
		label.revalidate();
	}

	public Spacecraft getVaisseau() {
		return vaisseau;
	}
}