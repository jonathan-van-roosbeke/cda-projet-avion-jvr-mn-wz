package com.avion.meteorite;

import com.avion.constante.NoAnimatedPictures;

public class MeteoriteDeGlace extends Meteorite {
	private static int taille = 100;

	public MeteoriteDeGlace() {
		super(NoAnimatedPictures.METEOR_GLACE);
	}

	@Override
	public int getVitesse() {
		return 100;
	}

	@Override
	public int getDegat() {
		return 0;
	}

	@Override
	public int getTaille() {
		return 80;
	}

	@Override
	public int getValeur() {
		return 0;
	}

}
