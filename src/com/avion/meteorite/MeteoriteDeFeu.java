package com.avion.meteorite;

import com.avion.constante.NoAnimatedPictures;

public class MeteoriteDeFeu extends Meteorite {
	public MeteoriteDeFeu() {
		super(NoAnimatedPictures.METEOR_FEUX);
	}

	@Override
	public int getVitesse() {
		return 50;
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
