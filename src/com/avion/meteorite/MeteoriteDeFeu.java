package com.avion.meteorite;

import com.avion.constante.NoAnimatedPictures;

public class MeteoriteDeFeu extends Meteorite {
	public MeteoriteDeFeu() {
		super();
	}

	@Override
	public int getVitesse() {
		return MeteoritesProperties.METEORITE_DE_FEU.getVitesse();
	}

	@Override
	public int getTaille() {
		return MeteoritesProperties.METEORITE_DE_FEU.getTaille();
	}

	@Override
	public int getDegat() {
		return MeteoritesProperties.METEORITE_DE_FEU.getDegat();
	}

	@Override
	public int getScore() {
		return MeteoritesProperties.METEORITE_DE_FEU.getScore();
	}

	@Override
	public NoAnimatedPictures getImageUrl() {
		return NoAnimatedPictures.METEOR_FEUX;
	}
}
