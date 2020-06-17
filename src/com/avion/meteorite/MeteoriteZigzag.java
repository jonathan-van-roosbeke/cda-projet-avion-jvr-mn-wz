package com.avion.meteorite;

import com.avion.constante.NoAnimatedPictures;

public class MeteoriteZigzag extends Meteorite {

	public MeteoriteZigzag() {
		super();
	}

	@Override
	public int getVitesse() {
		return Properties.METEORITE_ZIGZAG.getVitesse();
	}

	@Override
	public int getTaille() {
		return Properties.METEORITE_ZIGZAG.getTaille();
	}

	@Override
	public int getDegat() {
		return Properties.METEORITE_ZIGZAG.getDegat();
	}

	@Override
	public int getValeur() {
		return Properties.METEORITE_ZIGZAG.getValeur();

	}

	@Override
	public NoAnimatedPictures getImageUrl() {
		return NoAnimatedPictures.METEOR_ZIGZAG;
	}
}
