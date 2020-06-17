package com.avion.meteorite;

import com.avion.constante.NoAnimatedPictures;

public class MeteoriteZigzag extends Meteorite {

	public MeteoriteZigzag() {
		super(NoAnimatedPictures.METEOR_ZIGZAG);
	}

	@Override
	public int getVitesse() {
		return 50;
	}

	@Override
	public int getTaille() {
		return 70;
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
