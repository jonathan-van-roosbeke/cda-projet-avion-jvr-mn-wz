package com.avion.model;

import java.awt.Dimension;

import javax.swing.JLabel;

import com.avion.constante.Constante;
import com.avion.meteorite.Meteorite;

public class SpaceGame extends JLabel {
	private Spacecraft vaisseau;

	public SpaceGame() {

		vaisseau = new Spacecraft();
		for (Meteorite meteorite : Meteorite.meteorites) {
			this.add(new MeteoritesMoving(meteorite, vaisseau));
		}
		this.setLayout(null);
		ScrollingBackground background = new ScrollingBackground();
		this.add(background);
		this.add(vaisseau);
		ScrollingBackground bg = new ScrollingBackground();
		bg.setSize(new Dimension(Constante.WIDTH, Constante.HEIGHT));
		add(bg);

	}

	public Spacecraft getVaisseau() {
		return vaisseau;
	}
}