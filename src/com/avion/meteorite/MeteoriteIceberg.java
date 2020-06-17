package com.avion.meteorite;

import com.avion.constante.NoAnimatedPictures;

public class MeteoriteIceberg extends Meteorite {

	public MeteoriteIceberg() {
		super(NoAnimatedPictures.METEOR_ICEBERG);
	}

	@Override
	public int getVitesse() {
		return 100;
	}

	@Override
	public int getTaille() {
		return 100;
	}

	@Override
	public int getDegat() {
		return 0;
	}

	@Override
	public int getValeur() {
		return 0;
	}
}
