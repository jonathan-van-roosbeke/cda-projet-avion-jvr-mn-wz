package com.avion.meteorite;

import com.avion.constante.NoAnimatedPictures;

public class MeteoriteIceberg extends Meteorite {

	public MeteoriteIceberg() {
		super(NoAnimatedPictures.METEOR_ICEBERG);
	}

	@Override
	public int getVitesse() {
		return 200;
	}

	@Override
	public int getTaille() {
		return 200;
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
