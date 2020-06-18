package com.avion.meteorite;

import java.util.Random;

import com.avion.constante.NoAnimatedPictures;

public class MeteoriteDeGlace extends Meteorite {
	private static int taille;

	public MeteoriteDeGlace() {
		super();
		taille = new Random().nextInt(MeteoritesProperties.METEORITE_DE_FEU.getTaille())
				+ MeteoritesProperties.METEORITE_SIMPLE.getTaille();
	}

	@Override
	public int getVitesse() {
		return MeteoritesProperties.METEORITE_DE_GLACE.getVitesse();
	}

	@Override
	public int getDegat() {
		return MeteoritesProperties.METEORITE_DE_GLACE.getDegat();
	}

	@Override
	public int getTaille() {

		System.out.println(taille);
		return taille;
	}

	@Override
	public int getValeur() {
		return MeteoritesProperties.METEORITE_DE_GLACE.getValeur();
	}

	@Override
	public NoAnimatedPictures getImageUrl() {
		return NoAnimatedPictures.METEOR_GLACE;
	}

}
