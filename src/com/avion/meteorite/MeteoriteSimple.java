package com.avion.meteorite;

import com.avion.constante.NoAnimatedPictures;

public class MeteoriteSimple extends Meteorite {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	public MeteoriteSimple() {
		super();
	}

	@Override
	public int getVitesse() {
		return MeteoritesProperties.METEORITE_SIMPLE.getVitesse();
	}

	@Override
	public int getTaille() {
		return MeteoritesProperties.METEORITE_SIMPLE.getTaille();
	}

	@Override
	public int getDegat() {
		return MeteoritesProperties.METEORITE_SIMPLE.getDegat();
	}

	@Override
	public int getScore() {
		return MeteoritesProperties.METEORITE_SIMPLE.getScore();
	}

	@Override
	public NoAnimatedPictures getImageUrl() {
		return NoAnimatedPictures.METEOR_SIMPLE;
	}

}
