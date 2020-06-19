package com.avion.meteorite;

import com.avion.constante.NoAnimatedPictures;

public class MeteoriteZigzag extends Meteorite {

	public MeteoriteZigzag() {
		super();
	}

	@Override
	public int getVitesse() {
		return MeteoritesProperties.METEORITE_ZIGZAG.getVitesse();
	}

	@Override
	public int getTaille() {
		return MeteoritesProperties.METEORITE_ZIGZAG.getTaille();
	}

	@Override
	public int getDegat() {
		return MeteoritesProperties.METEORITE_ZIGZAG.getDegat();
	}

	@Override
	public int getScore() {
		return MeteoritesProperties.METEORITE_ZIGZAG.getScore();

	}

	@Override
	public NoAnimatedPictures getImageUrl() {
		return NoAnimatedPictures.METEOR_ZIGZAG;
	}
}
