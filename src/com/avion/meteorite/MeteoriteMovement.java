package com.avion.meteorite;

import javax.swing.JPanel;

public class MeteoriteMovement {

	private JPanel meteorite;

	public MeteoriteMovement(JPanel meteorite) {
		this.meteorite = meteorite;

	}

	public void startMoving() {
		((Meteorite) meteorite).setPosition(10, 10);
	}
}
