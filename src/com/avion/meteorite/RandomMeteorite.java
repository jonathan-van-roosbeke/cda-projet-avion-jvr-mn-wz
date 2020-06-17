package com.avion.meteorite;

import javax.swing.JFrame;

import com.avion.model.Position;

public class RandomMeteorite extends JFrame {

	private MeteoriteSimple simple;

	public RandomMeteorite() {
		simple = new MeteoriteSimple(new Position());
		simple.setVisible(true);
		setSize(800, 800);
		setVisible(true);
		add(simple);
	}
}
