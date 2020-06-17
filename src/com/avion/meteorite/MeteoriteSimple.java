package com.avion.meteorite;

import com.avion.constante.NoAnimatedPictures;

public class MeteoriteSimple extends Meteorite {

	public MeteoriteSimple() {
		super(NoAnimatedPictures.METEOR_SIMPLE);
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
