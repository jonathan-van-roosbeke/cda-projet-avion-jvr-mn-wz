package com.avion.meteorite;

import com.avion.constante.NoAnimatedPictures;

public class MeteoriteDeGlace extends Meteorite {
	private static int taille = 100;

	public MeteoriteDeGlace() {
		super();
	}

	@Override
	public int getVitesse() {
		return Properties.METEORITE_DE_GLACE.getVitesse();
	}

	@Override
	public int getDegat() {
		return Properties.METEORITE_DE_GLACE.getDegat();
	}

	@Override
	public int getTaille() {
		return Properties.METEORITE_DE_GLACE.getTaille();
	}

	@Override
	public int getValeur() {
		return Properties.METEORITE_DE_GLACE.getValeur();
	}

	@Override
	public NoAnimatedPictures getImageUrl() {
		return NoAnimatedPictures.METEOR_GLACE;
	}

}
