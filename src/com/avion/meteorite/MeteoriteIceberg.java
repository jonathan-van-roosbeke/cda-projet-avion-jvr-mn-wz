package com.avion.meteorite;

import com.avion.constante.NoAnimatedPictures;

public class MeteoriteIceberg extends Meteorite {

	public MeteoriteIceberg() {
		super();
	}

	@Override
	public int getVitesse() {
		return Properties.METEORITE_ICEBERG.getVitesse();
	}

	@Override
	public int getTaille() {
		return Properties.METEORITE_ICEBERG.getTaille();
	}

	@Override
	public int getDegat() {
		return Properties.METEORITE_ICEBERG.getDegat();
	}

	@Override
	public int getValeur() {
		return Properties.METEORITE_ICEBERG.getValeur();
	}

	@Override
	public NoAnimatedPictures getImageUrl() {
		// TODO Auto-generated method stub
		return NoAnimatedPictures.METEOR_ICEBERG;
	}
}
