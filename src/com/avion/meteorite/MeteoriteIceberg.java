package com.avion.meteorite;

import com.avion.constante.NoAnimatedPictures;

public class MeteoriteIceberg extends Meteorite {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	public MeteoriteIceberg() {
		super();
	}

	@Override
	public int getVitesse() {
		return MeteoritesProperties.METEORITE_ICEBERG.getVitesse();
	}

	@Override
	public int getTaille() {
		return MeteoritesProperties.METEORITE_ICEBERG.getTaille();
	}

	@Override
	public int getDegat() {
		return MeteoritesProperties.METEORITE_ICEBERG.getDegat();
	}

	@Override
	public int getScore() {
		return MeteoritesProperties.METEORITE_ICEBERG.getScore();
	}

	@Override
	public NoAnimatedPictures getImageUrl() {
		return NoAnimatedPictures.METEOR_ICEBERG;
	}
}
